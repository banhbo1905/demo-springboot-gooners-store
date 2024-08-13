package com.laptrinhjavaweb.controller.admin;

import com.laptrinhjavaweb.dto.CategoryDTO;
import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.dto.RoleDTO;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.service.impl.UserService;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;

@Controller(value = "userControllerOfAdmin")
public class UserController {
    @Autowired
    private UserService userService;


    @RequestMapping(value = "/admin/user/list", method = RequestMethod.GET)
    public ModelAndView userListPage(@ModelAttribute("model") UserDTO model, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/user/list");
        String roleCode = "USER";
        int pageIndex = 1;
        if (request.getParameter("pageIndex") != null) {
            pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
        }
        Pageable pageable = PageRequest.of(pageIndex-1, model.getMaxPageItems());
        model.setListResult(userService.findAllByRoles(pageable));
        model.setTotalItems(userService.getTotalItem());
        mav.addObject("model", model);
        request.setAttribute("pageIndex", pageIndex);
        return mav;
    }


    @RequestMapping(value = "/admin/user/search", method = RequestMethod.GET)
    public ModelAndView searchListPage(@ModelAttribute("modelSearch") UserDTO modelSearch, HttpServletRequest request, @RequestParam("keyword") String keyword) {
        ModelAndView mav = new ModelAndView("admin/user/search");
        modelSearch.setListResult(userService.searchUsers(keyword));
        mav.addObject("modelSearch", modelSearch);
        request.setAttribute("keyword", keyword);
//        modelSearch.getTotalPages();
        return mav;
    }


    @RequestMapping(value = "/admin/user/edit", method = RequestMethod.GET)
    public ModelAndView userEditPage(HttpServletRequest request, @RequestParam(value = "id", required = false) Long id) {
        ModelAndView mav = new ModelAndView("admin/user/edit");
        return mav;
    }



    @RequestMapping(value = "/admin/user/edit", method = RequestMethod.POST)
    public String userEdit(HttpServletRequest request,
                                    @RequestParam(name = "email") String email,
                                    @RequestParam(name = "userName") String userName,
                                    @RequestParam(name = "fullName") String fullName,
                                    @RequestParam(name = "phone") String phone,
                                    @RequestParam(name = "address") String address,
                                    @RequestParam(name = "password") String password, @RequestParam(name = "repassword") String repassword) {


        if (userService.checkUserbyUsername(userName) == true) {
            request.setAttribute("message", "The username address is already exist!");
            return "admin/user/edit";
        } else if (userService.checkUserbyEmail(email) == true) {
            request.setAttribute("message", "The email address is already exist!");
            return "admin/user/edit";
        } else if (!password.equals(repassword)) {
            request.setAttribute("message", "The password do not match!");
            return "admin/user/edit";
        }
        else {
            UserDTO userCreate = userService.registerUser(userName, fullName, email, password);
            userCreate.setAddress(address);
            userCreate.setPhone(phone);
            userService.save(userCreate);
        }
        return "redirect:/admin/user/list";
    }

    @RequestMapping(value = "/admin/user/update", method = RequestMethod.GET)
    public ModelAndView userUpdatePage(HttpServletRequest request, @RequestParam(value = "userId", required = false) Long userId) {
        ModelAndView mav = new ModelAndView("admin/user/update");
        request.setAttribute("user", userService.findById(userId));
        return mav;
    }

    @RequestMapping(value = "/admin/user/update", method = RequestMethod.POST)
    public String userUpdate(HttpServletRequest request, @RequestParam(name = "userId") long userId,
                                      @RequestParam(name = "fullName", required = false) String fullName,
                                      @RequestParam(name = "address") String address,
                                      @RequestParam(name = "phone") String phone,
                                      @RequestParam(name = "status") int status,
                                      @RequestParam(name = "password", required = false) String password, @RequestParam(name = "repassword", required = false) String repassword) {

        ModelAndView mav = new ModelAndView("redirect:/admin/user/list");

        UserDTO userDTO = userService.findById(userId);

        if (password.equals(repassword) && password != null) {
            userDTO.setFullName(fullName);
            userDTO.setStatus(status);
            userDTO.setPhone(phone);
            userDTO.setAddress(address);
            userDTO.setPassword(new BCryptPasswordEncoder().encode(password));
            userService.save(userDTO);
        } else {
            request.setAttribute("message", "Password do not match!");
            request.setAttribute("user", userService.findById(userId));
            return "admin/user/update";
        }
        return "redirect:/admin/user/list";
    }
//
//
//    @RequestMapping(value = "/admin/product/delete", method = RequestMethod.GET)
//    public String productDelete(HttpServletRequest request) {
//        String[] productIds = request.getParameterValues("productId");
//        long [] productDelete = Arrays.stream(productIds).mapToLong(Long::parseLong).toArray();
//        userService.delete(productDelete);
//
//
//        return "redirect:/admin/product/list";
//    }

}
