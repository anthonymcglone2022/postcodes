package com.uk.postcodes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.uk.postcodes.entity.PostCode;
import com.uk.postcodes.service.*;

@RestController
public class PostCodeController {
	
    @Autowired
    private PostCodeService service;

    @Autowired
    private ValidatorService validatorService;

    @PostMapping("/addPostCode")
    public PostCode addPostCode(@RequestBody PostCode postCode) {
        return service.savePostCode(postCode);
    }    

    @GetMapping("/formatPostCode/{postCode}")
    public String formatPostCode(@PathVariable String postCode) {
        return validatorService.format(postCode);
    }    
}
