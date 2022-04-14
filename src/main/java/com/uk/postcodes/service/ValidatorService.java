package com.uk.postcodes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValidatorService {
   
	String validatingRegex = "^(([A-Z]{1,2}[0-9][A-Z0-9]?|ASCN|STHL|TDCU|BBND|[BFS]IQQ|PCRN|TKCA) ?[0-9][A-Z]{2}|BFPO ?[0-9]{1,4}|(KY[0-9]|MSR|VG|AI)[ -]?[0-9]{4}|[A-Z]{2} ?[0-9]{2}|GE ?CX|GIR ?0A{2}|SAN ?TA1)$";
		
    	public String format(String postCode) {

		postCode = postCode.trim();

		if (postCode.length() < 5 || postCode.length() > 9) {
			return "The post code " + postCode + " should be between 5 and 9 characters";
		}

		postCode = postCode.toUpperCase();
		String outwardCode = postCode.substring(0, postCode.length() - 3);
		String inwardCode  = postCode.substring(postCode.length() - 3);
        	return outwardCode + " " + inwardCode;
    	}    

}
