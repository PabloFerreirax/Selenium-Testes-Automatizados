package com.selenium.basic.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    private static WebDriver driver;

    private DriverFactory(){
    }

    public static WebDriver getDriver(){
        if(driver == null){
            switch (Propriedades.browser){
                case CHROME:
                    System.setProperty("webdriver.chrome.driver", //diz o tipo
                            "C:\\Users\\pablo\\OneDrive\\Documentos\\TrabalhoHomeOffice\\Drivers\\chromedriver.exe"); //diz onde esta
                    driver = new ChromeDriver(); // instancia o tipo agora
                    break;
                case FIREFOX:
                    System.setProperty("webdriver.gecko.driver", //diz o tipo
                            "C:\\Users\\pablo\\OneDrive\\Documentos\\TrabalhoHomeOffice\\Drivers\\geckodriver.exe"); //diz onde esta
                    driver = new FirefoxDriver();
                    break;
            }

        }
        return driver;
    }

    public static void killDriver(){
        if(driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
