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
public class ViewTwoTest {
    @Autowired public WebDriver driver;

    @Test
    public void Run() {
        System.out.println("Open Website");
        driver.get("http://localhost:8081/");
        WebElement myAppTag = driver.findElement(By.tagName("my-app"));


        String path = "(shadow-root)>app-drawer-layout>#drawer>.drawer-list>a:nth-child(2)";
        String path2 = "(shadow-root)>app-drawer-layout>app-header-layout>iron-pages>my-view2>(shadow-root)>div.card>h1";
        WebElement viewTwoLink = Util.getChildByPath(driver, myAppTag, path);

        if(viewTwoLink != null) {
            viewTwoLink.click();
            try {
                Thread.sleep(1000);
                WebElement h1Elem = Util.getChildByPath(driver, myAppTag, path2);
                Assert.assertEquals(h1Elem.getText(), "View Two");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



    }
}
