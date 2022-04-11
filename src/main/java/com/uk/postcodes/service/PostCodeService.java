package com.uk.postcodes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uk.postcodes.entity.PostCode;
import com.uk.postcodes.repository.PostCodeRepository;

import java.util.List;

@Service
public class PostCodeService {
    @Autowired
    private PostCodeRepository repository;
    
    public PostCode savePostCode(PostCode postCode) {
        return repository.save(postCode);
    }    

    public List<PostCode> savePostCodes(List<PostCode> postCode) {
        return repository.saveAll(postCode);
    }

    public List<PostCode> getPostCodes() {
        return repository.findAll();
    }

    public PostCode getPostCodeById(int id) {
        return repository.findById(id).orElse(null);
    }

    public PostCode getPostCodeByOuterCode(String outerCode) {
        return repository.findByOuterCode(outerCode);
    }    
    
    public String deletePostCode(int id) {
        repository.deleteById(id);
        return "postcode was removed for ID: " + id;
    }

    public PostCode updatePostCode(PostCode postCode) {
    	PostCode existingPostCode = repository.findById(postCode.getId()).orElse(null);
        existingPostCode.setPostCode(postCode.getPostCode());
        
        existingPostCode.setOuterCode(postCode.getOuterCode());
        existingPostCode.setInnerCode(postCode.getInnerCode());
        return repository.save(existingPostCode);
    }    
    
    
}
