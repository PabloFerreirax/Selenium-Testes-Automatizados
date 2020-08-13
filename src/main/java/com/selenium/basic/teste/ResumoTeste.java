package com.selenium.basic.teste;

import com.selenium.basic.core.BaseTeste;
import com.selenium.basic.core.DriverFactory;
import com.selenium.basic.page.MenuPage;
import com.selenium.basic.page.ResumoPage;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static com.selenium.basic.core.DriverFactory.getDriver;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ResumoTeste extends BaseTeste {

    private ResumoPage resumoPage = new ResumoPage();
    private MenuPage menuPage = new MenuPage();

    @Test
    public void test1RemoverMovi(){
        menuPage.acessarTelaResumo();

        resumoPage.removerMovi();
        Assert.assertEquals("Movimentação removida com sucesso!", resumoPage.obterTesteSucesso());
    }

    @Test
    public void test2ResumoMensal(){
        menuPage.acessarTelaResumo();
        Assert.assertEquals("Seu Barriga - Extrato", getDriver().getTitle());
    }

}
