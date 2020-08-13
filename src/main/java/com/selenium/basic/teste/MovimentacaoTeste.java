package com.selenium.basic.teste;

import com.selenium.basic.core.BaseTeste;
import com.selenium.basic.page.MenuPage;
import com.selenium.basic.page.MovimentacaoPage;
import com.selenium.basic.utils.DataUtils;
import org.apache.tools.ant.util.DateUtils;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MovimentacaoTeste extends BaseTeste {
    private MenuPage menuPage = new MenuPage();
    private MovimentacaoPage moviPage = new MovimentacaoPage();
    private DataUtils data = new DataUtils();

    @Test
    public void test1InserirMovi(){
        menuPage.acessarTelaInserirMovi();

        moviPage.setDataMovimentacao(data.obertDataFormatada(new Date()));
        moviPage.setDataPagamento(data.obertDataFormatada(new Date()));
        moviPage.setDescricao("Teste Descricao");
        moviPage.setInteressado("aaaa");
        moviPage.setValor("10000");
        moviPage.setConta("ContaAlterada");
        moviPage.setSituacaoPago();
        moviPage.salvar();
        Assert.assertEquals("Movimentação adicionada com sucesso!", moviPage.obterMensagemSucesso());
    }

    @Test
    public void test2CampoObrigatorio(){
        menuPage.acessarTelaInserirMovi();
        moviPage.salvar();
        List<String> erros = moviPage.obterErros();
        //outras formas
        //Assert.assertEquals("", erros.contains(0));
        //Assert.assertTrue(erros.contains("Data da Movimentação é obrigatório"));
        //melhor forma
        Assert.assertTrue(erros.containsAll(Arrays.asList(
                "Data da Movimentação é obrigatório",
                "Data do pagamento é obrigatório",
                "Descrição é obrigatório",
                "Interessado é obrigatório",
                "Valor é obrigatório",
                "Valor deve ser um número"
        )));
        //captura a quantidade de erros que deveria ter e observa se é a que temos
        Assert.assertEquals(6, erros.size());
    }

    @Test
    public void test3InserirMoviFutura(){
        menuPage.acessarTelaInserirMovi();

        Date dataFutura = data.obterDataComDiferencaDias(5);

        moviPage.setDataMovimentacao(data.obertDataFormatada(dataFutura));
        moviPage.setDataPagamento(data.obertDataFormatada(dataFutura));
        moviPage.setDescricao("Teste Descricao");
        moviPage.setInteressado("aaaa");
        moviPage.setValor("10000");
        moviPage.setConta("ContaAlterada");
        moviPage.setSituacaoPago();
        moviPage.salvar();

        List<String> erro = moviPage.obterErros();
        Assert.assertTrue(erro.containsAll(Arrays.asList(
                "Data da Movimentação deve ser menor ou igual à data atual"
        )));

        Assert.assertEquals(1, erro.size());
    }
}
