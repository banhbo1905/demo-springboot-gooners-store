package com.laptrinhjavaweb.api;

import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class UserAPI {
	
	@Autowired
	private IUserService userService;

//	@GetMapping(value = "/product")
//	public ProductOutput showNew(@RequestParam("page") int page,
//							 @RequestParam("limit") int limit) {
//		ProductOutput result = new ProductOutput();
//		result.setPage(page);
//		Pageable pageable = new PageRequest(page - 1, limit);
//		result.setListResult(newService.findAll(pageable));
//		result.setTotalPage((int) Math.ceil((double) (newService.totalItem()) / limit));
//		return result;
//	}

	@PostMapping(value = "/user")
	public UserDTO createUser(@RequestBody UserDTO model) {
		return userService.save(model);
	}
	
	@PutMapping(value = "/user/{id}")
	public UserDTO updateUser(@RequestBody UserDTO model, @PathVariable("id") long id) {
		model.setId(id);
		return userService.save(model);
	}
	
	@DeleteMapping(value = "/user")
	public void deleteUser(@RequestBody long[] ids) {
		userService.delete(ids);
	}
}
