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

    @PostMapping("/deletePostCode/{postCode}")
    public Integer deletePostCode(@PathVariable String postCode) {
	return service.deletePostCode(postCode);
    }    

    @GetMapping("/regexValidate/{postCode}")
    public boolean regexValidationPostCode(@PathVariable String postCode) {
        return validatorService.regexValidate(postCode);
    }

    @GetMapping("/databaseValidate/{postCode}")
    public PostCode dbValidationPostCode(@PathVariable String postCode) {
        return validatorService.dbValidate(postCode);
    }
 
    @GetMapping("/formatPostCode/{postCode}")
    public String formatPostCode(@PathVariable String postCode) {
        return validatorService.format(postCode);
    }    
}
