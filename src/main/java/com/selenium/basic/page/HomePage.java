package com.selenium.basic.page;

import com.selenium.basic.core.BasePage;
import org.openqa.selenium.By;

public class HomePage extends BasePage {
    public String obterValSaldo(String nome){
       return obterCelula("Conta", nome, "Saldo", "tabelaSaldo").getText();
    }
}
