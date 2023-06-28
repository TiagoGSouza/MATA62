package classes_negocio;

import java.time.LocalDate;

import interfaces.IUsuario;

public class Reserva {
    private Livro livro;
    private IUsuario usuario;
    private LocalDate dataReserva;

    public Reserva(IUsuario usuario, Livro livro){
        this.usuario = usuario;
        this.livro = livro;
        this.dataReserva = LocalDate.now();
    }

    public IUsuario getUsuario(){
        return this.usuario;
    }

    public String getUsuarioNome(){
        return usuario.getNome();
    }

    public Livro getLivro(){
        return this.livro;
    }

    public LocalDate getDataReserva(){
        return this.dataReserva;
    }

    public String getTituloLivro(){
        return this.livro.getTitulo();
    }
}
