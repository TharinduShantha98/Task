package API;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.MDC;

public class Demo {

    public static void main(final String[] args) {
        System.setProperty("ENV", "prod");
        Logger logger = LoggerFactory.getLogger(Demo.class);
        Map<String, String> customer = new HashMap<String, String>();

        customer.put("ssn", "856-45-6789");

        customer.put("customerName", "tharindu");


        //customer.put("officeEmail", "tha@email.com");

        customer.put("nic", "12345789v");
        customer.put("email", "admin@email.com");
        customer.put("AccountNumber", "1234567890");
        customer.put("OTP", "1020");
        customer.put("amount", "1000000");
        customer.put("address", "aluthgama");


        logger.info("Customer found : {}", new JSONObject(customer));



    }



}
