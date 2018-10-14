package me.home.app.selenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
}
