package Utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class propertiesLoader {
	private	Properties p;

	public propertiesLoader() {
		 p = new Properties();
		try {
			p.load(new FileReader("./resources/properties/application.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public String getProperty(String propertyName) {
		
		
		return p.getProperty(propertyName);
		
	}
}
