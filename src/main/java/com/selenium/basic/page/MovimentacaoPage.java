package com.selenium.basic.page;

import com.selenium.basic.core.BasePage;
import com.selenium.basic.core.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.selenium.basic.core.DriverFactory.getDriver;

public class MovimentacaoPage extends BasePage {

    public void setDataMovimentacao(String data){
        escrever("data_transacao", data);
    }

    public void setDataPagamento(String data){
        escrever("data_pagamento", data);
    }

    public void setDescricao(String descricao){
        escrever("descricao", descricao);
    }

    public void setInteressado(String interessado){
        escrever("interessado", interessado);
    }

    public void setValor(String valor){
        escrever("valor", valor);
    }

    public void setConta(String conta){
        selecionarCombo("conta", conta);
    }

    public void setSituacaoPago(){
        clicarRadio("status_pago");
    }

    public void salvar(){
        clicarBotaoTexto("Salvar");
    }

    public String obterMensagemSucesso(){
        return obterTexto(By.xpath("//div[@class=\"alert alert-success\"]"));
    }

    public List<String> obterErros(){
        //div em que esta sendo guardada os erros
        List<WebElement> erros = getDriver().findElements(By.xpath("//div[@class='alert alert-danger']//li"));
        List<String> retorno = new ArrayList<String>();
        //for para pegar cada erro individual desta div
        for(WebElement erro: erros){
            retorno.add(erro.getText());
        }
        return retorno;
    }

}
