package com.spring.batch.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetails {
    private static final Logger LOGGER = LoggerFactory.getLogger(ErrorDetails.class);

    private String errorMessage;
    private String orderId;
    private String timestamp;
    private String errorType;

    public String jsonObject() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        String strJsonObject = null;

        try {
            strJsonObject = objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            LOGGER.error("Error occurred: {}", e.getMessage());
        }

        return strJsonObject;
    }
}

