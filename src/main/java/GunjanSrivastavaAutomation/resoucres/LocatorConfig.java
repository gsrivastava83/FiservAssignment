package GunjanSrivastavaAutomation.resoucres;

import java.io.FileReader;
import java.io.IOException;
import org.openqa.selenium.By;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class LocatorConfig {
		
		public static By xpath_searchbox;
		public static By xpath_results;
		public static By xpath_items;
		
		 public static void getLocatorFromJson() throws IOException {
			 
		        FileReader reader = new FileReader("/Users/gunjansrivastava/eclipse-workspace/FrameworkDesign_FiservAssignment"
						+ "/src/test/java/GunjanSrivastavaAutomation/Data/LocatorData.json");
		        JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();
		        
				xpath_searchbox = By.xpath((jsonObject.get("xpath_searchbox").getAsString()));
				System.out.println("xpath for searchbox: " +xpath_searchbox);
				
				xpath_results = By.xpath((jsonObject.get("xpath_results").getAsString()));
				System.out.println("xpath for resultsText: " +xpath_results);
				
				xpath_items = By.xpath((jsonObject.get("xpath_items").getAsString()));
				System.out.println("xpath for items: " +xpath_items);
			}
}
