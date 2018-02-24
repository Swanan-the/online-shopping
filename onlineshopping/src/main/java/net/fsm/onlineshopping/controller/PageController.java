package net.fsm.onlineshopping.controller;

import net.fsm.shoppingbackend.dao.CategoryDAO;
import net.fsm.shoppingbackend.dto.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	
	@Autowired
	private CategoryDAO categoryDAO;

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","home");
		
		// Passing categories list 
		mv.addObject("categories", categoryDAO.list());
		
		mv.addObject("userClickHome",true);
		return mv;
	}
	
	@RequestMapping(value = "/about")
	public ModelAndView about(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","About Us");
		mv.addObject("userClickAbout",true);
		return mv;
	}
	
	@RequestMapping(value = "/contact")
	public ModelAndView contact(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Contact Us");
		mv.addObject("userClickContact",true);
	    return mv;
	}
	
	
	// Methods to load all products based on category
	@RequestMapping(value= "/show/all/products")
	public ModelAndView showAllProducts(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","All Products");
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickAllProduct", true);
		
		return mv;
	}
	
	
	@RequestMapping(value= "show/category/{id}/products")
	public ModelAndView showCategoryProduct(@PathVariable("id") int id){
		
		ModelAndView mv = new ModelAndView("page");
		
		// categoryDAO to fetch a single category
		Category category = null;
		category = categoryDAO.get(id);
		
		mv.addObject("title", category.getName());
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("category", category);
		mv.addObject("userClickCategoryProduct", true);
		
		return mv;
	}
	
	

	/*
	@RequestMapping(value = { "/test" })
	public ModelAndView test(
			@RequestParam(value = "greeting", required = false) String greeting) {
		if (greeting == null) {
			greeting = "Hello Mag..!";
		}
		ModelAndView mvv = new ModelAndView("page");
		mvv.addObject("greeting", greeting);
		return mvv;
	}

	@RequestMapping(value = { "/test/{greeting}" })
	public ModelAndView tests(@PathVariable("greeting") String greeting) {
		if (greeting == null) {
			greeting = "Hello Mag sir...";
		}
		ModelAndView mvvv = new ModelAndView("page");
		mvvv.addObject("greeting", greeting);
		return mvvv;
	}
*/
	
	
}
