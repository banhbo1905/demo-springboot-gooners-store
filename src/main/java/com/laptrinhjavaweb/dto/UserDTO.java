package com.laptrinhjavaweb.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserDTO extends AbstractDTO<UserDTO>{

    private String userName;
    private String email;
    private String fullName;
    private String password;
    private String checkPass;
    private Integer status;
    private String phone;
    private String address;
    private String roleCode;
    private Map<String,String> roleDTOs;
    private List<RoleDTO> roles = new ArrayList<>();


    public UserDTO() {
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<RoleDTO> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleDTO> roles) {
        this.roles = roles;
    }

    public Map<String, String> getRoleDTOs() {
        return roleDTOs;
    }

    public void setRoleDTOs(Map<String, String> roleDTOs) {
        this.roleDTOs = roleDTOs;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getCheckPass() {
        return checkPass;
    }

    public void setCheckPass(String checkPass) {
        this.checkPass = checkPass;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
