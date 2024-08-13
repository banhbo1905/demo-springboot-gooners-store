package com.laptrinhjavaweb.controller.authen;

import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.dto.RoleDTO;
import com.laptrinhjavaweb.service.impl.CategoryService;
import com.laptrinhjavaweb.service.impl.ProductService;
import com.laptrinhjavaweb.service.impl.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import java.util.ArrayList;
import java.util.List;

@Controller(value = "registerControllerOfAuthen")
public class RegisterController {
	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private UserService userService;


	@RequestMapping(value = "/authen/register", method = RequestMethod.GET)
	public ModelAndView registerPage(HttpServletRequest request, HttpSession session, @ModelAttribute("model") UserDTO model) {
		ModelAndView mav = new ModelAndView("authen/register");
		return mav;
	}

	@RequestMapping(value = "/authen/register", method = RequestMethod.POST)
	public String registerPage(HttpServletRequest request, HttpSession session, @ModelAttribute("userRegist") UserDTO userRegist,
							   @RequestParam(name = "email") String email,
							   @RequestParam(name = "userName") String userName, @RequestParam(name = "fullName") String fullName,
							   @RequestParam(name = "password") String password, @RequestParam(name = "repassword") String repassword) {
//
		if (userService.checkUserbyUsername(userName) == true) {
			request.setAttribute("error", "The username address is already exist!");
			return "authen/register";
		} else if (userService.checkUserbyEmail(email) == true) {
			request.setAttribute("error", "The email address is already exist!");
			return "authen/register";
		} else if (!password.equals(repassword)) {
			request.setAttribute("error", "The password do not match!");
			return "authen/register";
		} else {
			userRegist = userService.registerUser(userName, fullName, email, password);
			userService.save(userRegist);
		}
		
		session = request.getSession();
		return "authen/register_success";


	}
}
//	@RequestMapping(value = "/authen/register", method = RequestMethod.POST)
//	public String registerPage(HttpServletRequest request, @ModelAttribute("userdto") UserDTO userDto) {
//
//		userDto.setStatus(1);
//		userDto.setRoleCode("USER");
//
//		if(userService.checkUserbyEmail(userDto.getEmail())){
//			return "redirect:/authen/register?emailexist";
//		}
//
//		if(userService.checkUserbyUsername(userDto.getUserName())){
//			return "redirect:/authen/register?usernameexist";
//		}
//
//		if(userDto.getPassword().equals(userDto.getCheckPass())==false){
//			return "redirect:/authen/register?checkpass";
//		}
//
//
//		userService.save(userDto);
//		return "redirect:/authen/register?success";
//	}

//	@RequestMapping(value = "/authen/register_success", method = RequestMethod.GET)
//	public ModelAndView registerSuccessPage(HttpServletRequest request, HttpSession session, @ModelAttribute("model") UserDTO model) {
//		ModelAndView mav = new ModelAndView("authen/register_success");
//		return mav;
//	}
//
//	@RequestMapping(value = "/authen/register", method = RequestMethod.POST)
//	public ModelAndView registerPage(HttpServletRequest request, @ModelAttribute("model") UserDTO model, @RequestParam(name = "email") String email,
//									 @RequestParam(name = "userName") String userName, @RequestParam(name = "fullName") String fullName, @RequestParam(name = "password") String password,
//									 @RequestParam(name = "repassword") String repassword) {
//		ModelAndView mav = new ModelAndView("authen/register");
//		ModelAndView success = new ModelAndView("authen/register_success");
//
////		if (userService.checkUserbyEmail(email)) {
////			request.setAttribute("error", "The email address is already exist!");
////			return mav;
////		} else if (userService.checkUserbyUsername(username)) {
////			request.setAttribute("error", "The username is already exist!");
////			return mav;
////		} else {
////			if (!password.equals(repassword)) {
////				request.setAttribute("error", "The password do not match!");
////				request.setAttribute("email", email);
////				request.setAttribute("username", username);
////				request.setAttribute("fullname", fullname);
//////				return mav;
////			} else {
////				model.setUserName(userName);
////				model.setFullName(fullName);
////				model.setEmail(email);
////				model.setPassword(new BCryptPasswordEncoder().encode(password));
////				model.setRoleCode(roleCode);
////				model.setStatus(status);
//				model = userService.registerUser(userName,fullName,email,password);
//				userService.save(model);
////				request.setAttribute("success", "Register successfull");
////			}
////		}
////		HttpSession session = request.getSession();
//		return success;
//	}



