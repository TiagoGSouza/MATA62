package controllers.tipos_comando;

import controllers.BibliotecaFachada;
import interfaces.IComandos;

public class RegistrarObservador implements IComandos {

    @Override
    public boolean executa(String parametros) {
        BibliotecaFachada biblioteca = BibliotecaFachada.obterInstancia();
        String[] p = parametros.split(" ");
        biblioteca.registrarObservador(p[0], p[1]);
        return true;
    }
    
}
