package com.talking.clock;

import com.talking.clock.service.ClockService;
import com.talking.clock.service.RunScript;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.InjectMocks;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TestClockService {

	@Test
	void contextLoads() {
	}

	@Mock
	private RunScript runScript;

	@InjectMocks
	private ClockService clockService;

	@BeforeEach
	void setUp() {
		// Initialize mocks
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testInvalidTime(){
		String invalidtime = "35:00";
		Map<String,String> expectedResponse = new HashMap<>();
		expectedResponse.put("error","Invalid time format");
		Map<String, String> actualResponse = clockService.convertTimeToWords(invalidtime);
		assertEquals(expectedResponse,actualResponse);
	}

	@Test
	void testValidTime(){
      String validTime = "15:00";
	  String timeInWords = "Three o'clock";
		Map<String,String> actualResponse = clockService.convertTimeToWords(validTime);
		Map<String, String> expectedResponse = new HashMap<>();
		expectedResponse.put("timeInWords", timeInWords);
		assertEquals(expectedResponse,actualResponse);

	}

	@Test
	void testEdgeCaseValidTime(){
		String validTime = "00:00";
		String timeInWords = "Twelve o'clock";
		Map<String,String> actualResponse = clockService.convertTimeToWords(validTime);
		Map<String,String> expectedResponse = new HashMap<>();
		expectedResponse.put("timeInWords",timeInWords);
		assertEquals(expectedResponse,actualResponse);
	}

	@Test
	void testValidTimeWithDifferentMinutes() {
		String validTime = "14:30";
		String timeInWords = "Half past Two";
        Map<String,String> actualResponse = clockService.convertTimeToWords(validTime);
		Map<String,String> expectedResponse = new HashMap<>();
		expectedResponse.put("timeInWords",timeInWords);
		assertEquals(expectedResponse,actualResponse);
	}
}
