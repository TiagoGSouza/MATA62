package controllers.tipos_comando;

import controllers.BibliotecaFachada;
import interfaces.IComandos;

public class ConsultarProfessor implements IComandos{

    @Override
    public boolean executa(BibliotecaFachada biblioteca, String parametros) {
        biblioteca.consultarProfessor(parametros);
        return true;
    }
    
}
