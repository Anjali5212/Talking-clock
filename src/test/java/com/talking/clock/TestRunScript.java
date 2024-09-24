package com.talking.clock;

import com.talking.clock.service.RunScript;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TestRunScript {

	@Test
	void contextLoads() {
	}


	private RunScript runScript;

	@BeforeEach
	void setUp() {
		// Initialize mocks
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testInvalidScriptPath(){
		String invalidScriptPath = System.getProperty("user.dir") + "/invalid/path/talking-clock";
		boolean isValid = runScript.isValidScriptPath(invalidScriptPath);
		assertFalse(isValid, "Expected script path to be invalid or non-executable");
	}

	@Test
	public void testValidScriptPath(){
		String validScriptPath = System.getProperty("user.dir") + "/src/main/resources/talking-clock";
		boolean isValid = runScript.isValidScriptPath(validScriptPath);
		assertTrue(isValid, "Expected script path to be valid and executable");
	}
}