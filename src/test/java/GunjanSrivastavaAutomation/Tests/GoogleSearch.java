package GunjanSrivastavaAutomation.Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import GunjanSrivastavaAutomation.TestComponents.BaseTest;


public class GoogleSearch extends BaseTest{
	
	@Test(dataProvider = "getData", retryAnalyzer=GunjanSrivastavaAutomation.TestComponents.Retry.class)
	public void verifyItemUponGoogleSearch(HashMap<String, String> map) throws IOException {
		landingPage.submitSearchTerm(map.get("searchkeyword"));
		landingPage.landedOnSearchResultPage();
		String expectedResult= map.get("searchkeyword");
		String actualResult = landingPage.FirstItemReturned();
		Assert.assertTrue(actualResult.toLowerCase().contains(expectedResult));
	}

	@DataProvider
	public Object[][] getData() throws IOException {
		
		List<HashMap<String, String>> data = getJsonDataToString("/Users/gunjansrivastava/eclipse-workspace/"
				+ "/FrameworkDesign_FiservAssignment/src/test/java/GunjanSrivastavaAutomation/Data/Data.json");
		return new Object[][] {{data.get(0)}, {data.get(1)}};
	}
	
}


