package com.nhom11.webseller.service;

import java.util.List;
import java.util.Optional;

import com.nhom11.webseller.model.CartItem;
import com.nhom11.webseller.model.CartItemPk;

public interface CartItemService {

	CartItem getById(CartItemPk id);

	void deleteAll();

	void delete(CartItem entity);

	long count();

	Optional<CartItem> findById(CartItemPk id);

	List<CartItem> findAll();

	<S extends CartItem> S save(S entity);

	List<CartItem> findByCartId(Long cart_id);

}
