package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.entity.ProductEntity;
import com.laptrinhjavaweb.entity.RoleEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findOneByUserNameAndStatus(String name, int status);

//    @Query("select u from UserEntity u where  u.email =:e")
//    UserEntity findByEmail(@Param(value = "e") String email);
//
//    @Query("select u from UserEntity u where  u.userName =:un")
//    UserEntity findByUsername(@Param(value = "un")String username);

    UserEntity findById(long userId);

    UserEntity findOneById(long userId);

    UserEntity findByEmail(String email);
    UserEntity findByUserName(String username);
    List<UserEntity> findAllByRoles(RoleEntity roleEntity, Pageable pageable);
    List<UserEntity> findAllByRoles(RoleEntity roleEntity);


//    @Query("select u from UserEntity u  where u.roles in :roles")
//    List<UserEntity> searchUsers(List<RoleEntity> roles);
//
//    @Query("select u from UserEntity u where u.email like %?1% or u.fullName like %?1% or u.phone like %?1% or u.address like %?1%")
//    List<UserEntity> searchUsers(String keyword);
//
//    @Query("select count(u) as CountUser from UserEntity u where u.email like %?1% or u.fullName like %?1% or u.phone like %?1% or u.address like %?1%")
//    int countUsers(String keyword);


}
