package com.selenium.basic.teste;

import com.selenium.basic.core.BaseTeste;
import com.selenium.basic.core.DriverFactory;
import com.selenium.basic.page.ContasPage;
import com.selenium.basic.page.MenuPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static com.selenium.basic.core.Propriedades.NOME_CONTA_ALTERADA;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) //ordem alfabetica
public class ContaTeste extends BaseTeste {

    private MenuPage menuPage = new MenuPage();
    private ContasPage contasPage = new ContasPage();

    @Test
    public void test1InserirConta(){
        menuPage.acessarTelaInserirConta();
        contasPage.setNome("ContaNova");
        contasPage.salvar();
        Assert.assertEquals("Conta adicionada com sucesso!", contasPage.obterMensagemSucesso());
    }

    @Test
    public void test2AlterarConta() {
        menuPage.acessarTelaListasConta();

        contasPage.clicaBotaoAlterar("ContaNova");
        contasPage.setNome(NOME_CONTA_ALTERADA);
        contasPage.salvar();
        Assert.assertEquals("Conta alterada com sucesso!", contasPage.obterMensagemSucesso());
    }

    @Test
    public void test3InserirMesmaContal(){
        menuPage.acessarTelaInserirConta();
        contasPage.setNome(NOME_CONTA_ALTERADA);
        contasPage.salvar();
        Assert.assertEquals("Já existe uma conta com esse nome!", contasPage.obterMensagemErro());
    }


}
