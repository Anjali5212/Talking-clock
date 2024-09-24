
package com.talking.clock.service;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.*;


public class RunScript {


	// A method to check if the script path exists and is executable
    public static boolean isValidScriptPath(String scriptPath) {
        File scriptFile = new File(scriptPath);
        return scriptFile.exists() && scriptFile.canExecute();
    }
	
    public static String runShellScript(String scriptPath, List<String> args) {
        StringBuilder output = new StringBuilder();
        
        if (!isValidScriptPath(scriptPath)) {
            return "Invalid Script path";
        }
        try {
            // Create the process builder with the script and its arguments
            List<String> command = new ArrayList<>();
            command.add(scriptPath);  // Add the script path
            command.addAll(args);     // Add script arguments
            
            ProcessBuilder processBuilder = new ProcessBuilder(command);

            // Redirect the error stream (stderr) to the standard output (stdout)
            processBuilder.redirectErrorStream(true);
            
            // Start the process
            Process process = processBuilder.start();
            
            // Read the script output from the InputStream (stdout)
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line);
            }
            
            // Wait for the process to complete and check the exit value
            int exitCode = process.waitFor();
            if (exitCode != 0) {
                System.err.println("Error: Script exited with code " + exitCode);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return output.toString();
    }
}
