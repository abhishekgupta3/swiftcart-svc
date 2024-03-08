package com.ecommerce.swiftcart.repository;

import com.ecommerce.swiftcart.models.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
    public Product[] findProductByType(int typeId) {
        TypedQuery<Product> query = entityManager.createQuery(
                "FROM Product p WHERE p.type=:typeId",
                Product.class
        );
        query.setParameter("typeId", typeId);
        return query.getResultList().toArray(new Product[0]);
    }

    @Override
    public Product[] getAllProducts() {
        TypedQuery<Product> query = entityManager.createQuery("FROM Product", Product.class);
        return query.getResultList().toArray(new Product[0]);
    }

    @Override
    public Product[] findProductBySearchKey(String searchKey) {
        TypedQuery<Product> query = entityManager.createQuery(
                "FROM Product p WHERE p.name LIKE :key", Product.class);
        query.setParameter("key", "%" + searchKey + "%");
        return query.getResultList().toArray(new Product[0]);
    }

}
