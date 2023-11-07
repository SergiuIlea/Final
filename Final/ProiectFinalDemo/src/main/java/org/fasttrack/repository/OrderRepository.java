package org.fasttrack.repository;

import org.aspectj.weaver.ast.Or;
import org.fasttrack.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PatchMapping;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
