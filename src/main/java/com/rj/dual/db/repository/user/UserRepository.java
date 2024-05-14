package com.rj.dual.db.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rj.dual.db.pojo.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
