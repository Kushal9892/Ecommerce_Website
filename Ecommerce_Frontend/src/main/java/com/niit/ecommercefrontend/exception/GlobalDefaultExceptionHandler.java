package com.niit.ecommercefrontend.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handleNoHandLerFoundException() {
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "This page is not constructed!!");
		mv.addObject("errorDescription", "This page that you are looking for is not available now!!");
		mv.addObject("title", "404 Error Page");
		return mv;
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView ProductNotFoundException() {
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "Product not available!!");
		mv.addObject("errorDescription", "This product that you are looking for is not available now!!");
		mv.addObject("title", "Product not available!!");
		return mv;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception ex) {
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "Contact your administrator!!");
		// Only for Debugging!!
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		ex.printStackTrace(pw);
		mv.addObject("errorDescription", sw.toString());
		//mv.addObject("errorDescription", ex.toString());
		mv.addObject("title", "Error!!");
		return mv;
	}
}
