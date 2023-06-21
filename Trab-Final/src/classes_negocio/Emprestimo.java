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
}
