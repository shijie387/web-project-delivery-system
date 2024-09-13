package com.atshijie.dao;

import com.atshijie.pojo.SysUser;

public interface SysUserDao {

    SysUser findByUsername(String username);

    int addSysUser(SysUser user);

    SysUser findByUsernameAndPassword(String username, String encrypt);

    int updatePasswordByUserId(Integer id, String newPassword);
}
