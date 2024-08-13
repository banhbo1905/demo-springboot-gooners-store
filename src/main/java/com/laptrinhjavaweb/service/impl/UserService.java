package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.converter.UserConverter;
import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.entity.*;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.CategoryRepository;
import com.laptrinhjavaweb.repository.RoleRepository;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDTO findOneByUserNameAndStatus(String name, int status) {
        UserEntity user = userRepository.findOneByUserNameAndStatus(name, status);
        return userConverter.convertToDto(user);
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        if(userDTO.getId() != null){
            UserEntity oldUserEntity = userRepository.findById(userDTO.getId()).orElse(null);
            userEntity = userConverter.convertToEntity(userDTO, oldUserEntity);
        } else {
            userEntity = userConverter.convertToEntity(userDTO);
        }
        ArrayList<RoleEntity> setRoleEntity = new ArrayList<>();
        RoleEntity roleEntity = roleRepository.findOneByCode(userDTO.getRoleCode());
        setRoleEntity.add(roleEntity);
        userEntity.setRoles(setRoleEntity);
        userEntity = userRepository.save(userEntity);
        return userConverter.convertToDto(userEntity);
    }

    @Override
    public void delete(long[] ids) {
        for(long item: ids) {
            userRepository.deleteById(item);
        }
    }

    @Override
    public List<UserDTO> findAll(Pageable pageable) {
        List<UserDTO> results = new ArrayList<>();
        List<UserEntity> entities = userRepository.findAll(pageable).getContent();
        for (UserEntity item: entities) {
            UserDTO userDTO = userConverter.convertToDto(item);
            results.add(userDTO);
        }
        return results;
    }

    @Override
    public List<UserDTO> findAll() {
        List<UserDTO> results = new ArrayList<>();
        List<UserEntity> entities = userRepository.findAll();
        for (UserEntity item: entities) {
            UserDTO userDTO = userConverter.convertToDto(item);
            results.add(userDTO);
        }
        return results;
    }


    @Override
    public List<UserDTO> findAllByRoles(Pageable pageable) {
        RoleEntity roleEntity = roleRepository.findOneByCode("USER");
        List<UserDTO> results = new ArrayList<>();
        List<UserEntity> entities = userRepository.findAllByRoles(roleEntity, pageable);
        for (UserEntity item: entities) {
            UserDTO userDTO = userConverter.convertToDto(item);
            results.add(userDTO);
        }
        return results;
    }

    @Override
    public UserDTO findById(long userId) {
        UserDTO userDTO = new UserDTO();
        UserEntity userEntity = userRepository.findById(userId);
        userDTO = userConverter.convertToDto(userEntity);
        return userDTO;
    }

    @Override
    public UserDTO findByEmail(String email) {
        UserDTO userDTO = new UserDTO();
        UserEntity userEntity = userRepository.findByEmail(email);
        userDTO = userConverter.convertToDto(userEntity);
        return userDTO;
    }

    @Override
    public UserDTO findByUserName(String username) {
        UserDTO userDTO = new UserDTO();
        UserEntity userEntity = userRepository.findByUserName(username);
        userDTO = userConverter.convertToDto(userEntity);
        return userDTO;
    }

//    @Override
//    public Boolean checkPasswordUser(String email, String password) {
//        UserDTO userDTO = new UserDTO();
//        UserEntity userEntity = userRepository.findByEmail(email);
//        userDTO = userConverter.convertToDto(userEntity);
//        if (userDTO.getPassword().equals(password)) return true;
//        return false;
//    }

    @Override
    public Boolean checkUserbyEmail(String email) {
        UserDTO userDTO = new UserDTO();
        UserEntity userEntity = userRepository.findByEmail(email);

//        userDTO = userConverter.convertToDto(userEntity);
        if(userEntity == null) return false;
        return true;
    }

    @Override
    public Boolean checkUserbyUsername(String username) {
        UserDTO userDTO = new UserDTO();
        UserEntity userEntity = userRepository.findByUserName(username);
//        userDTO = userConverter.convertToDto(userEntity);
        if(userEntity == null) return false;
        return true;
    }

    @Override
    public UserDTO registerUser(String username, String fullname, String email, String password) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName(username);
        userDTO.setFullName(fullname);
        userDTO.setEmail(email);
        userDTO.setPassword(new BCryptPasswordEncoder().encode(password));
        userDTO.setStatus(1);
        userDTO.setRoleCode("USER");
        return userDTO;
    }

    @Override
    public int totalItem() {
        return (int) userRepository.count();
    }

    @Override
    public int getTotalItem() {
        RoleEntity roleEntity = roleRepository.findOneByCode("USER");
        List<UserEntity> entities = userRepository.findAllByRoles(roleEntity);
        return entities.size();
    }

    @Override
    public List<UserDTO> searchUsers(String keyword) {
        RoleEntity roleEntity = roleRepository.findOneByCode("USER");
        List<UserDTO> results = new ArrayList<>();
        List<UserEntity> entities = userRepository.findAllByRoles(roleEntity);
        for (UserEntity item: entities) {
            if(item.getPhone()==null || item.getAddress()==null){
                if(item.getFullName().contains(keyword) == true || item.getEmail().contains(keyword) == true){
                    UserDTO userDTO = userConverter.convertToDto(item);
                    results.add(userDTO);
                }
            } else {
                if(item.getFullName().contains(keyword) == true
                        || item.getAddress().contains(keyword) == true
                        || item.getPhone().contains(keyword) == true
                        || item.getEmail().contains(keyword)== true){
                    UserDTO userDTO = userConverter.convertToDto(item);
                    results.add(userDTO);
                }
            }
        }
        return results;
    }

    @Override
    public void updatePassword(String userName, String password) {
        UserDTO userDTO = new UserDTO();
        UserEntity entity = userRepository.findByUserName(userName);
        entity.setPassword(new BCryptPasswordEncoder().encode(password));
        entity = userRepository.save(entity);
    }

}
