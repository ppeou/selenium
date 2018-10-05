package me.home.app.selenium;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ShadowDOMTest.class})
@SpringBootTest
public class SeleniumApplicationTests {
	/*@BeforeClass
	public static void testBeforeSuite() {
		System.out.println("Before Class()");
	}

	@AfterClass
	public static void testAfterSuite() {
		System.out.println("After Class()");
		System.out.println("dispose()");
		//driver.quit();
	}

	@Before
	public void setUp() {
		System.out.println("setUp()");
	}

	@After
	public void tearDown() {
		System.out.println("tearDown()");
	}*/
}
