package com.nhom11.webseller.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nhom11.webseller.model.Cart;
import com.nhom11.webseller.repository.CartItemRepository;
import com.nhom11.webseller.repository.CartRepository;
import com.nhom11.webseller.repository.UserRepository;
import com.nhom11.webseller.service.CartService;
@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartRepository cartRepository;
	
	@Override
	public <S extends Cart> S save(S entity) {
		return cartRepository.save(entity);
	}

	@Override
	public List<Cart> findAll() {
		return cartRepository.findAll();
	}

	@Override
	public Page<Cart> findAll(Pageable pageable) {
		return cartRepository.findAll(pageable);
	}

	@Override
	public Optional<Cart> findById(Long id) {
		return cartRepository.findById(id);
	}

	@Override
	public <S extends Cart> Page<S> findAll(Example<S> example, Pageable pageable) {
		return cartRepository.findAll(example, pageable);
	}

	@Override
	public void deleteById(Long id) {
		cartRepository.deleteById(id);
	}

	@Override
	public void delete(Cart entity) {
		cartRepository.delete(entity);
	}

	@Override
	public Cart getById(Long id) {
		return cartRepository.getById(id);
	}
	@Override
	public Cart findByUserName(String username) {
		return cartRepository.findByUserName(username);
	}
	
	
}
