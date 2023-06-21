package classes_negocio;

import java.time.*;

import interfaces.IUsuario;

public class Emprestimo {
    private IUsuario usuario;
    private Exemplar exemplar;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    public Emprestimo(IUsuario usuario, Exemplar exemplar, LocalDate dataDevolucao){
        this.usuario = usuario;
        this.exemplar = exemplar;
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucao = dataDevolucao;
    }

    public LocalDate getDataDevolucao(){
        return this.dataDevolucao;
    }
}
