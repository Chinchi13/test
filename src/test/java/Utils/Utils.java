package Utils;
import org.apache.commons.codec.binary.Base64;

import java.io.File;
import java.io.IOException;

import static Utils.Driver.driver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Utils {
    private static String encodeBase64String(String inputString) {
        return Base64.encodeBase64URLSafeString(inputString.getBytes());
    }

    private static boolean fileExists(String pathToFile) {
        if(new File(pathToFile).exists() && new File(pathToFile).length()>0)
        {
    	return true;
        }
        else
        {
        	return false;
            }
        
        
    }


    public static boolean WaitUrlContains(String subsetUrl) {
		String currentUrl = driver.getCurrentUrl().toString();
		return currentUrl != null && currentUrl.contentEquals(subsetUrl);
	}

   

    public static void exportReportToJIRA(String username,String jiraURL, String reportFilePath) throws InterruptedException {
        String[] command = {"curl.exe","-k", "-X", "POST",
                "-H", "Content-Type: application/json",
                "-H", "Authorization: Basic " + username ,
                "--data", "@" + reportFilePath,
                jiraURL + "rest/raven/1.0/import/execution/cucumber?projectKey=ASSS"
        };
        System.out.println(command[0].toString());
        ProcessBuilder process = new ProcessBuilder(command);
        process.redirectErrorStream(true);
        //System.out.println(process.toString());
        Process p;

        do {
            System.out.println("\ninfo: Checking if cucumber.json file has been generated\n");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        } while (!fileExists(reportFilePath));

        try {
            System.out.println("\ninfo: Starting process that accepts curl POST command\n");
            p = process.start();


         

            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            p.waitFor();
            System.out.println("ok!");

            in.close();
            System.exit(0);
            
            
        } catch (IOException e) {
            System.out.print("\nerror: Tried to execute curl command that posts json file to JIRA Xray, something went wrong\n");
            e.printStackTrace();
        }
        
        
        
        
        
        
        
    }

}