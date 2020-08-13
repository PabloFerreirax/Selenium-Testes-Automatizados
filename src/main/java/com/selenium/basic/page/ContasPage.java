package com.selenium.basic.page;

import com.selenium.basic.core.BasePage;
import org.openqa.selenium.By;

public class ContasPage extends BasePage {

    public void setNome(String nome){
        escrever("nome", nome);
    }

    public void salvar(){
        clicarBotaoTexto("Salvar");
    }

    public String obterMensagemSucesso(){
        return obterTexto(By.xpath("//div[@class=\"alert alert-success\"]"));
    }

    public String obterMensagemErro(){
        return obterTexto(By.xpath("//div[@class=\"alert alert-danger\"]"));
    }

    public void clicaBotaoAlterar(String nome){
        obterCelula("Conta", nome, "Ações", "tabelaContas")
                .findElement(By.xpath(".//span[@class='glyphicon glyphicon-edit']")).click();
    }

    public void clicaBotaoExcluir(String nome){
        obterCelula("Conta",nome, "Ações", "tabelaContas")
                .findElement(By.xpath(".//span[@class='glyphicon glyphicon-remove-circle']")).click();
    }
}
