package io.aou.zenicor.bi;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public boolean checkForUserWithCredentials(String name, String pass) {
        try {
            String ack = fetchUserWithCredentials(name, pass);
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

    private String fetchUserWithCredentials(String name, String pass)
        throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet request = new HttpGet("http://api:7070/user?name=" + name + "&pass=" + pass);

        try {
            CloseableHttpResponse response = client.execute(request);

            try {
                BufferedReader rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent()));
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = rd.readLine()) != null) {
                    sb.append(line);
                }

                return sb.toString();
            }
            finally {
                response.close();
            }
        }
        finally {
            client.close();
        }
    }

}
