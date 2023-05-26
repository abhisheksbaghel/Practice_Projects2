package com.Tryjwt.Security.auth.ExternalService;

import com.Tryjwt.Security.Model.Users;
//import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//@FeignClient(name="USER-SERVICE")
public interface UsersInterface {

    @PostMapping("/register")
    public String add(@RequestBody Users user);
}
