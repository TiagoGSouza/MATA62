package controllers.tipos_comando;

import controllers.BibliotecaFachada;
import interfaces.IComandos;

public class DevolverLivro implements IComandos {

    @Override
    public boolean executa(String parametros) {
        BibliotecaFachada biblioteca = BibliotecaFachada.obterInstancia();
        String[] p = parametros.split(" ");
        biblioteca.devolverLivro(p[0], p[1]);
        return true;
    }
    
}
