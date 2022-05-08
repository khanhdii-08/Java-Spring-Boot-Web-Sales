package com.nhom11.webseller.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Embeddable
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class CartItemPk implements Serializable{
	private static final long serialVersionUID = 1L;
	private long cart;
	private long product;
}
