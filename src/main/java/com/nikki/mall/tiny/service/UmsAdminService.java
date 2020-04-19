package com.nikki.mall.tiny.service;

import com.nikki.mall.tiny.mbg.model.UmsAdmin;
import com.nikki.mall.tiny.mbg.model.UmsPermission;

import java.util.List;

/**
 * 后台管理员service
 */
public interface UmsAdminService {
    /**
     * get admin from username
     */
    UmsAdmin getAdminByUsername(String username);

    /**
     * register
     */
    UmsAdmin register(UmsAdmin umsAdminParam);

    /**
     * login
     */
    String login(String username, String password);

    /**
     * get the all permissions of user
     */
    List<UmsPermission> getPermissionList(Long adminId);
}
