package com.selenium.basic.page;

import com.selenium.basic.core.BasePage;
import com.selenium.basic.core.DriverFactory;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    public void acessarTelaInicial(){
        DriverFactory.getDriver().get("https://seubarriga.wcaquino.me");
    }

    public void setEmail(String email){
        escrever("email", email);
    }

    public void setSenha(String senha){
        escrever("senha", senha);
    }

    public void clicaBotaoEntrar(){
        clicarBotao(By.xpath("//button[.=\"Entrar\"]"));
    }

    public void logar(String email, String senha){
        setEmail(email);
        setSenha(senha);
        clicaBotaoEntrar();
    }

}
