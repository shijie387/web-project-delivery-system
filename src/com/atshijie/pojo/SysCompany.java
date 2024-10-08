package com.atshijie.pojo;

import jakarta.servlet.annotation.WebServlet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysCompany implements Serializable {
    private Integer id;
    private String companyName;
}
