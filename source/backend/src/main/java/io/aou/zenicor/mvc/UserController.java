package io.aou.zenicor.mvc;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping(value="/user", method= RequestMethod.GET)
    public String fetchUserByCredentials(@RequestParam("name") String name,
                                         @RequestParam("pass") String pass) {
        //if (UserService.hasUserWithCredentials(user, pass)) {
        //}
        return "true";
    }

}
