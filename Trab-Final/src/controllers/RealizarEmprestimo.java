package controllers;

import interfaces.IComandos;

public class RealizarEmprestimo implements IComandos{

    @Override
    public boolean executa(BibliotecaFachada biblioteca, String codigoUsuario, String codigoLivro) {
        biblioteca.realizarEmprestimo(codigoUsuario, codigoLivro);
        return true;
    }
    
}
