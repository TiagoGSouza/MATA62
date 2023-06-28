package classes_negocio;

import java.time.LocalDate;

public class Exemplar {
    private Livro livro;
    private String codigo;
    private boolean disponilidade;
    private Emprestimo emprestimo;

    public Exemplar(Livro livro, String codigo){
        this.livro = livro;
        this.codigo = codigo;
        this.disponilidade = true;
        this.emprestimo = null;
    }

    public Livro getLivro(){
        return this.livro;
    }

    public String getCodigo(){
        return this.codigo;
    }

    public boolean getDisponibilidade(){
        return this.disponilidade;
    }

    public String getEmprestimoUsuarioNome(){
        try{
            return this.emprestimo.getUsuarioNome();
        }catch (Exception e){
            return null;
        }
    }
    public LocalDate getEmprestimoDataEmp(){
        try{
            return this.emprestimo.getDataEmprestimo();
        }catch (Exception e){
            return null;
        }
    }
    public LocalDate getEmprestimoDataDev(){
        try{
            return this.emprestimo.getDataDevolucao();
        }catch (Exception e){
            return null;
        }
    }

    public void cancelarEmprestimo(){
        this.emprestimo = null;
    }

    public void setEmprestimo(Emprestimo e){
        this.emprestimo = e;
    }

    public void setDisponibilidade(boolean d){
        this.disponilidade = d;
    }

    public String getTituloLivro(){
        return this.livro.getTitulo();
    }
    
}
