package com.selenium.basic.suite;

import com.selenium.basic.page.LoginPage;
import com.selenium.basic.teste.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import static com.selenium.basic.core.DriverFactory.killDriver;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ContaTeste.class,
        MovimentacaoTeste.class,
        RemoverMoviContaTeste.class,
        ResutadoTeste.class,
        ResumoTeste.class
})
public class SuiteGeral {

    private static LoginPage loginPage = new LoginPage();

    @BeforeClass
    public static void inicializa(){
        loginPage.acessarTelaInicial();
        loginPage.setEmail("pablo@pablo");
        loginPage.setSenha("123456");
        loginPage.clicaBotaoEntrar();
    }

    @AfterClass
    public static void finaliza(){
        killDriver();
    }
}
