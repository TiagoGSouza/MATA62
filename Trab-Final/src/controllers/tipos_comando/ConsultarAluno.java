package controllers.tipos_comando;

import controllers.BibliotecaFachada;
import interfaces.IComandos;

public class ConsultarAluno implements IComandos {

    @Override
    public boolean executa(String parametros) {
        BibliotecaFachada biblioteca = BibliotecaFachada.obterInstancia();
        biblioteca.consultarAluno(parametros);
        return true;
    }
    
}
