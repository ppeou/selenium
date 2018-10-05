package me.home.app.selenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
// ApplicationContext will be loaded from the OrderServiceConfig class
@ContextConfiguration(classes=WebDriverConfig.class, loader= AnnotationConfigContextLoader.class)
public class ShadowDOMTest {

    @Autowired public WebDriver driver;

    @Test
    public void Run() {
        System.out.println("Open Website");
        driver.get("http://localhost:8081/");

        System.out.println("Retrieve my-app tag");
        WebElement myAppTag = driver.findElement(By.tagName("my-app"));
        WebElement myAppShadowRoot = expandRootElement(myAppTag);

        System.out.println("Retrieve app-drawer-layout tag");
        WebElement appDrawerLayoutTag = getChildByTagName("app-drawer-layout", myAppShadowRoot);

        System.out.println("Retrieve app-header-layout tag");
        WebElement appHeaderLayoutTag = getChildByTagName("app-header-layout", appDrawerLayoutTag);

        System.out.println("Retrieve app-header tag");
        WebElement appHeaderTag = getChildByTagName("app-header", appHeaderLayoutTag);

        System.out.println("Retrieve app-toolbar tag");
        WebElement appToolbarTag = getChildByTagName("app-toolbar", appHeaderTag);

        String actualHeading =  getChildByTagName("div[main-title]", appToolbarTag).getText();
        System.out.println(actualHeading);

        // Verify header title
        Assert.assertEquals("My App", actualHeading);
        Assert.assertTrue(true);
    }

    //Returns webelement
    public WebElement expandRootElement(WebElement element) {
        WebElement ele = (WebElement) ((JavascriptExecutor) driver)
                .executeScript("return arguments[0].shadowRoot",element);
        return ele;
    }

    public WebElement getChildByTagName(String tagName, WebElement element) {
        WebElement ele = (WebElement) ((JavascriptExecutor) driver)
                .executeScript("return arguments[0].querySelector('"+ tagName+"')",element);
        return ele;
    }

    /*@After
    public void dispose() {
        System.out.println("dispose()");
        driver.quit();
    }*/
}