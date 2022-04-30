package com.uk.postcodes;

import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;

import com.uk.postcodes.entity.PostCode;
import com.uk.postcodes.controller.ValidatorController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ValidatorIntegrationTests {

	@Autowired
	ValidatorController validatorController;

	@Test
	void validateACorrectPostCode() {
		Assertions.assertThat(validatorController.regexValidationPostCode("W5 1AT")).isTrue();
	}
}
