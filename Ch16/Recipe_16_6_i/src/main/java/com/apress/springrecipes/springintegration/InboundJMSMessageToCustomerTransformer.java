package com.apress.springrecipes.springintegration;

import org.springframework.integration.annotation.Transformer;
import org.springframework.messaging.Message;

import java.util.Map;


public class InboundJMSMessageToCustomerTransformer {
    @Transformer
    public Customer transformJMSMapToCustomer(Message<Map<String, Object>> inboundSprignIntegrationMessage) {
        Map<String, Object> jmsMessagePayload = inboundSprignIntegrationMessage.getPayload();
        Customer customer = new Customer();
        customer.setFirstName((String) jmsMessagePayload.get("firstName"));
        customer.setLastName((String) jmsMessagePayload.get("lastName"));
        customer.setId((Long) jmsMessagePayload.get("id"));
        return customer;
    }
}
