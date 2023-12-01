package org.fasttrack.repository;

import org.fasttrack.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT p FROM Product p WHERE p.orderDB.id = :orderDBId")
    List<Product> findAllProductsBelongingToOrder(@Param("orderDBId") Integer orderDBId);
}
