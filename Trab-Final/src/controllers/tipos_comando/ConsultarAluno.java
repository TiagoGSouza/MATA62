package controllers.tipos_comando;

import controllers.BibliotecaFachada;
import interfaces.IComandos;

public class ConsultarAluno implements IComandos {

    @Override
    public boolean executa(BibliotecaFachada biblioteca, String parametros) {
        biblioteca.consultarAluno(parametros);
        return true;
    }
    
}
