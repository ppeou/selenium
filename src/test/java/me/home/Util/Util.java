package me.home.Util;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Util {
    public static WebElement expandRootElement(WebElement element, WebDriver driver) {
        WebElement ele = (WebElement) ((JavascriptExecutor) driver)
                .executeScript("return arguments[0].shadowRoot",element);
        return ele;
    }

    public static WebElement getChildByTagName(WebElement element, WebDriver driver, String tagName) {
        WebElement ele = (WebElement) ((JavascriptExecutor) driver)
                .executeScript("return arguments[0].querySelector('"+ tagName+"')",element);
        return ele;
    }


    public static WebElement getChildByPath(WebDriver driver, WebElement root, String path) {
        String[] abc = path.split(">");

        WebElement elem = root;
        if(abc.length > 0) {
            for(String _path: abc) {
                if(!_path.equals("(shadow-root)")) {
                    elem = getChildByTagName(elem, driver, _path);
                } else {
                    elem = expandRootElement(elem, driver);
                }
            }
        }
        return elem;
    }

    public static String getCurrentUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public static List<WebElement> getChildrenByPath(WebDriver driver, WebElement root, String path) {
        WebElement aElem = getChildByPath(driver,root, path);
        List<WebElement> items = Collections.EMPTY_LIST;
        if(aElem != null) {
            items = aElem.findElements(By.xpath(".//*"));
        }
        return items;
    }

    public static void navigateToPage(WebDriver driver, WebElement root, String pageName) {
        String path = "(shadow-root)>app-drawer-layout>#drawer>.drawer-list";
        List<WebElement> aElems = getChildrenByPath(driver, root, path);
        Optional<WebElement> foundAny = aElems.stream().filter(a -> a.getText().equals(pageName)).findFirst();
        if(foundAny.isPresent()) {
            foundAny.get().click();
        }
    }
}
