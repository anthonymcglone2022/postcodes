package com.uk.postcodes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.uk.postcodes.entity.PostCode;
import com.uk.postcodes.service.PostCodeService;

@RestController
public class PostCodeController {
	
    @Autowired
    private PostCodeService service;

    @PostMapping("/addPostCode")
    public PostCode addPostCode(@RequestBody PostCode postCode) {
        return service.savePostCode(postCode);
    }    
}
