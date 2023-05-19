package com.security.peso.repository;

import com.security.peso.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM users WHERE name = ?1", nativeQuery = true)
    Optional<User> findUserByName(String name);
}
