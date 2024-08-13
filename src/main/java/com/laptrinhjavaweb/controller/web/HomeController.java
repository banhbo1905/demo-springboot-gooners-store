package com.laptrinhjavaweb.controller.web;

import com.laptrinhjavaweb.dto.MyUserDetail;
import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.dto.UserPrincipal;
import com.laptrinhjavaweb.security.utils.SecurityUtils;
import com.laptrinhjavaweb.service.impl.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import java.security.Principal;

@Controller(value = "homeControllerOfWeb")
public class HomeController {
	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @Autowired
    private UserService userService;

	private boolean isLogin = false;


    @RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	public ModelAndView homePage(HttpServletRequest request, HttpSession session, Model model, Principal principal) {
		ModelAndView mav = new ModelAndView("web/home");

//            UserDetails user = customUserDetailsService.loadUserByUsername(principal.getName());
////            model.addAttribute("user", userDetails);
////		    MyUserDetail user = SecurityUtils.getPrincipal();
////			model.addAttribute("user", user);
//			if(user != null){
//				isLogin = true;
//			}


			if(principal == null){
				isLogin = false;
			}
			else {
				UserDetails user = customUserDetailsService.loadUserByUsername(principal.getName());
				session.setAttribute("user", user);
				isLogin = true;
			}
			session.setAttribute("isLogin", isLogin);
			request.setAttribute("hotproduct", productService.findAllByCategoryId(1));
			request.setAttribute("retro", productService.findAllByCategoryId(2));
			request.setAttribute("phukien", productService.findAllByCategoryId(3));
			request.setAttribute("aokhoac", productService.findAllByCategoryId(4));
			session.setAttribute("categories", categoryService.findAll());
			return mav;

	}



	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginPage(HttpSession session) {
		ModelAndView mav = new ModelAndView("login");
//		isLogin = true;
//		session.setAttribute("isLogin", isLogin);
		return mav;
	}
}
