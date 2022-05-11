package com.nhom11.webseller.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import com.nhom11.webseller.dto.CartDto;
import com.nhom11.webseller.dto.CartItemDto;
import com.nhom11.webseller.model.Cart;
import com.nhom11.webseller.model.CartItem;
import com.nhom11.webseller.model.Catergory;
import com.nhom11.webseller.model.Product;
import com.nhom11.webseller.model.ProductOption;
import com.nhom11.webseller.service.CartItemService;
import com.nhom11.webseller.service.CartService;
import com.nhom11.webseller.service.CatergoryService;
import com.nhom11.webseller.service.ManufacturerService;
import com.nhom11.webseller.service.ProductOptionService;
import com.nhom11.webseller.service.ProductService;
import com.nhom11.webseller.service.StorageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CatergoryService catergoryService;

	@Autowired
	private ManufacturerService manufacturerService;

	@Autowired
	private ProductService productService;

	@Autowired
	private StorageService storageService;

	@Autowired
	private ProductOptionService pOptionService;

	@Autowired
	private CartService cartService;

	@Autowired
	private CartItemService cartItemService;

	@ModelAttribute("catergories")
	public List<Catergory> getCatergories() {
		return catergoryService.findAll().stream().map(item -> {
			Catergory catergory = new Catergory();
			BeanUtils.copyProperties(item, catergory);
			return catergory;
		}).collect(Collectors.toList());
	}


	@GetMapping("/images/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> transferFile(@PathVariable(name = "filename") String fileName) {
		Resource file = storageService.loadAsResoure(fileName);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
	}

	@GetMapping({"/", ""})
	public String showCart(Model model){
		List<CartDto> cartDtos = new ArrayList<CartDto>();
		Cart cart = cartService.findByUserName("khanhdii");
		List<CartItem> cartItems = cartItemService.findByCartId(cart.getId());

		for(CartItem cartItem : cartItems){
			Optional<ProductOption> productOptionO = pOptionService.findById(cartItem.getProduct().getId());
			ProductOption productOption = productOptionO.get();
			Optional<Product> productO = productService.findById(cartItem.getProduct().getProduct().getId());
			Product product = productO.get();
			cartDtos.add(new CartDto(productOption.getImage(), product.getName(), productOption.getColor(), cartItem.getPrice(), cartItem.getQuantity()));
		}

		model.addAttribute("carts", cartDtos);
		return "giohang";
	}
}
