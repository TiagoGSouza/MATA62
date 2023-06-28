package classes_negocio;

import java.time.*;

import interfaces.IUsuario;

public class Emprestimo {
    private IUsuario usuario;
    private Exemplar exemplar;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    public Emprestimo(IUsuario usuario, Exemplar exemplar, int diasEmprestimo){
        this.usuario = usuario;
        this.exemplar = exemplar;
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucao = LocalDate.now().plusDays(diasEmprestimo);
    }

    public LocalDate getDataDevolucao(){
        return this.dataDevolucao;
    }

    public Livro getLivro(){
        return this.exemplar.getLivro();
    }

    public String getUsuarioNome(){
        return this.usuario.getNome();
    }

    public Exemplar getExemplar(){
        return this.exemplar;
    }

    public void removerExemplar(){
        this.exemplar.cancelarEmprestimo();
    }

    public String getTituloLivro(){
        return this.exemplar.getTituloLivro();
    }

    public LocalDate getDataEmprestimo() {
        return this.dataEmprestimo;
    }
}
