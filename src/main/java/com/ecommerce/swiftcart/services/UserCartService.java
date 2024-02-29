package com.ecommerce.swiftcart.services;

import com.ecommerce.swiftcart.models.Cart;
import com.ecommerce.swiftcart.models.MyUserDetails;
import com.ecommerce.swiftcart.models.Product;
import com.ecommerce.swiftcart.models.User;
import com.ecommerce.swiftcart.repository.CartDao;
import com.ecommerce.swiftcart.repository.ProductDao;
import com.ecommerce.swiftcart.repository.UserDao;
import com.ecommerce.swiftcart.utils.JwtUtilsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


@Service
public class UserCartService {
    @Autowired
    CartDao cartDao;
    @Autowired
    ProductDao productDao;
    @Autowired
    JwtUtilsService jwtUtilsService;
    @Autowired
    UserDao userDao;

    public Cart[] getCartItems() {
        String username = jwtUtilsService.getUsername();
        System.out.println(username);
        User user = userDao.findByUsername(username);
        System.out.println(cartDao.findByUserId(user.getId()));
        return cartDao.findByUserId(user.getId()).toArray(new Cart[0]);
    }

    public void addToCart(Integer productId) throws Exception {
        Product product = productDao.findProductById(productId);
        String username = jwtUtilsService.getUsername();
        System.out.println(username);
        User user = userDao.findByUsername(username);

        if (product != null && user != null) {
            Cart cart = cartDao.findByUserIdAndProductId(user.getId(), product.getId());

            try {
                if (cart == null) { // insert new produtc into cart
                    cartDao.save(new Cart(1, product, user));
                }
                else { // update quantity
                    cart.setQuantity(cart.getQuantity() + 1);
                    cartDao.save(cart);
                }
            }
            catch (Exception err) {
                throw new Exception(err);
            }
        }
        else {
            throw new Exception("Some error occured");
        }
    }

    public void removeItemFromCart(Integer productId) throws Exception {
        Product product = productDao.findProductById(productId);
        String username = jwtUtilsService.getUsername();
        System.out.println(username);
        User user = userDao.findByUsername(username);

        if (product != null && user != null) {
            Cart cart = cartDao.findByUserIdAndProductId(user.getId(), product.getId());
            try {
                cartDao.delete(cart);
            }
            catch (Exception err) {
                throw new Exception(err);
            }
        }
        else {
            throw new Exception("Some error occured");
        }
    }
}
