package com.laptrinhjavaweb.controller.web;

import com.laptrinhjavaweb.dto.ItemDTO;
import com.laptrinhjavaweb.dto.MyUserDetail;
import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.entity.ItemEntity;
import com.laptrinhjavaweb.entity.OrderEntity;
import com.laptrinhjavaweb.entity.ProductEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.ItemRepository;
import com.laptrinhjavaweb.repository.OrderRepository;
import com.laptrinhjavaweb.service.impl.CategoryService;
import com.laptrinhjavaweb.service.impl.CustomUserDetailsService;
import com.laptrinhjavaweb.service.impl.ProductService;
import com.laptrinhjavaweb.service.impl.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.sql.Date;
import java.util.Map;

@Controller(value = "checkOutControllerOfWeb")
public class CheckOutController {
	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @Autowired
    private UserService userService;

	@Autowired
	private ItemRepository itemRepository;

    @Autowired
    private OrderRepository oderRepository;



    @RequestMapping(value = "/checkout", method = RequestMethod.POST)
	public ModelAndView checkOutPage(HttpServletRequest request, HttpSession session, Principal principal) {
//		ModelAndView mav = new ModelAndView("web/my_order");
		ModelAndView mav = new ModelAndView("redirect:/don-hang");

		float subTotal = 0; // tong tien hang
		float feeship = 25000; // phi ship = 25000 vnđ


		MyUserDetail userDetails = (MyUserDetail) customUserDetailsService.loadUserByUsername(principal.getName());
		// lay thong tin nguoi mua hang
		UserEntity user = new UserEntity();
		user.setId(userDetails.getId());

		Date date = new Date(new java.util.Date().getTime()); // lay ngay hien tai

		Object object = session.getAttribute("cart"); // lay danh sach gio hang tu session
		Map<Long, ItemDTO> mapItem = (Map<Long, ItemDTO>) object;

		for(Map.Entry<Long, ItemDTO> entry : mapItem.entrySet()) {
			Long key = entry.getKey();
			ItemDTO value = entry.getValue();

			subTotal += (value.getUnitPrice() * value.getQuantity()); // tinh tong tien hang
		}

		OrderEntity order = new OrderEntity();
		order.setBuyDate(date);
		order.setUser(user);
		order.setStatus("PENDING");
		order.setPriceTotal(subTotal + feeship);

        OrderEntity orderEntity = oderRepository.save(order);

		// insert danh sach san pham trong don hang vao bang item
		for(Map.Entry<Long, ItemDTO> entry : mapItem.entrySet()) {
			Long key = entry.getKey();
			ItemDTO value = entry.getValue();

			ProductEntity product = new ProductEntity();
			product.setId(entry.getValue().getProductDTO().getId());


			ItemEntity item = new ItemEntity();
			item.setId(entry.getValue().getId());
			item.setProduct(product);
			item.setQuantity(entry.getValue().getQuantity());
			item.setUnitPrice(entry.getValue().getUnitPrice());
			item.setOrder(order);

			// tru so luong san pham
			ProductDTO productDTO = productService.findById(product.getId());
			productDTO.setQuantity(productDTO.getQuantity() - item.getQuantity());
			productService.save(productDTO);

			// insert vao bang item
			ItemEntity itemEntity = itemRepository.save(item);
		}

		mapItem.clear();
		session.setAttribute("cart", mapItem);

		return mav;

	}
}
