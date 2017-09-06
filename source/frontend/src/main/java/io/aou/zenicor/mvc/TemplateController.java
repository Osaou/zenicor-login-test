package io.aou.zenicor.mvc;

import io.aou.zenicor.bi.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class TemplateController {

    private static String VIEW_NAME_LOGIN = "loginView";
    private static String VIEW_NAME_LOGGEDIN = "loggedInView";

    private boolean checkIfLoggedIn(HttpSession session, Model model) {
        String userName = (String) session.getAttribute("userName");

        if (userName != null) {
            model.addAttribute("userName", userName);
            return true;
        }

        return false;
    }



    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginView(HttpSession session, Model model) {
        if (checkIfLoggedIn(session, model)) {
            return VIEW_NAME_LOGGEDIN;
        }

        return VIEW_NAME_LOGIN;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String doLogin(@RequestParam("user") String user,
                          @RequestParam("pass") String pass,
                          HttpSession session,
                          HttpServletResponse response,
                          Model model) {
        if (checkIfLoggedIn(session, model)) {
            return VIEW_NAME_LOGGEDIN;
        }

        if (UserService.hasUserWithCredentials(user, pass)) {
            session.setAttribute("userName", user);
            model.addAttribute("userName", user);
            return VIEW_NAME_LOGGEDIN;
        }

        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return VIEW_NAME_LOGIN;
    }

}
