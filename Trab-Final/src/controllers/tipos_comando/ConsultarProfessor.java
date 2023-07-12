package controllers.tipos_comando;

import controllers.BibliotecaFachada;
import interfaces.IComandos;

public class ConsultarProfessor implements IComandos{

    @Override
    public boolean executa(String parametros) {
        BibliotecaFachada biblioteca = BibliotecaFachada.obterInstancia();
        biblioteca.consultarProfessor(parametros);
        return true;
    }
    
}
