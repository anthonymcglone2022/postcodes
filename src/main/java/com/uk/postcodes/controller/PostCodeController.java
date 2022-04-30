package com.uk.postcodes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.uk.postcodes.entity.PostCode;
import com.uk.postcodes.service.*;

@RestController
public class PostCodeController {
	
    @Autowired
    private PostCodeService service;

    @PostMapping("/createPostCode")
    public PostCode addPostCode(@RequestBody PostCode postCode) {
	return service.savePostCode(postCode);
    }    

    @PostMapping("/deletePostCode/{postCode}")
    public Integer deletePostCode(@PathVariable String postCode) {
	return service.deletePostCode(postCode);
    }    

    @PostMapping("/updatePostCode")
    public boolean updatePostCode(@RequestBody PostCode postCode) {
        return service.updatePostCode(postCode);
    }

}
