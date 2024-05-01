package com.switfcart.productservice.services;

import com.switfcart.productservice.models.Product;
import com.switfcart.productservice.models.ProductImage;
import com.switfcart.productservice.models.enums.PRODUCT_TYPES;
import com.switfcart.productservice.repository.ProductDao;
import com.switfcart.productservice.utils.ImageUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;


@Service
public class ProductService {
    @Autowired
    ProductDao productDao;

    Logger logger = LoggerFactory.getLogger(ProductService.class);

    public Product[] getAllProduct() {
        logger.info("Get all products Service");
        return productDao.getAllProducts();
    }

    public Product getProduct(int id) {
        logger.info("Get product by id Service");
        return productDao.findProductById(id);
    }

    public Product[] getProductByType(String type) {
        logger.info("Get product by type Service " + PRODUCT_TYPES.valueOf(type).ordinal() + 1);
        return productDao.findProductByType(PRODUCT_TYPES.valueOf(type).ordinal() + 1);
    }

    public Product[] getFeaturedProducts() {
        logger.info("Get featured product Service");
        Product[] allProducts = this.getAllProduct();
        Arrays.sort(allProducts, (a, b) -> b.getDiscount() - a.getDiscount());
        int totalFeaturedProducts = Math.min(5, allProducts.length);
        Product[] featuredProducts = new Product[totalFeaturedProducts];
        System.arraycopy(allProducts, 0, featuredProducts, 0, totalFeaturedProducts);
        return featuredProducts;
    }

    public void addProduct(Product product, MultipartFile file) throws IOException, Exception {
        logger.info("Add product Service");
        ProductImage productImage = ImageUtils.generateProductImageFromFile(file);
        product.setProductImage(productImage);
        try {
            logger.info(String.valueOf(product));
            productDao.save(product);
        }
        catch (Exception err) {
            logger.error("Product not saved");
            throw new Exception(err);
        }
    }

    public Product[] getProductBySearchKey(String searchKey) {
        logger.info("getProductBySearchKey service");
        return productDao.findProductBySearchKey(searchKey);
    }
}
