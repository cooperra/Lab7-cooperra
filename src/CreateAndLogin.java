

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.regex.Pattern;

public class CreateAndLogin extends SeleneseTestCase {
	final String FIREFOX = "*firefox c:\\Program Files\\Mozilla Firefox 4.0 Beta 4\\firefox.exe";
	final String CHROME = "*chrome C:\\Users\\cooperra\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe";
	
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, FIREFOX, "http://webtesting.idyll.org/");
		selenium.start();
	}

	@Test
	public void testCreateAndLogin() throws Exception {
		selenium.open("/");
		selenium.click("link=Log in");
		selenium.waitForPageToLoad("30000");
		selenium.click("create");
		selenium.waitForPageToLoad("30000");
		selenium.type("name", "cooperra");
		selenium.select("gender", "label=male");
		selenium.type("password", "derp");
		selenium.type("username", "cooperra");
		selenium.click("create");
		selenium.waitForPageToLoad("30000");
		selenium.type("username", "cooperra");
		selenium.type("password", "derp");
		selenium.click("login");
		selenium.waitForPageToLoad("30000");
		verifyTrue(selenium.isTextPresent("cooperra"));
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
