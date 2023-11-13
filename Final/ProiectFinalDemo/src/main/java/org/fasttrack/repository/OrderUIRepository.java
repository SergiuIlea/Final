package org.fasttrack.repository;

import org.fasttrack.model.OrderUI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderUIRepository extends JpaRepository<OrderUI, Integer> {
}
