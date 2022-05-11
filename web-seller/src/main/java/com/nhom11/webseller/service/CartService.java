package com.nhom11.webseller.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nhom11.webseller.model.Cart;

public interface CartService {

	Cart getById(Long id);

	void delete(Cart entity);

	void deleteById(Long id);

	<S extends Cart> Page<S> findAll(Example<S> example, Pageable pageable);

	Optional<Cart> findById(Long id);

	Page<Cart> findAll(Pageable pageable);

	List<Cart> findAll();

	<S extends Cart> S save(S entity);
	Cart findByUserName(String username);
}
