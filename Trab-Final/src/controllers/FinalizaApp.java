package controllers;

import interfaces.IComandos;

public class FinalizaApp implements IComandos {

    @Override
    public boolean executa(BibliotecaFachada biblioteca, String parametros) {
        return false;
    }
    
}
