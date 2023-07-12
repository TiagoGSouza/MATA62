package controllers.tipos_comando;

import controllers.BibliotecaFachada;
import interfaces.IComandos;

public class ReservarLivro implements IComandos{

    @Override
    public boolean executa(String parametros) {
        BibliotecaFachada biblioteca = BibliotecaFachada.obterInstancia();
        String[] p = parametros.split(" ");
        biblioteca.reservarLivro(p[0], p[1]);
        return true;
    }
    
}
