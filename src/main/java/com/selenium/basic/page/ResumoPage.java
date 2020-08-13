package com.selenium.basic.page;

import com.selenium.basic.core.BasePage;
import org.openqa.selenium.By;

public class ResumoPage extends BasePage {

    public void removerMovi(){
        clicarBotao(By.xpath("//span[@class = \"glyphicon glyphicon-remove-circle\"]"));
    }

    public String obterTesteSucesso(){
       return obterTexto(By.xpath("//div[@class=\"alert alert-success\"]"));
    }

}
