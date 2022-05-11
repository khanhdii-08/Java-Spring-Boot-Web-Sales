package com.nhom11.webseller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nhom11.webseller.model.Cart;
@Repository
public interface CartRepository extends JpaRepository<Cart, Long>{
    @Query(value = "select * from carts where username = :username" , nativeQuery = true)
	Cart findByUserName(@Param(value = "username") String username);
}
