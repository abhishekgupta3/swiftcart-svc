package com.ecommerce.swiftcart.repository;

import com.ecommerce.swiftcart.models.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {

    @Autowired
    EntityManager entityManager;

    @Override
    @Transactional
    public void save(Product product) {
        entityManager.persist(product);
    }

    @Override
    public Product findProductById(int id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public Product[] findProductByType(String type) {
        TypedQuery<Product> query = entityManager.createQuery(
                "FROM Product WHERE type=:productType",
                Product.class
        );

        query.setParameter("productType", type);
        return query.getResultList().toArray(new Product[0]);
    }

    @Override
    public Product[] getAllProducts() {
        TypedQuery<Product> query = entityManager.createQuery(
                "FROM Product",
                Product.class
        );

        return query.getResultList().toArray(new Product[0]);
    }

}
