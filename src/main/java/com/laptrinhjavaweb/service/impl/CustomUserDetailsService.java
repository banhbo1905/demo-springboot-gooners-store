package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.dto.MyUserDetail;
import com.laptrinhjavaweb.dto.RoleDTO;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        UserDTO userDTO = userService.findByUserName(name);
        if(userDTO == null){
            throw new UsernameNotFoundException("Username not found");
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        for(RoleDTO role: userDTO.getRoles()){
            authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getCode()));
        }
        MyUserDetail myUserDetail = new MyUserDetail(name,userDTO.getPassword(),true,true,true,true,authorities);
        BeanUtils.copyProperties(userDTO, myUserDetail);
        return myUserDetail;
    }

//    @Autowired
//    private IUserService userService;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        UserDTO user = userService.findOneByUserNameAndStatus(username, 1);
//        if (user == null) {
//            throw new UsernameNotFoundException("user not found");
//        }
//
//        return new CustomUserDetail(user);
//
//    }
//    @Autowired
//    private IUserService userService;
//
//    @Override
//    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
//        UserDTO userDTO = userService.findOneByUserNameAndStatus(name, 1);
//        if(userDTO == null){
//            throw new UsernameNotFoundException("Username not found");
//        }
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        for(RoleDTO role: userDTO.getRoles()){
//            authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getCode()));
//        }
//        MyUserDetail myUserDetail = new MyUserDetail(name,userDTO.getPassword(),true,true,true,true,authorities);
//        BeanUtils.copyProperties(userDTO, myUserDetail);
//        return myUserDetail;
//    }
//

//    @Autowired
//    private UserService userService;
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        // TODO Auto-generated method stub
//        return loadUser(username);
//    }
//    private UserDetails loadUser(String username) {
//        UserDTO user = userService.findOneByUserNameAndStatus(username, 1);
//        System.out.println(user);
//        System.out.println(username);
//        if (user==null){
//            return null;
//        }
////        List<GrantedAuthority> authorities = new ArrayList<>();
//        Collection<GrantedAuthority> grantedAuthoritySet = new HashSet<>();
//
//        for(RoleDTO role: user.getRoles()){
//            grantedAuthoritySet.add(new SimpleGrantedAuthority("ROLE_"+role.getCode()));
//        }
//        return new CustomUserDetail(user, grantedAuthoritySet);
//    }
}
