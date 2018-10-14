package me.home.Util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class PaperInput {
    public static void Focus(WebDriver driver, WebElement elem) {
        Set<String> inputTags = new HashSet<String>(Arrays.asList("input", "paper-input"));
        if (inputTags.contains(elem.getTagName())) {
            elem.sendKeys("");
        }  else{
            elem.sendKeys(Keys.TAB);
        }
    }

    public static boolean isInvalid(WebDriver driver, WebElement elem) {
        WebElement underlineElem = Util.getChildByPath(driver, elem, "(shadow-root)>paper-input-container>(shadow-root)>div.underline");
        String[] cssList = underlineElem.getAttribute("class").split(" ");
        for (String css : cssList) {
            if (css.equals("is-invalid")) {
                return true;
            }
        }
        return false;
    }
}
