package com.laptrinhjavaweb.controller.web;

import com.laptrinhjavaweb.dto.ItemDTO;
import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.service.IProductService;
import com.laptrinhjavaweb.service.impl.CategoryService;
import com.laptrinhjavaweb.service.impl.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller(value = "cartControllerOfWeb")
public class CartController {
	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public ModelAndView cartPage(HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView("web/cart");

		Object object = session.getAttribute("cart");
		int totalQuantity = 0;
		float subTotal = 0;
		float grandTotal = 0;
		int feeship = 25000;
		if (object != null) {
			HashMap<Long, ItemDTO> mapItem = (HashMap<Long, ItemDTO>) object;
			for(Map.Entry<Long, ItemDTO> entry : mapItem.entrySet()) {
				Long key = entry.getKey();
				ItemDTO value = entry.getValue();
				totalQuantity += value.getQuantity();
				subTotal += (value.getUnitPrice() * value.getQuantity());
			}
			grandTotal = subTotal + feeship;
		}
		session.setAttribute("totalQuantity", totalQuantity);
		session.setAttribute("subTotal", subTotal);
		session.setAttribute("grandTotal", grandTotal);
		return mav;
	}

	@RequestMapping(value = "/gio-hang", method = RequestMethod.POST)
	public ModelAndView addToCartPage(HttpServletRequest request, @RequestParam(name = "id") long id, @RequestParam(name = "quantity") int quantity, HttpSession session) {
		ModelAndView mav = new ModelAndView("redirect:/cart");

		ProductDTO productDTO = productService.findById(id);
		float unitPrice = productDTO.getPrice();

		Object object = session.getAttribute("cart");
		if (object == null) {
			ItemDTO itemsDTO = new ItemDTO();
			itemsDTO.setProductDTO(productDTO);
			itemsDTO.setQuantity(quantity);
			itemsDTO.setUnitPrice(unitPrice);
			Map<Long, ItemDTO> mapItem = new HashMap<Long, ItemDTO>();
			mapItem.put(id, itemsDTO);
			session.setAttribute("cart", mapItem);
		} else {
			Map<Long, ItemDTO> mapItem = (Map<Long, ItemDTO>) object;
			if (mapItem.get(id) == null) {
				ItemDTO itemsDTO = new ItemDTO();
				itemsDTO.setProductDTO(productDTO);
				itemsDTO.setQuantity(quantity);
				itemsDTO.setUnitPrice(unitPrice);
				mapItem.put(id, itemsDTO);
			} else {
				ItemDTO itemsDTO = mapItem.get(id);
				itemsDTO.setQuantity(quantity);
			}
			session.setAttribute("cart", mapItem);
		}

		return mav;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteItem(HttpServletRequest request, HttpSession session, @RequestParam(name = "productId") long productId) {
		ModelAndView mav = new ModelAndView("redirect:/cart");
		Object object = session.getAttribute("cart");
		Map<Long, ItemDTO> mapItem = (Map<Long, ItemDTO>) object;
		mapItem.remove(productId);
		session.setAttribute("cart", mapItem);
		return mav;
	}


}
