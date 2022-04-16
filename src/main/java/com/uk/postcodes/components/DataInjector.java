package com.uk.postcodes.components;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ClassPathResource;

import com.uk.postcodes.service.*;
import com.uk.postcodes.entity.PostCode;

import java.util.*;
import java.io.*;


@Component
public class DataInjector {
    private static final Logger LOG = LoggerFactory.getLogger(DataInjector.class);

    @Autowired
    private PostCodeService postCodeService;

    private PostCode postCode;

    @Autowired
    private ValidatorService validatorService;

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        LOG.info("----------- READING IN POSTCODES --------------------");

	List<PostCode> postCodes = new ArrayList<PostCode>();

        // The postcodes.csv file with all 2 million postcodes in the UK
	// This BufferedReader approach  will have to be optimised in order to quickly persist the post codes
        // The SQL tables might have to be split into letters of the alphabet, so A table would have all 
	// post codes that start with A.

	// Resource resource = new ClassPathResource("postcodes.csv");

	Resource resource = new ClassPathResource("test_postcodes.csv");

	try (BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
    		String line;
		String[] splitter;
		br.readLine();
    		while ((line = br.readLine()) != null) {
			postCode = new PostCode();
			LOG.info(line);
			postCode.setPostCode(line);
			splitter = line.split("\\s+");
			postCode.setOuterCode(splitter[0]);
			postCode.setInnerCode(splitter[1]);
	                postCodes.add(postCode);
       			
    		}
	} catch (Exception e) {
		e.printStackTrace(System.out);
	}

	postCodeService.savePostCodes(postCodes);

        LOG.info("-----------------------------------------------------");
        LOG.info("----------- POSTCODES ADDED TO DB -------------------");

    }
}
