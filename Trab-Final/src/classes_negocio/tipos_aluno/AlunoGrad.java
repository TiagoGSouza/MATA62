package classes_negocio.tipos_aluno;

import java.util.ArrayList;
import java.util.List;
import java.time.*;

import classes_negocio.*;
import interfaces.IUsuario;
import interfaces.IVerificadorEmprestimo;

public class AlunoGrad implements IUsuario {
    private String idUsuario;
    private String nome;
    private ArrayList<Reserva> reservas;
    private ArrayList<Emprestimo> emprestimos;
    private int qtdEmprestimosAtivos;
    private IVerificadorEmprestimo verificadorEmp;

    public AlunoGrad(String idUsuario, String nome){
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.reservas = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
        this.qtdEmprestimosAtivos = 0;
        this.verificadorEmp = Fabrica.obterVerificadorEmprestimoAlunoGrad();
    }

    @Override
    public void realizarEmprestimo(Exemplar exemplar) {
        if(this.verificadorEmp.verificar(this, exemplar.getLivro())){
            Emprestimo emp = new Emprestimo(this, exemplar, 3);
            this.emprestimos.add(emp);
        }
    } 

    @Override
    public void devolverExemplar(Exemplar exemplar) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'devolverExemplar'");
    }

    @Override
    public void reservarLivro(Livro livro) {
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
        return this.qtdEmprestimosAtivos;
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
}
