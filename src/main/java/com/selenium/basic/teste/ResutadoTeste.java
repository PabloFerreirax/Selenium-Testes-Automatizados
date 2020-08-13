package com.selenium.basic.teste;

import com.selenium.basic.core.BaseTeste;
import com.selenium.basic.page.HomePage;
import org.junit.Assert;
import org.junit.Test;

public class ResutadoTeste extends BaseTeste {

    public HomePage homePage = new HomePage();

    @Test
    public void testSaldo(){
        Assert.assertEquals("10000.00", homePage.obterValSaldo("ContaAlterada"));
    }


}
