package com.atshijie.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysUser implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private String nickname;
}
