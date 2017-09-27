package com.spritle.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spritle.model.Product;
import com.spritle.service.ProductService;

@Controller
public class ProductController {
	private static final Logger logger = Logger
			.getLogger(ProductController.class);

	public ProductController() {
		System.out.println("ProductController class");
	}

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/")
	public ModelAndView listProduct(ModelAndView model) throws IOException {
		List<Product> listProduct = productService.getAllProducts();
		for(Product p:listProduct){
			System.out.println("checkin "+p.getName()+" "+p.getId()+" "+p.getDateOfPurchase());
		}
		model.addObject("listProduct", listProduct);
		model.setViewName("Home");
		return model;
	}

	@RequestMapping(value = "/newProduct", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
		Product product = new Product();
		model.addObject("product", product);
		model.setViewName("ProductForm");
		return model;
	}

	@RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute Product product) {
		System.out.println("saveProduct");
		if (product.getId() == 0) { // if employee id is 0 then creating the
			// employee other updating the employee
			productService.addProduct(product);
		} else {
			productService.updateProduct(product);
		}
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/deleteProduct", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(HttpServletRequest request) {
		int productId = Integer.parseInt(request.getParameter("id"));
		productService.deleteProduct(productId);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/editProduct", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		int productId = Integer.parseInt(request.getParameter("id"));
		Product product = productService.getProduct(productId);
		ModelAndView model = new ModelAndView("ProductForm");
		model.addObject("product", product);

		return model;
	}

}
