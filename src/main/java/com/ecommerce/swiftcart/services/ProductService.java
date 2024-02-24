package com.ecommerce.swiftcart.services;

import com.ecommerce.swiftcart.models.Product;
import com.ecommerce.swiftcart.models.ProductImage;
import com.ecommerce.swiftcart.models.ProductType;
import com.ecommerce.swiftcart.repository.ProductDao;
import com.ecommerce.swiftcart.repository.ProductTypeDao;
import com.ecommerce.swiftcart.sampleProducts.SampleProducts;
import com.ecommerce.swiftcart.utils.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Service
public class ProductService {
    @Autowired
    ProductDao productDao;

    @Autowired
    SampleProducts sampleProducts;

    @Autowired
    ProductTypeDao productTypeDao;

    public Product[] getAllProduct() {
        return productDao.getAllProducts();
    }

    public Product getProduct(int id) {
        return productDao.findProductById(id);
    }

    public Product[] getProductByType(String type) {
        return productDao.findProductByType(type);
    }

    public ProductType[] getAllProductType() {
        return productTypeDao.getAllDistinctProductCategories();
    }

    public Product[] getFeaturedProducts() {
        Product[] allProducts = this.getAllProduct();
        Arrays.sort(allProducts, (a, b) -> b.getDiscount() - a.getDiscount());
        int totalFeaturedProducts = Math.min(5, allProducts.length);
        Product[] featuredProducts = new Product[totalFeaturedProducts];
        System.arraycopy(allProducts, 0, featuredProducts, 0, totalFeaturedProducts);
        return featuredProducts;
    }

    public Product[] getCartItems() {
        List<Product> listOfFeaturedProducts = new ArrayList<>(sampleProducts.products);
        return listOfFeaturedProducts.subList(0, 5).toArray(new Product[0]);
    }

    public void addProduct(Product product, MultipartFile file) throws IOException, Exception {
        ProductImage productImage = ImageUtils.generateProductImageFromFile(file);
        product.setProductImage(productImage);
        try {
            System.out.println(product);
            productDao.save(product);
        }
        catch (Exception err) {
            throw new Exception(err);
        }
    }
}
