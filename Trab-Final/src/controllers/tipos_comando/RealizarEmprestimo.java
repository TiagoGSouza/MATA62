package controllers.tipos_comando;

import controllers.BibliotecaFachada;
import interfaces.IComandos;

public class RealizarEmprestimo implements IComandos{

    @Override
    public boolean executa(String parametros) {
        String[] p = parametros.split(" ");
        BibliotecaFachada biblioteca = BibliotecaFachada.obterInstancia();
        biblioteca.realizarEmprestimo(p[0], p[1]);
        return true;
    }
    
}
