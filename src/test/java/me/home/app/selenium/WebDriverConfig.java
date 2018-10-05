package me.home.app.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebDriverConfig {
    @Bean
    public WebDriver webDriver() {
        String driverPath = "./lib/";
        System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
        return new ChromeDriver();
    }


}
