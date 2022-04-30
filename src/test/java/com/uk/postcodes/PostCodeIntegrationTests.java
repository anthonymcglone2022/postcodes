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
import com.uk.postcodes.controller.PostCodeController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class PostCodeIntegrationTests {

	@Autowired
	PostCodeController postCodeController;

	@Test
	void createAPostCode() {
		PostCode postCode = new PostCode();
		postCode.setCode("PCRN 1ZZ");
		postCode.setInuse("Yes");
        	postCode.setDistrict("Pitcairn Islands");
		Object returnedPostCode = postCodeController.addPostCode(postCode);
	        Assertions.assertThat(returnedPostCode).isNotNull();
	}

	@Test
	void updateAPostCode() {
		PostCode postCode = new PostCode();
		postCode.setCode("AL9 7YZ");
		postCode.setInuse("No");
        	postCode.setDistrict("Welwyn Hatfield");
		Assertions.assertThat(postCodeController.updatePostCode(postCode)).isTrue();
	}

	@Test
	void deleteAPostCode() {
		Assertions.assertThat(postCodeController.deletePostCode("AL9 7ZG").intValue()).isEqualTo(1);
	}
}
