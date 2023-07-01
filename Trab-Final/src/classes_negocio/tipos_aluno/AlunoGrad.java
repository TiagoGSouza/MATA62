package classes_negocio.tipos_aluno;

import java.util.ArrayList;
import java.util.List;

import classes_negocio.*;
import classes_negocio.tipos_emprestimo.regras.LimiteEmprestimos;
import classes_negocio.tipos_emprestimo.regras.TempoEmprestimo;
import interfaces.IUsuario;
import interfaces.IVerificadorEmprestimo;

public class AlunoGrad implements IUsuario {
    private String codigo;
    private String nome;
    private ArrayList<Reserva> reservas;
    private ArrayList<Emprestimo> emprestimos;
    private ArrayList<Emprestimo> emprestimosAtivos;
    private ArrayList<Reserva> reservasAtivas;
    private IVerificadorEmprestimo verificadorEmp;
    private int qtdDiasDeEmprestimo;
    private int limiteEmprestimosAtivos;

    public AlunoGrad(String codigo, String nome){
        this.codigo = codigo;
        this.nome = nome;
        this.reservas = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
        this.emprestimosAtivos = new ArrayList<>();
        this.reservasAtivas = new ArrayList<>();
        this.verificadorEmp = Fabrica.obterVerificadorEmprestimoAluno();
        this.qtdDiasDeEmprestimo = TempoEmprestimo.ALUNOGRAD.getQtdDias();
        this.limiteEmprestimosAtivos = LimiteEmprestimos.ALUNOGRAD.getQtdDias();
    }

    @Override
    public boolean realizarEmprestimo(Livro livro) {
        if(this.verificadorEmp.verificar(this, livro)){
            Exemplar e = livro.getexisteExemplarDisponivel();
            e.setDisponibilidade(false);
            Emprestimo emp = new Emprestimo(this, e, this.qtdDiasDeEmprestimo);
            e.setEmprestimo(emp);
            this.emprestimos.add(emp);
            this.emprestimosAtivos.add(emp);
            this.removerReserva(livro);
            return true;
        }
        return false;
    } 

    @Override
    public boolean devolverExemplar(Livro livro) {
        for(Emprestimo emprestimo : this.emprestimosAtivos){
            if(emprestimo.getLivro() == livro){
                emprestimo.removerExemplar();
                this.emprestimosAtivos.remove(emprestimo);
                return true;
            }
        }
        return false;
    }

    @Override
    //quantas reservas um livro pode ter?
    public Reserva reservarLivro(Livro livro) {
        if(this.reservasAtivas.size() < 3){// verifica limite de reservas do aluno
            Reserva novaReserva = new Reserva(this, livro);
            this.reservas.add(novaReserva);
            this.reservasAtivas.add(novaReserva);
            return novaReserva;
        } else{
            return null;
        }
    }

    public int getEmprestimosAtivos(){
        return this.emprestimosAtivos.size();
    }

    public List<Reserva> getReservas(){
        return this.reservas;
    }

    public List<Emprestimo> getEmprestimos(){
        return this.emprestimos;
    }

    public String getNome(){
        return this.nome;
    }

    public void removerReserva(Livro livro){
        for(Reserva reserva : this.reservas){
            if(reserva.getLivro().equals(livro)){
                this.reservas.remove(reserva);
//                System.out.println("\nReserva removida com sucesso.");
                return;
            }
//            System.out.println("\nNão existe reserva desse livro.");
        }
    }

    public String getCodigo(){
        return this.codigo;
    }

    public String getExemplarEmprestado(Livro livro){
        for (Emprestimo emprestimo : emprestimos) {
            if(emprestimo.getLivro() == livro){
                return emprestimo.getExemplar().getCodigo();
            }
        }
        return null;
    }

    public String getStatusEmprestimo(Emprestimo emprestimo){
        if(this.emprestimosAtivos.contains(emprestimo)){
            return "Ativo";
        } else {
            return "Finalizado";
        }
    }

    public int getQtdEmprestimosPossiveis(){
        return this.limiteEmprestimosAtivos;
    }
}
