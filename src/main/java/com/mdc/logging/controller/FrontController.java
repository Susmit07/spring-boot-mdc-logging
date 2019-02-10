package com.mdc.logging.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mdc.logging.service.BackendService;

@RestController
public class FrontController {

    private static final Logger LOG = LoggerFactory.getLogger(FrontController.class);

    @Autowired
    private BackendService backendService;

    @RequestMapping("/greetings/{caller}")
    public String getGreeting(@PathVariable("caller") String callerName) {
        LOG.info("Request received. PathVariable is: [{}]", callerName);
        return backendService.getData(callerName);
    }
}
