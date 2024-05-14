package com.rj.dual.db;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rj.dual.db.pojo.Order;
import com.rj.dual.db.pojo.User;
import com.rj.dual.db.repository.order.OrderRepository;
import com.rj.dual.db.repository.user.UserRepository;

@SpringBootTest
class DualDbConnectApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Test
	void saveUserDataInDB() {

		User user = new User();
		user.setEmail("johndoe@gmail.com");
		user.setFirstName("John");
		user.setLastName("DOe");

		User savedUser = userRepository.save(user);
		Optional<User> userData = userRepository.findById(savedUser.getId());
		assertTrue(userData.isPresent());

	}

	@Test
	void saveOrderDataInDB() {

		Order order = new Order();
		order.setProductName("Mobile");
		order.setOrderAmount(200);
		order.setUserId(1);

		Order savedOrder = orderRepository.save(order);
		Optional<Order> orderData = orderRepository.findById(savedOrder.getId());
		assertTrue(orderData.isPresent());
	}
}