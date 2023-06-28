package controllers.tipos_comando;

import controllers.BibliotecaFachada;
import interfaces.IComandos;

public class ConsultarLivro implements IComandos {

    @Override
    public boolean executa(BibliotecaFachada biblioteca, String parametros) {
        biblioteca.consultarLivro(parametros);
        return true;
    }
    
}
