package com.wasp.fidelity.church_secretaria_service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(properties = {
    "springdoc.api-docs.enabled=false",
    "springdoc.swagger-ui.enabled=false",
    "spring.flyway.enabled=false"
})
@ActiveProfiles("test")
class ChurchSecretariaServiceApplicationTests {

	@Test
	void contextLoads() {
	}

}
