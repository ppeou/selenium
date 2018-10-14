package me.home.app.selenium;

import me.home.Util.PaperInput;
import me.home.Util.Util;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=WebDriverConfig.class, loader= AnnotationConfigContextLoader.class)
public class PaperInputTest {
    @Autowired
    public WebDriver driver;

    @Test
    public void Run() {
        System.out.println("Open Website");
        driver.get("http://localhost:8081/");
        WebElement myAppTag = driver.findElement(By.tagName("my-app"));
        Util.navigateToPage(driver, myAppTag, "View Two");

        try {
            Thread.sleep(1000);
            String path = "(shadow-root)>app-drawer-layout>app-header-layout>iron-pages>my-view2>(shadow-root)>div.card";
            WebElement myCard = Util.getChildByPath(driver, myAppTag, path);
            String myPaperInputPath = "paper-input";
            WebElement myPIElem = Util.getChildByPath(driver, myCard, myPaperInputPath);
            PaperInput.Focus(driver, myPIElem);
            Thread.sleep(1000);
            myPIElem.sendKeys(Keys.TAB);
            Thread.sleep(1000);
            boolean isInvalid = PaperInput.isInvalid(driver, myPIElem);
            Assert.assertTrue(isInvalid);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}
