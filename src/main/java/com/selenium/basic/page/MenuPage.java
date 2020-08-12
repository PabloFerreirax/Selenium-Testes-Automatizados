package com.selenium.basic.page;

import com.selenium.basic.core.BasePage;

public class MenuPage extends BasePage {

    public void acessarTelaInserirConta(){
        clicarLink("Contas");
        clicarLink("Adicionar");
    }

    public void acessarTelaListasConta(){
        clicarLink("Contas");
        clicarLink("Listar");
    }

    public void acessarTelaInserirMovi(){
        clicarLink("Criar Movimentação");
    }
}

