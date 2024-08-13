package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjavaweb.entity.RoleEntity;

import java.util.List;

public interface RoleRepository extends JpaRepository<RoleEntity, Long>{
    RoleEntity findOneByCode(String code);

}
