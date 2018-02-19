package net.fsm.onlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting",
				"Hello Mag! Welcome to cool world of Spring..!");
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
