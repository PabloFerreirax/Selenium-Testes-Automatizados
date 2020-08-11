package com.selenium.basic.core;

public class Propriedades {

    public static boolean FECHAR_BROWSER = false; //tatica prerigosa, so deve ser usada em testes e não em ambiente real

    public static Browsers browser = Browsers.CHROME;

    public enum Browsers{
        CHROME,
        FIREFOX
    }
}
