package com.uk.postcodes.components;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import com.uk.postcodes.service.*;
import com.uk.postcodes.entity.PostCode;

@Component
public class ListenForBootUp {
    private static final Logger LOG = LoggerFactory.getLogger(ListenForBootUp.class);

    @Autowired
    private PostCodeService postCodeService;

    private PostCode postCode;

    @Autowired
    private ValidatorService validatorService;

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        LOG.info("----------- READING IN POSTCODES --------------------");

	postCode = new PostCode();
	postCode.setPostCode("BND 1AT");
	postCode.setOuterCode("BND");
	postCode.setInnerCode("1AT");
	

	postCodeService.savePostCode(postCode);



        LOG.info("-----------------------------------------------------");
        LOG.info("----------- POSTCODES ADDED TO DB -------------------");


    }
}
