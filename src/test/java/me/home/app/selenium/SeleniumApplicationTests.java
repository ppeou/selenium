package me.home.app.selenium;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ShadowDOMTest.class})
@SpringBootTest
public class SeleniumApplicationTests {

}
