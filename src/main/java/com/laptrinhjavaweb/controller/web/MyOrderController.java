package com.laptrinhjavaweb.controller.web;

import com.laptrinhjavaweb.dto.ItemDTO;
import com.laptrinhjavaweb.dto.MyUserDetail;
import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.service.impl.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller(value = "myOrderControllerOfWeb")
public class MyOrderController {

    @Autowired
    CustomUserDetailsService customUserDetailsService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private ItemService itemService;


	private boolean isLogin = false;


    @RequestMapping(value = "/don-hang", method = RequestMethod.GET)
	public ModelAndView myOrderPage(HttpServletRequest request, HttpSession session, Model model, Principal principal) {
		ModelAndView mav = new ModelAndView("web/my_order");

		MyUserDetail userDetails = (MyUserDetail) customUserDetailsService.loadUserByUsername(principal.getName());
		request.setAttribute("orders", orderService.findAllByUserId(userDetails.getId()));

		return mav;

	}

	@RequestMapping(value = "/chi-tiet-don-hang", method = RequestMethod.GET)
	public ModelAndView orderDetailsPage(HttpServletRequest request, @RequestParam(name = "ma_don_hang") long orderId) {
		ModelAndView mav = new ModelAndView("web/order_details");

		List<ItemDTO> itemDTOs = itemService.findAllByOrderId(orderId);
		float subTotal = 0;
		int feeship = 25000;
		for (ItemDTO itemDTO : itemDTOs) {
			subTotal += (itemDTO.getUnitPrice() * itemDTO.getQuantity());

		}
		float grandTotal = subTotal + feeship;
		request.setAttribute("subTotal", subTotal);
		request.setAttribute("grandTotal", grandTotal);
		request.setAttribute("items", itemDTOs);
		return mav;

	}
}
