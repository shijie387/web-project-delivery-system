package com.atshijie.service.impl;

import com.atshijie.dao.SysUserDao;
import com.atshijie.dao.impl.SysUserDaoImpl;
import com.atshijie.pojo.SysUser;
import com.atshijie.service.SysUserService;
import com.atshijie.util.MD5Util;

public class SysUserServiceImpl implements SysUserService {
    SysUserDao sysUserDao = new SysUserDaoImpl();

    @Override
    public int addNewUser(SysUser user) {
        user.setPassword(MD5Util.encrypt(user.getPassword()));
        return sysUserDao.addSysUser(user);
    }

    @Override
    public SysUser login(String username, String password) {
        SysUser sysUser = sysUserDao.findByUsernameAndPassword(username,MD5Util.encrypt(password));
        return sysUser;
    }
    @Override
    public int updatePasswordByUserId(SysUser sysUser, String oldPassword, String newPassword) {
        if(sysUser.getPassword().equals(MD5Util.encrypt(oldPassword))){
            // 调用dao 更新数据库
            // 返回一个大于0的整数
            return sysUserDao.updatePasswordByUserId(sysUser.getId(),MD5Util.encrypt(newPassword));
        }else{
            return 0;
        }
    }

}
