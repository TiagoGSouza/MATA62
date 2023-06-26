package controllers;

import interfaces.IComandos;

public class FinalizaApp implements IComandos {

    @Override
    public boolean executa(BibliotecaFachada biblioteca, String codigoUsuario, String codigoLivro) {
        return false;
    }
    
}
