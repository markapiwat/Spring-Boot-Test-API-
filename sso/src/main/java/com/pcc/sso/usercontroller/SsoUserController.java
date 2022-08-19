package com.pcc.sso.usercontroller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pcc.sso.handler.GlobalExceptionHandler;
import com.pcc.sso.response.ResponseHandler;
import com.pcc.sso.response.SsoUserResponse;
import com.pcc.sso.user.SsoUser;
import com.pcc.sso.userrepository.SsoUserRepository;

import springfox.documentation.swagger2.annotations.EnableSwagger2;



@EnableSwagger2
@RestController
@RequestMapping(path = "api/test_sso/")
public class SsoUserController {

    @Autowired
    private SsoUserRepository userRepo ;

    @GetMapping("sso_user_test")
    public List<SsoUser> getAllUsers() {
        return this.userRepo.findAll();
    }

    
        @PostMapping("gettoken")
    public ResponseEntity<SsoUserResponse> addUser( @RequestBody SsoUser users , ResponseHandler handler) {
        

        SsoUserResponse res = handler.SaveComplete(users);

        try { 
            
            userRepo.save(users); 

            }catch (DataAccessException dex) {

                return new GlobalExceptionHandler().addException(dex, users);

            }catch (CannotCreateTransactionException ex){

                return new GlobalExceptionHandler().dbNotFoundException(ex, users);

            }

        return new ResponseEntity<>(res,HttpStatus.OK);
	    }

    

}
