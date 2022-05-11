package com.nhom11.webseller.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.ui.ModelMap;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.core.io.Resource;
import com.nhom11.webseller.dto.CatergoryDto;
import com.nhom11.webseller.dto.ProductRequest;
import com.nhom11.webseller.model.Cart;
import com.nhom11.webseller.model.CartItem;
import com.nhom11.webseller.model.Catergory;
import com.nhom11.webseller.model.Product;
import com.nhom11.webseller.service.CartItemService;
import com.nhom11.webseller.service.CartService;
import com.nhom11.webseller.service.CatergoryService;
import com.nhom11.webseller.service.ManufacturerService;
import com.nhom11.webseller.service.ProductOptionService;
import com.nhom11.webseller.service.ProductService;
import com.nhom11.webseller.service.StorageService;
import org.springframework.http.HttpHeaders;

@Controller

public class HomeController{
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


	// @ModelAttribute(name = "catergories")
	// public List<CatergoryDto> getCatergories(){
	// 	List<Catergory> catergories = catergoryService.findAll();
	// 	List<CatergoryDto> catergoryDtos = new ArrayList<>();
	// 	for(Catergory catergory: catergories) {
	// 		CatergoryDto catergoryDto = new CatergoryDto();
	// 		BeanUtils.copyProperties(catergory, catergoryDto);
	// 	};
	// 	System.out.println("list"+catergoryDtos.toString());
	// 	return catergoryDtos;
	// }

	@ModelAttribute("catergories")
	public List<Catergory> getCatergories() {
		return catergoryService.findAll().stream().map(item -> {
			Catergory catergory = new Catergory();
			BeanUtils.copyProperties(item, catergory);
			return catergory;
		}).collect(Collectors.toList());
	}


	// @ModelAttribute("totalProduct")
	// public long getTotalProduct() {
	// 	Cart cart = cartService.findByUserName("khanhdii");
	// 	List<CartItem> cartItems = cartItemService.findByCartId(cart.getId());
	// 	return cartItems.size();
	// }



	// @GetMapping("/home")
	// public String showHome(){
	// 	return "index";
	// }
	@GetMapping("/home")
    public  String getAllProductsHome(ModelMap model) {
		List<Product> findAll = productService.findAll();
		List<Product> list = findAll;
		model.addAttribute("products",list);
		// ProductRequest dto = new ProductRequest();
		// model.addAttribute("products",dto);
    	return "index";

    }
	@GetMapping("home/images/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> transferFile(@PathVariable(name = "filename") String fileName) {
		Resource file = storageService.loadAsResoure(fileName);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
	}

	@GetMapping("home/user-donhang")
	public String showUserOrder(){
		return "user-donhang";
	}

	@GetMapping("home/about")
	public String showAbout(){
		return "about";
	}
	@GetMapping("home/contact")
	public String showContact(){
		return "contact";
	}



}