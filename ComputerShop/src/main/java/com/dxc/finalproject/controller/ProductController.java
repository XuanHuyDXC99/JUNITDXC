/*
	Code of me
*/
package com.dxc.finalproject.controller;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dxc.finalproject.dao.CategoryDAO;
import com.dxc.finalproject.dao.ProductDAO;
import com.dxc.finalproject.model.Brand;
import com.dxc.finalproject.model.Category;
import com.dxc.finalproject.model.Product;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired 
	private CategoryDAO categoryDAO;
	
	
	@GetMapping("/productlist")
	public ModelAndView productList() {
		ModelAndView mv = new ModelAndView("home");
		
		mv.addObject("userClickAllProduct",true);
		mv.addObject("products", productDAO.findAllProduct());
		return mv;
	}
	@GetMapping("/add")
	public ModelAndView add() {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("brands", productDAO.findAllBrand());
		mv.addObject("userClickAddProduct", true);
		return mv;
	}
	@PostMapping("/addProduct")
	public ModelAndView addProduct(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("redirect:/product/productlist");
		Brand brand = productDAO.getBrandByName(request.getParameter("brand"));
		Category category = categoryDAO.findCategoryByName(request.getParameter("category"));
		Product p = new Product(request.getParameter("pname"), new BigDecimal(request.getParameter("price")), 
										Integer.parseInt(request.getParameter("qty")), 
											category, brand);
		boolean b = productDAO.addProduct(p);
		return mv;
		
	}
	
	@GetMapping("/editProduct/{id}")
	public ModelAndView editProduct(@PathVariable("id") String id) {
		ModelAndView mv =  new ModelAndView("home");
		mv.addObject("userClickEditProduct", true);
		mv.addObject("brands", productDAO.findAllBrand());
		mv.addObject("product", productDAO.findProductById(Integer.parseInt(id)));
		return mv;
	}
	
	@PostMapping("/updateProduct")
	public ModelAndView updateProduct(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("redirect:/product/productlist");
		Brand brand = productDAO.getBrandByName(request.getParameter("brand"));
		Category category = categoryDAO.findCategoryByName(request.getParameter("category"));
		Product p = new Product(request.getParameter("pname"), new BigDecimal(request.getParameter("price")), 
										Integer.parseInt(request.getParameter("qty")), 
											category, brand);
		p.setPid(Integer.parseInt(request.getParameter("pid")));
		boolean b = productDAO.updateProduct(p);
		
		return mv;
	}
	@GetMapping("/deleteProduct/{id}")
	public ModelAndView deleteProduct(@PathVariable("id") String id, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("redirect:/product/productlist");
		Product p = productDAO.findProductById(Integer.parseInt(id));
		
		boolean b = productDAO.deleteProduct(p);
		
		return mv;
	}
	
	
}
