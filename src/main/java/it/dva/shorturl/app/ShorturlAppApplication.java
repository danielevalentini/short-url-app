package it.dva.shorturl.app;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShorturlAppApplication implements CommandLineRunner {

	    private static Logger LOG = LoggerFactory
	      .getLogger(ShorturlAppApplication.class);

	    public static void main(String[] args) {
	        LOG.info("STARTING THE APPLICATION");
	        SpringApplication.run(ShorturlAppApplication.class, args);
	        LOG.info("APPLICATION FINISHED");
	    }
	 
	    
	   @Autowired
	    private ShortUrlClient client ;
	    
	    
	    @Override
	    public void run(String... args) {
	        
	        Scanner myObj = new Scanner(System.in);  
		    
	        LOG.info("ENTER NAME USER : ");
	        String username = myObj.nextLine();  
	        
	        LOG.info("USER IS "+ username);
	        //client.setUser(username);
	        while (true) {
	        	LOG.info("ENTER MESSAGE : ");
	        	String message = myObj.nextLine(); 
		        try {
		        	
		        	String response = client.call(message);
		        	LOG.info("Response from server -> "+response);
		        	
		        }catch (Exception e) {
		        	LOG.info("Errore : ",e);
				}
	        }
	    }
	
	

}
