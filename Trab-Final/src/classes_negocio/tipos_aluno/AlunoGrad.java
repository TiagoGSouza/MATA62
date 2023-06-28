package classes_negocio.tipos_aluno;

import java.util.ArrayList;
import java.util.List;
import java.time.*;

import classes_negocio.*;
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

    public AlunoGrad(String codigo, String nome){
        this.codigo = codigo;
        this.nome = nome;
        this.reservas = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
        this.emprestimosAtivos = new ArrayList<>();
        this.reservasAtivas = new ArrayList<>();
        this.verificadorEmp = Fabrica.obterVerificadorEmprestimoAlunoGrad();
    }

    //mudei o retorno da funcao de realizr emprestimo pra fazer as validacoes corretas
    @Override
    public boolean realizarEmprestimo(Livro livro) {
        if(this.verificadorEmp.verificar(this, livro)){
            Exemplar e = livro.getexisteExemplarDisponivel();
            e.setDisponibilidade(false);
            Emprestimo emp = new Emprestimo(this, e, 3);
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
        for(Emprestimo emprestimo : this.emprestimos){
            if(emprestimo.getLivro() == livro){
                emprestimo.removerExemplar();
                this.emprestimosAtivos.remove(emprestimo);
                System.out.println("\nExemplar do livro " + livro.getTitulo() + " devolvido com sucesso.");
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
            System.out.println("Livro reservado com sucesso.");
            return novaReserva;
        } else{
            System.out.println("O usuário já está no limite de reservas.");
            return null;
        }
    }

    @Override
    public boolean existeExemplarEmAtraso() {
        for (Emprestimo emprestimo : this.emprestimos) {
            if (LocalDate.now().isAfter(emprestimo.getDataDevolucao())){
                return true;
            }
        }
        return false;
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
                System.out.println("\nReserva removida com sucesso.");
                return;
            }
            System.out.println("\nNão foi possível remover a reserva.");
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
}
