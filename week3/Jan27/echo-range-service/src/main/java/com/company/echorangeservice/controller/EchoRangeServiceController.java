package com.company.echorangeservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class EchoRangeServiceController {

    @RequestMapping(value = "/echo/{input}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public int echo (@PathVariable int input) throws IllegalAccessException {
        if (input <1 || input > 10) {
            throw new IllegalAccessException("Input must be between 1 and 10");
        }
        return input;
    }

}
