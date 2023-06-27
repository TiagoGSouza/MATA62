package controllers.tipos_comando;

import interfaces.IComandos;

public class RealizarEmprestimo implements IComandos{

    @Override
    public boolean executa(BibliotecaFachada biblioteca, String parametros) {
        String[] p = parametros.split(" ");
        biblioteca.realizarEmprestimo(p[0], p[1]);
        return true;
    }
    
}
