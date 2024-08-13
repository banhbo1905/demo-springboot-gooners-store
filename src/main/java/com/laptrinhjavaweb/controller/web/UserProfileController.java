package com.laptrinhjavaweb.controller.web;

import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.service.impl.CustomUserDetailsService;
import com.laptrinhjavaweb.service.impl.ProductService;
import com.laptrinhjavaweb.service.impl.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller(value = "UserProfileControllerOfWeb")
public class UserProfileController {
	@Autowired
	CustomUserDetailsService customUserDetailsService;

	@Autowired
	private UserService userService;


	@RequestMapping(value = "/thong-tin-nguoi-dung", method = RequestMethod.GET)
	public ModelAndView profileFromCart(HttpServletRequest request, HttpSession session, Model model, Principal principal) {
		ModelAndView mav = new ModelAndView("web/user_profile");
		request.setAttribute("messageError", "Vui lòng cập nhật thông tin giao hàng.");
		return mav;
	}

	@RequestMapping(value = "/profile-from-cart", method = RequestMethod.GET)
	public ModelAndView userProfilePage(HttpServletRequest request, HttpSession session, Model model, Principal principal) {
		ModelAndView mav = new ModelAndView("web/user_profile");
		return mav;
	}

	@RequestMapping(value = "/update-profile", method = RequestMethod.POST)
	public String userProfileUpdate(HttpServletRequest request, Principal principal, @RequestParam(name = "phone") String phone, @RequestParam(name = "address") String address){

		UserDetails user = customUserDetailsService.loadUserByUsername(principal.getName());
		UserDTO userDTO = userService.findByUserName(user.getUsername());

		userDTO.setPhone(phone);
		userDTO.setAddress(address);
		userDTO.setRoleCode("USER");
		userService.save(userDTO);
		request.setAttribute("messageSuccess", "Cập nhật thành công.");
		return "web/user_profile";
	}


	@RequestMapping(value = "/change-password", method = RequestMethod.POST)
	public String changePassword(HttpServletRequest request, Principal principal, @RequestParam(name = "oldpassword") String oldpassword, @RequestParam(name = "newpassword") String newpassword, @RequestParam(name = "repassword") String repassword){

		UserDetails user = customUserDetailsService.loadUserByUsername(principal.getName());
		UserDTO userDTO = userService.findByUserName(user.getUsername());

		BCryptPasswordEncoder b = new BCryptPasswordEncoder();

		if (!b.matches(oldpassword, userDTO.getPassword())){
			request.setAttribute("error", "Mật khẩu không chính xác!");
			return "web/user_profile";
		} else if (!newpassword.equals(repassword)) {
			request.setAttribute("error", "Mật khẩu không trùng khớp!");
			return "web/user_profile";
		} else {
			userDTO.setPassword(new BCryptPasswordEncoder().encode(newpassword));
			userDTO.setRoleCode("USER");
			userService.save(userDTO);
			request.setAttribute("success", "Đổi mật khẩu thành công ");
		}

		return "web/user_profile";
	}




}
