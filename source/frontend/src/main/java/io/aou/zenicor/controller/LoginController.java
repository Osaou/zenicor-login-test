package io.aou.zenicor.controller;

import io.aou.zenicor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@Controller
public class LoginController {

    private static final String VIEW_NAME_LOGIN = "loginView";
    private static final String VIEW_NAME_AUTHENTICATED = "authenticatedView";

    @Autowired
    private UserService userService;

    private boolean checkIfLoggedIn(HttpSession session, Model model) {
        final String userName = (String) session.getAttribute("userName");

        if (userName != null) {
            model.addAttribute("userName", userName);
            return true;
        }

        return false;
    }



    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginView(HttpSession session, Model model) {
        if (checkIfLoggedIn(session, model)) {
            return VIEW_NAME_AUTHENTICATED;
        }

        return VIEW_NAME_LOGIN;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String doLogin(@RequestParam("name") String name,
                          @RequestParam("pass") String pass,
                          HttpSession session,
                          HttpServletResponse response,
                          Model model) {
        if (checkIfLoggedIn(session, model)) {
            return VIEW_NAME_AUTHENTICATED;
        }

        if (userService.checkForUserWithCredentials(name, pass)) {
            session.setAttribute("userName", name);
            model.addAttribute("userName", name);
            return VIEW_NAME_AUTHENTICATED;
        }

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        return VIEW_NAME_LOGIN;
    }

}
