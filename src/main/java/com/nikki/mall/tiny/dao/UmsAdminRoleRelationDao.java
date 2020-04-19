package com.nikki.mall.tiny.dao;

import com.nikki.mall.tiny.mbg.model.UmsPermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 后台用户与角色管理自定义dao
 */
public interface UmsAdminRoleRelationDao {
    /**
     * get the all permissions of user
     */
    List<UmsPermission> getPermissionList(@Param("adminId") Long adminId);
}
