package com.nhom11.webseller.service.impl;

import java.util.List;
import java.util.Optional;

import com.nhom11.webseller.model.CartItem;
import com.nhom11.webseller.model.CartItemPk;
import com.nhom11.webseller.repository.CartItemRepository;
import com.nhom11.webseller.service.CartItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CartItemServiceImpl implements CartItemService {
	@Autowired
	private CartItemRepository itemRepository;

	@Override
	public <S extends CartItem> S save(S entity) {
		return itemRepository.save(entity);
	}

	@Override
	public List<CartItem> findAll() {
		return itemRepository.findAll();
	}

	@Override
	public Optional<CartItem> findById(CartItemPk id) {
		return itemRepository.findById(id);
	}

	@Override
	public long count() {
		return itemRepository.count();
	}

	@Override
	public void delete(CartItem entity) {
		itemRepository.delete(entity);
	}

	@Override
	public void deleteAll() {
		itemRepository.deleteAll();
	}

	@Override
	public CartItem getById(CartItemPk id) {
		return itemRepository.getById(id);
	}

	public List<CartItem> findByCartId(Long cart_id) {
		return itemRepository.findByCartId(cart_id);
	}


}
