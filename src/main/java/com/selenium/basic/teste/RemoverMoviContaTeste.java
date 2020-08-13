package com.selenium.basic.teste;

import com.selenium.basic.core.BaseTeste;
import com.selenium.basic.page.ContasPage;
import com.selenium.basic.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

import static com.selenium.basic.core.Propriedades.NOME_CONTA_ALTERADA;

public class RemoverMoviContaTeste extends BaseTeste {

    private MenuPage menuPage = new MenuPage();
    private ContasPage contasPage = new ContasPage();

    @Test
    public void testExcluirContaComMovi(){
        menuPage.acessarTelaListasConta();
        contasPage.clicaBotaoExcluir(NOME_CONTA_ALTERADA);
        Assert.assertEquals("Conta em uso na movimentações", contasPage.obterMensagemErro());
    }
}
