package com.pcc.sso.usercontroller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import com.pcc.sso.user.SsoUser;
import com.pcc.sso.userrepository.SsoUserRepository;


@RestController
@RequestMapping(path = "api/test_sso/")
public class SsoUserController {

    @Autowired
    private SsoUserRepository userRepo ;

    @GetMapping("sso_user_test")
    public List<SsoUser> getAllUsers() {
        return this.userRepo.findAll();
    }

    
    @PostMapping("sso_user_test" )
	public SsoUser addUser( @RequestBody SsoUser user ) {
        return userRepo.save(user);
	}

    

}
