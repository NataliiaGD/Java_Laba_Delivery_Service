package com.laba.solvd.delivery.parser;

import com.laba.solvd.delivery.domain.Customer;
import com.laba.solvd.delivery.domain.Payment;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class JAXBParser {
    static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }

    private static final Logger LOGGER = LogManager.getLogger(JAXBParser.class);

    public static void main(String[] args) throws JAXBException {
        File file = new File("src/main/resources/xml/customer.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Customer customer = (Customer) unmarshaller.unmarshal(file);
        LOGGER.info(customer);

        File file2 = new File("src/main/resources/xml/payment.xml");
        JAXBContext context = JAXBContext.newInstance(Payment.class);
        Unmarshaller unmarshaller2 = context.createUnmarshaller();
        MyAdapter myAdapter = new MyAdapter();
        unmarshaller2.setAdapter(myAdapter);
        Payment payment = (Payment) unmarshaller2.unmarshal(file2);
        LOGGER.info(payment);

    }
}
