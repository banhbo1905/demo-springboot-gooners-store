package com.laptrinhjavaweb.controller.web;

import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.service.impl.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "ProductDetailsControllerOfWeb")
public class ProductDetailsController {
	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/chi-tiet-san-pham/{code}", method = RequestMethod.GET)
	public ModelAndView productDetailsPage(HttpServletRequest request, @ModelAttribute("model") ProductDTO model, @PathVariable("code") String code) {
		ModelAndView mav = new ModelAndView("web/product_details");
//		model = productService.findById(id);
//		mav.addObject("model", model);
		request.setAttribute("product", productService.findByCode(code));
		return mav;
	}

}
