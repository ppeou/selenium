package me.home.app.selenium;

import me.home.Util.Util;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
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
        Assert.assertTrue(true);
    }

    //Returns webelement

}