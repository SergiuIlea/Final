package org.fasttrack.repository;

import org.fasttrack.model.OrderDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDBRepository extends JpaRepository<OrderDB, Integer> {

}
