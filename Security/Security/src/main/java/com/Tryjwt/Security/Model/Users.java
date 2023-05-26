package com.Tryjwt.Security.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Users {

    private int id;
    private String fname;
    private String lname;
    private String city;
    private String mobileNo;
    private String email;
    private String password;
    private String role;
}
