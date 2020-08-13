package com.selenium.basic.core;

import com.selenium.basic.page.LoginPage;
import org.apache.tools.ant.util.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import static com.selenium.basic.core.DriverFactory.getDriver;
import static com.selenium.basic.core.DriverFactory.killDriver;

public class BaseTeste {

    private LoginPage loginPage = new LoginPage();

    @Rule
    public TestName testName = new TestName();

    @Before
    public void inicializa(){

    }
    @After
    public void finaliza() throws IOException {
        TakesScreenshot ss = (TakesScreenshot) getDriver();
        File arquivo = ss.getScreenshotAs(OutputType.FILE);
        FileUtils.getFileUtils().copyFile(arquivo, new File("target"+ File.separator +"Screenshot"
                + File.separator + testName.getMethodName()+".jpg"));
        if(Propriedades.FECHAR_BROWSER){
            killDriver();
        }
    }

}
