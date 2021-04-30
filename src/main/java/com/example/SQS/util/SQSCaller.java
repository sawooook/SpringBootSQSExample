package com.example.SQS.util;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.SendMessageResult;
import com.example.SQS.config.AmazonSQSConfig;
import org.springframework.stereotype.Component;

@Component
public class SQSCaller {

    private final AmazonSQSConfig amazonSQSConfig;
    private final AmazonSQS amazonSQS;

    public SQSCaller(AmazonSQSConfig amazonSQSConfig, AmazonSQS amazonSQS) {
        this.amazonSQSConfig = amazonSQSConfig;
        this.amazonSQS = amazonSQS;
    }

    public SendMessageResult sendMessage(String message) {
        return amazonSQS.sendMessage(amazonSQSConfig.getUrl(), message);
    }
}
