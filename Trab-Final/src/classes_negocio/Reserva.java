package classes_negocio;

import interfaces.IUsuario;

public class Reserva {
    private Livro livro;
    private IUsuario usuario;

    public Livro getLivro(){
        return this.livro;
    }
}
