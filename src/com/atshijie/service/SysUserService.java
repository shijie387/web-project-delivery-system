package com.atshijie.service;

import com.atshijie.pojo.SysUser;

public interface SysUserService {

    int addNewUser(SysUser user);

    SysUser login(String username, String password);

    int updatePasswordByUserId(SysUser sysUser,String oldPassword, String newPassword);
}
