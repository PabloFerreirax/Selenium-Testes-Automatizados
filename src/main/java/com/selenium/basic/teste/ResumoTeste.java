package com.selenium.basic.teste;

import com.selenium.basic.core.BaseTeste;
import com.selenium.basic.core.DriverFactory;
import com.selenium.basic.page.MenuPage;
import com.selenium.basic.page.ResumoPage;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;

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

    //@Test(expected = NoSuchElementException.class) //Metodo 1
    @Test
    public void test2ResumoMensal(){
        menuPage.acessarTelaResumo();
        Assert.assertEquals("Seu Barriga - Extrato", getDriver().getTitle());
        /*try{ //metodo 2
            DriverFactory.getDriver().findElement(By.xpath("//*[@id='tabelaExtrato']/tbody/tr"));
            Assert.fail();
        }
        catch (NoSuchElementException e){

        }*/
        // Metodo 3
        List<WebElement> elementosEncontrados =
                DriverFactory.getDriver().findElements(By.xpath("//*[@id='tabelaExtrato']/tbody/tr"));
        Assert.assertEquals(0,elementosEncontrados.size());
    }

}
