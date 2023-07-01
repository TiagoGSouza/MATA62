package classes_negocio.tipos_usuario;

import java.util.ArrayList;
import java.util.List;

import classes_negocio.Emprestimo;
import classes_negocio.Exemplar;
import classes_negocio.Livro;
import classes_negocio.Reserva;
import classes_negocio.tipos_emprestimo.regras.TempoEmprestimo;
import interfaces.IUsuario;
import interfaces.IVerificadorEmprestimo;

public class Professor implements IUsuario {
    private String codigo;
    private String nome;
    private ArrayList<Reserva> reservas;
    private ArrayList<Emprestimo> emprestimos;
    private ArrayList<Emprestimo> emprestimosAtivos;
    private ArrayList<Reserva> reservasAtivas;
    private IVerificadorEmprestimo verificadorEmp;
    private int qtdDiasDeEmprestimo;

    public Professor(String codigo, String nome){
        this.codigo = codigo;
        this.nome = nome;
        this.reservas = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
        this.emprestimosAtivos = new ArrayList<>();
        this.reservasAtivas = new ArrayList<>();
        this.verificadorEmp = Fabrica.obterVerificadorEmprestimoProfessor();
        this.qtdDiasDeEmprestimo = TempoEmprestimo.PROFESSOR.getQtdDias();
    }

    @Override
    public boolean realizarEmprestimo(Livro livro) {
        if(this.verificadorEmp.verificar(this, livro)){
            Exemplar e = livro.getExemplarDisponivel();
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
        for (Emprestimo emprestimo : this.emprestimosAtivos) {
            if(emprestimo.getLivro() == livro){
                emprestimo.removerExemplar();
                this.emprestimosAtivos.remove(emprestimo);
                return true;
            }            
        }
        return false;
    }

    @Override
    public Reserva reservarLivro(Livro livro) {
        if(this.reservasAtivas.size() < 3){
            Reserva novaReserva = new Reserva(this, livro);
            this.reservas.add(novaReserva);
            this.reservasAtivas.add(novaReserva);
            return novaReserva;
        } else{
            return null;
        }
    }

    @Override
    public int getEmprestimosAtivos(){
        return this.emprestimosAtivos.size();
    }

    @Override
    public List<Reserva> getReservas(){
        return this.reservas;
    }

    @Override
    public List<Emprestimo> getEmprestimos(){
        return this.emprestimos;
    }

    @Override
    public String getNome(){
        return this.nome;
    }

    @Override
    public void removerReserva(Livro livro) {
        for(Reserva reserva : this.reservas){
            if(reserva.getLivro().equals(livro)){
                this.reservas.remove(reserva);
                return;
            }
        }
    }

    @Override
    public String getCodigo() {
        return this.codigo;
    }

    @Override
    public String getExemplarEmprestado(Livro livro) {
        for (Emprestimo emprestimo : emprestimos) {
            if(emprestimo.getLivro() == livro){
                return emprestimo.getExemplar().getCodigo();
            }
        }
        return null;
    }

    @Override
    public String getStatusEmprestimo(Emprestimo emprestimo) {
        if(this.emprestimosAtivos.contains(emprestimo)){
            return "Ativo";
        } else {
            return "Finalizado";
        }
    }    
}
