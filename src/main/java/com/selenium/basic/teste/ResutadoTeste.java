package com.selenium.basic.teste;

import com.selenium.basic.core.BaseTeste;
import com.selenium.basic.page.HomePage;
import com.selenium.basic.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

import static com.selenium.basic.core.Propriedades.NOME_CONTA_ALTERADA;

public class ResutadoTeste extends BaseTeste {

    public MenuPage menuPage = new MenuPage();
    public HomePage homePage = new HomePage();

    @Test
    public void testSaldo(){
        menuPage.acessarTelaHome();
        Assert.assertEquals("10000.00", homePage.obterValSaldo(NOME_CONTA_ALTERADA));
    }


}
