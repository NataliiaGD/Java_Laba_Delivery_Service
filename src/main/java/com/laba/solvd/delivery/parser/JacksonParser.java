package com.laba.solvd.delivery.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laba.solvd.delivery.domain.Customer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;

public class JacksonParser {
    static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }

    private static final Logger LOGGER = LogManager.getLogger(JacksonParser.class);

    public static void main(String[] args) throws IOException {
        File file = new File("src/main/resources/json/customer.json");
        ObjectMapper mapper = new ObjectMapper();
        Customer customer = mapper.readValue(file, Customer.class);
        LOGGER.info(customer);


    }
}
