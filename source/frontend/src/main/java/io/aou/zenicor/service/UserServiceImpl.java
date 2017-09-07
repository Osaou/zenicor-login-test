package io.aou.zenicor.service;

import io.aou.zenicor.net.HttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;



@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);



    @Override
    public boolean checkForUserWithCredentials(String name, String pass) {
        try {
            String ack = HttpRequest.GET("http://api:7070/user?name=" + name + "&pass=" + pass);
            logger.info("Successfully contacted API");
            logger.info(ack);
            return "true".equals(ack);
        }
        catch (IOException ioe) {
            logger.warn("Unable to contact API, reason:");
            logger.warn(ioe.getMessage());
            return false;
        }
    }

}
