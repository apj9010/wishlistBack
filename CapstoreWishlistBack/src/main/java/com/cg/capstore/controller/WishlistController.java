package com.cg.capstore.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.capstore.bean.ProductBean;
import com.cg.capstore.bean.WishlistBean;
import com.cg.capstore.service.IWishlistService;

@RestController
public class WishlistController {
	
	@Autowired
	private IWishlistService service;
	
	@RequestMapping("/")
	public String transferControl() {
		return "Running Back ";
	}
 
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public ProductBean addProduct(@RequestBody Map<String, String> data)
	{
		System.err.println("(In Back Controller");
		System.err.println("Got Data..."+data.get("productId"));
		return service.addProduct(data.get("productId"), data.get("customerId"));
	}
	
	@RequestMapping(value="/display",method=RequestMethod.GET)
	public WishlistBean displayProductsFromWishlist(String email)
	{
		WishlistBean bean = service.displayProductsFromWishlist(email);
		System.err.println("Controller: Wishlist "+bean);
		return bean;
	}
	
	/*@RequestMapping(value="/display",method=RequestMethod.GET)
	public List<ProductBean> displayProductsFromWishlist(String email)
	{
		List<ProductBean> prod = service.displayProductsFromWishlist(email);
		System.err.println("Controller: Wishlist ");
		return prod;
	}*/
	
	
	@RequestMapping(value="/delete",method=RequestMethod.DELETE)
	public WishlistBean deleteProductsFromWishlist(String email,String productId)
	{
		return service.deleteProductsFromWishlist(email, productId);
	}
}
