package com.SecurityLoginNCSCM.Security.Login.SecurityController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SecurityLoginNCSCM.Security.Login.SecurityModel.SigninEntity;
import com.SecurityLoginNCSCM.Security.Login.SecurityService.SecurityService;

@RestController
public class LoginController {

	@Autowired
	private SecurityService securityService;
	
	@PostMapping("/addUser")
    public String createUser(@RequestBody SigninEntity siginEntity) {
        boolean isTrue = securityService.createUser(siginEntity);
        return isTrue ? DocumentConstant.SUCCESS : DocumentConstant.UNSUCCESS;
    }
	
}
