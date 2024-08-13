package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.dto.UserDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserService {
    UserDTO findOneByUserNameAndStatus(String name, int status);

    UserDTO save(UserDTO userDTO);

    void delete(long[] ids);
    List<UserDTO> findAll(Pageable pageable);
    List<UserDTO> findAll();

    List<UserDTO> findAllByRoles(Pageable pageable);

    UserDTO findById(long userId);

    UserDTO findByEmail(String email);

    UserDTO findByUserName(String username);

//    Boolean checkPasswordUser(String email,String password);
    Boolean checkUserbyEmail(String email);

    Boolean checkUserbyUsername(String username);

    UserDTO registerUser(String username, String fullname, String email, String password);

    int totalItem();

    int getTotalItem();


    List<UserDTO> searchUsers(String keyword);

    void updatePassword(String userName, String password);

}
