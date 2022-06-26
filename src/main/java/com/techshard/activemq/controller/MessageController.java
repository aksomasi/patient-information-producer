package com.techshard.activemq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import javax.jms.Queue;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class MessageController {

    @Autowired
    private Queue queue;

    @Autowired
    private JmsTemplate jmsTemplate;

    @GetMapping("message/{message}")
    public ResponseEntity<String> publish(@PathVariable("message") final String message){
        jmsTemplate.convertAndSend(queue, message);
        return new ResponseEntity(message, HttpStatus.OK);
    }
    
    @PostMapping("savePatient")
    public ResponseEntity<String> savePatient(@RequestBody Patient patient){
    	ObjectMapper objectMapper = new ObjectMapper();
    	objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS,false);
    	//here more config opts...
    	String carAsString = "";
    	try {
			carAsString = objectMapper.writeValueAsString(patient);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        jmsTemplate.convertAndSend(queue, carAsString);
        return new ResponseEntity("patient Saved", HttpStatus.OK);
    }

}
