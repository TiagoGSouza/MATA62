package controllers.tipos_comando;

import controllers.BibliotecaFachada;
import interfaces.IComandos;

public class ConsultarLivro implements IComandos {

    @Override
    public boolean executa(String parametros) {
        BibliotecaFachada biblioteca = BibliotecaFachada.obterInstancia();
        biblioteca.consultarLivro(parametros);
        return true;
    }
    
}
