package com.nhom11.webseller.dto;

import com.nhom11.webseller.model.CartItem;
import com.nhom11.webseller.model.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {
    // private Product product;
    // private CartItem  cartItem;
    private String image;
    private String name;
    private String color;
    private double price;
    private int quantity;
}
