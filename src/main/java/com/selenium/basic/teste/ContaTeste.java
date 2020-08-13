package com.selenium.basic.teste;

import com.selenium.basic.core.BaseTeste;
import com.selenium.basic.page.ContasPage;
import com.selenium.basic.page.MenuPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ContaTeste extends BaseTeste {

    private MenuPage menuPage = new MenuPage();
    private ContasPage contasPage = new ContasPage();

    @Test
    public void testInserirConta(){
        menuPage.acessarTelaInserirConta();
        contasPage.setNome("ContaNova1");
        contasPage.salvar();
        Assert.assertEquals("Conta adicionada com sucesso!", contasPage.obterMensagemSucesso());
    }

    @Test
    public void testAlterarConta(){
        menuPage.acessarTelaListasConta();
        contasPage.clicaBotaoAlterar("ContaNova");
        contasPage.setNome("ContaAlterada");
        contasPage.salvar();
        Assert.assertEquals("Conta alterada com sucesso!", contasPage.obterMensagemSucesso());
    }

    @Test
    public void testInserirMesmaContal(){
        menuPage.acessarTelaInserirConta();
        contasPage.setNome("ContaAlterada");
        contasPage.salvar();
        Assert.assertEquals("Já existe uma conta com esse nome!", contasPage.obterMensagemErro());
    }

    @Test
    public void testExcluirContaComMovi(){
        menuPage.acessarTelaListasConta();
        contasPage.clicaBotaoExcluir("ContaAlterada");
        Assert.assertEquals("Conta em uso na movimentações", contasPage.obterMensagemErro());
    }
}
