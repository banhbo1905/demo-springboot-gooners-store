package com.laptrinhjavaweb.controller.web;

import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.service.impl.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "ProductSearchControllerOfWeb")
public class ProductSearchController {
	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/tim-kiem-san-pham", method = RequestMethod.GET)
	public ModelAndView productGridPage(HttpServletRequest request, @ModelAttribute("model") ProductDTO model, @RequestParam("tukhoa") String tukhoa) {
		ModelAndView mav = new ModelAndView("web/product_search");

		int pageIndex = 1;
		if (request.getParameter("pageIndex") != null) {
			pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
		}

		model.setMaxPageItems(6);
		
		Pageable pageable = PageRequest.of(pageIndex-1, model.getMaxPageItems());
		model.setListResult(productService.searchProducts(tukhoa, pageable));
		model.setTotalItems(productService.getTotalItem(tukhoa));
		mav.addObject("modelSearch", model);
		request.setAttribute("pageIndex", pageIndex);
		request.setAttribute("tukhoa", tukhoa);
		return mav;
	}

}
