package com.nhom11.webseller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.nhom11.webseller.model.CartItem;
import com.nhom11.webseller.model.CartItemPk;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, CartItemPk> {
    @Query(value = "select * from cart_item where cart_id = :cart_id" , nativeQuery = true)
	List<CartItem> findByCartId(@Param(value = "cart_id") Long cart_id);
}
