package com.uk.postcodes.service;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uk.postcodes.entity.PostCode;
import com.uk.postcodes.repository.PostCodeRepository;

import java.util.List;

@Service
@Transactional
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

    public PostCode getPostCodeByCode(String code) {
        return repository.findByCode(code);
    }    
    
    public Integer deletePostCode(String postCode) {
        return repository.deleteByCode(postCode);
    }

    public boolean updatePostCode(PostCode postCode) {
        PostCode existingProduct = repository.findByCode(postCode.getCode());
	if(existingProduct == null) {
	    return false;
	}

        existingProduct.setInuse(postCode.getInuse());
        existingProduct.setDistrict(postCode.getDistrict());
        repository.save(existingProduct);
	return true;
    } 
}
