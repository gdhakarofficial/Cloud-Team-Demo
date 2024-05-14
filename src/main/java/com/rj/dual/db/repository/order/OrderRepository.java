package com.rj.dual.db.repository.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rj.dual.db.pojo.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
}