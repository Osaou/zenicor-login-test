package io.aou.zenicor.controller;

import io.aou.zenicor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class UserController {

    @Autowired
    private UserService userService;



    @RequestMapping(value="/user", method=RequestMethod.GET)
    public String hasUserWithCredentials(@RequestParam("name") String name,
                                         @RequestParam("pass") String pass) {
        return userService
                .findUserByCredentials(name, pass)
                .isPresent() ?
                    "true" : "false";
    }

}
