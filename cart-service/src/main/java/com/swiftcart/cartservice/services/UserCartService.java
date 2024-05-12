package com.swiftcart.cartservice.services;

import com.swiftcart.cartservice.client.ProductServiceClient;
import com.swiftcart.cartservice.client.UserServiceClient;
import com.swiftcart.cartservice.controller.CartController;
import com.swiftcart.cartservice.dto.ProductDto;
import com.swiftcart.cartservice.dto.UserDto;
import com.swiftcart.cartservice.entities.Cart;
import com.swiftcart.cartservice.entities.Product;
import com.swiftcart.cartservice.entities.ProductImage;
import com.swiftcart.cartservice.entities.User;
import com.swiftcart.cartservice.repository.CartDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;


@Service
public class UserCartService {
    @Autowired
    CartDao cartDao;
    @Autowired
    UserServiceClient userServiceClient;
    @Autowired
    ProductServiceClient productServiceClient;

    Logger logger = LoggerFactory.getLogger(UserCartService.class);

    public Cart[] getCartItems(String username) throws Exception {
        ResponseEntity<UserDto> responseEntity = null;
        try {
            responseEntity = userServiceClient.getUserByUsername(username);
        }
        catch (Exception err) {
            logger.error(String.valueOf(err));
            throw new Exception(err);
        }

        UserDto userDto = responseEntity.getBody();
        User user = new User(userDto);
        logger.info("Get cart item service " + user);
        return cartDao.findByUserId(user.getUserId()).toArray(new Cart[0]);
    }

    public void addToCart(Integer productId, String username) throws Exception {
        ProductDto productDto = null;
        try {
            productDto = productServiceClient.getProduct(productId).getBody();
        } catch (Exception err) {
            throw new Exception(err);
        }

        ResponseEntity<UserDto> responseEntity = null;
        try {
            responseEntity = userServiceClient.getUserByUsername(username);
        }
        catch (Exception err) {
            logger.error(String.valueOf(err));
            throw new Exception(err);
        }
        UserDto userDto = responseEntity.getBody();
        User user = new User(userDto);


        logger.info("ADD TO CART " + user);

        if (productDto != null && user != null) {
            Product product = new Product(productDto);
            ProductImage image = new ProductImage(productDto.getProductImage());

            product.setProductImage(image);

            logger.info("Product " + product);

            Cart cart = cartDao.findByUserIdAndPId(user.getUserId(), product.getProductId());
            logger.info("Current cart " + cart);

            try {
                if (cart == null) { // insert new product into cart
                    cartDao.save(new Cart(1, user.getUserId(), product.getProductId(), product, user));
                }
                else { // update quantity
                    cart.setQuantity(cart.getQuantity() + 1);
                    cartDao.save(cart);
                }
            }
            catch (Exception err) {
                logger.error(err.toString());
                throw new Exception(err);
            }
        }
        else {
            throw new Exception("Some error occured");
        }
    }

    public void removeItemFromCart(Integer productId, String username) throws Exception {
        ResponseEntity<UserDto> responseEntity = null;
        try {
            responseEntity = userServiceClient.getUserByUsername(username);
        }
        catch (Exception err) {
            logger.error(String.valueOf(err));
            throw new Exception(err);
        }
        UserDto userDto = responseEntity.getBody();
        User user = new User(userDto);

        System.out.println(productId);

        logger.info("REMOVE FROM CART " + user + " " + productId);

        Cart cart = cartDao.findByUserIdAndProductId(user.getUserId(), productId);
        logger.info("Current Cart " + cart);
        if (cart != null) {
            try {
                cartDao.delete(cart);
            }
            catch (Exception err) {
                logger.error(err.toString());
                throw new Exception(err);
            }
        } else {
            throw new Exception("Couldn't find cart item");
        }
    }
}
