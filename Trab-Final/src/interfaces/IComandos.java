package interfaces;

import controllers.BibliotecaFachada;

public interface IComandos {
    public boolean executa(BibliotecaFachada biblioteca, String parametros);
}