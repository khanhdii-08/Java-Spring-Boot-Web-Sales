package com.nhom11.webseller.model;


import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "product_options")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductOption implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;


	@ManyToOne
	@JoinColumn(name = "product_id")
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Product product;
	private int quantity;
	private float price;
	private String color;
	private String sku;
	@Column(columnDefinition = "nvarchar(255)", nullable = false)
	private String image;

	@OneToMany(mappedBy = "cart", cascade =CascadeType.ALL)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private List<CartItem> cartItems;

	@OneToMany(mappedBy = "product", cascade =CascadeType.ALL)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private List<OrderDetail> orderDetails;
}
