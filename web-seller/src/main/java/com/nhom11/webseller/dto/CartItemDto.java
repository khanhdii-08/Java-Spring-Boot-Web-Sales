package com.nhom11.webseller.dto;

import java.util.List;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItemDto {

	private long idOption;
	private float price;
	private int quantity;
}
