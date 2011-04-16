

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.regex.Pattern;

public class TestSchedule extends SeleneseTestCase {
	final String FIREFOX = "*firefox c:\\Program Files\\Mozilla Firefox 4.0 Beta 4\\firefox.exe";
	
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, FIREFOX, "https://prodweb.rose-hulman.edu/");
		selenium.start();
	}

	@Test
	public void testSchedule() throws Exception {
		selenium.open("/regweb-cgi/reg-sched.pl");
		selenium.type("id1", "cooperra");
		selenium.select("termcode", "label=Spring Quarter - 2010-11");
		selenium.click("bt1");
		selenium.waitForPageToLoad("30000");
		verifyTrue(selenium.isTextPresent("CSSE376"));
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
