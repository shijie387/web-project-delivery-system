package com.atshijie.dao.impl;

import com.atshijie.dao.BaseDao;
import com.atshijie.dao.SysUserDao;
import com.atshijie.pojo.SysUser;

import java.util.List;

public class SysUserDaoImpl extends BaseDao implements SysUserDao {
    @Override
    public SysUser findByUsername(String username) {
        String sql = "select id,username,password,nickname from sys_user where username = ?";

        List<SysUser> userList = baseQuery(SysUser.class, sql, username);
        return userList != null && userList.size() > 0 ? userList.get(0):null;
    }

    @Override
    public int addSysUser(SysUser user) {
        String sql = "insert into sys_user values(default,?,?,?)";
        int i = baseUpdate(sql, user.getUsername(), user.getPassword(), user.getNickname());
        return i;
    }

    @Override
    public SysUser findByUsernameAndPassword(String username, String encrypt) {
        String sql ="select id,username,password,nickname from sys_user where username = ? and password = ?";
        List<SysUser> userList = baseQuery(SysUser.class, sql, username, encrypt);
        return userList != null && userList.size() > 0 ? userList.get(0):null;
    }
    @Override
    public int updatePasswordByUserId(Integer id, String newPassword) {
        String sql = """
                update
                    sys_user
                set
                    password = ?
                where 
                    id = ?
                """;
        return baseUpdate(sql,newPassword,id);
    }
}
