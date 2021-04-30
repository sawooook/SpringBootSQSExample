package com.example.SQS.controller;

import com.example.SQS.util.SQSCaller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageQueController {

    private final SQSCaller sqsCaller;

    public MessageQueController(SQSCaller sqsCaller) {
        this.sqsCaller = sqsCaller;
    }


    @PostMapping("/send")
    public ResponseEntity send(@RequestBody String message) {
        sqsCaller.sendMessage(message);
        return ResponseEntity.ok().build();
    }
}
