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
@ContextConfiguration(classes=WebDriverConfig.class, loader= AnnotationConfigContextLoader.class)
public class ShadowDOMTest {

    @Autowired public WebDriver driver;

    @Test
    public void Run() {
        System.out.println("Open Website");
        driver.get("http://localhost:8081/");

        System.out.println("Retrieve my-app tag");
        WebElement myAppTag = driver.findElement(By.tagName("my-app"));
        String path = "(shadow-root)>app-drawer-layout>app-header-layout>app-header>app-toolbar>div[main-title]";
        WebElement headerElem = Util.getChildByPath(driver,myAppTag, path);
        Assert.assertEquals("My App", headerElem.getText());
        /*WebElement myAppShadowRoot = Util.expandRootElement(myAppTag, driver);

        System.out.println("Retrieve app-drawer-layout tag");
        WebElement appDrawerLayoutTag = Util.getChildByTagName(myAppShadowRoot, driver, "app-drawer-layout");

        System.out.println("Retrieve app-header-layout tag");
        WebElement appHeaderLayoutTag = Util.getChildByTagName(appDrawerLayoutTag, driver, "app-header-layout");

        System.out.println("Retrieve app-header tag");
        WebElement appHeaderTag = Util.getChildByTagName(appHeaderLayoutTag, driver, "app-header");

        System.out.println("Retrieve app-toolbar tag");
        WebElement appToolbarTag = Util.getChildByTagName(appHeaderTag, driver,"app-toolbar");

        String actualHeading = Util.getChildByTagName(appToolbarTag, driver, "div[main-title]").getText();
        System.out.println(actualHeading);

        // Verify header title
        Assert.assertEquals("My App", actualHeading);*/
        Assert.assertTrue(true);
    }

    //Returns webelement

}