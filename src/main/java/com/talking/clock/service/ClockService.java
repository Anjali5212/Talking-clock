package com.talking.clock.service;

import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.talking.clock.service.RunScript;

@Service
public class ClockService {
	
	
	public Map<String, String> convertTimeToWords(String time) {
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
		 Map<String, String> response = new HashMap<>();
		try {
			LocalTime.parse(time, timeFormatter);
		}
		catch (DateTimeParseException e){
			response.put("error", "Invalid time format");
			return response;
		}
		
		 RunScript script = new RunScript();
		 String scriptPath = System.getProperty("user.dir") + "/src/main/resources/talking-clock";
		 
	     try {
	        	Runtime.getRuntime().exec("chmod +x "+scriptPath);
	        }catch (IOException ex){
	        	 ex.printStackTrace();
	        }
	     List<String> scriptArgs = new ArrayList<>();
	     scriptArgs.add(time);
	     response.put("timeInWords", script.runShellScript(scriptPath, scriptArgs));
	     return response;
	     
	}
	
}