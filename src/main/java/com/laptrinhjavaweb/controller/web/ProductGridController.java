package com.laptrinhjavaweb.controller.web;

import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.service.impl.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "ProductGridControllerOfWeb")
public class ProductGridController {
	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/danh-muc-san-pham/{code}", method = RequestMethod.GET)
	public ModelAndView productGridPage(HttpServletRequest request, @ModelAttribute("model") ProductDTO model, @PathVariable("code") String code) {
		ModelAndView mav = new ModelAndView("web/product_grid");
//		model = productService.findById(id);
//		mav.addObject("model", model);
		request.setAttribute("productSortByCode", productService.findAllByCategoryCode(code));
		return mav;
	}

}
