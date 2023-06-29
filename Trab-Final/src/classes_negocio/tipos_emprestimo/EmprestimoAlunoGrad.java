package classes_negocio.tipos_emprestimo;

import classes_negocio.Livro;
import classes_negocio.tipos_emprestimo.tipos_verificador.VerificadorAtraso;
import classes_negocio.tipos_emprestimo.tipos_verificador.VerificadorEmprestimosAtivos;
import classes_negocio.tipos_emprestimo.tipos_verificador.VerificadorLimiteEmprestimos;
import classes_negocio.tipos_emprestimo.tipos_verificador.VerificadorReserva;
import interfaces.IUsuario;
import interfaces.IVerificadorEmprestimo;

/* 
as verificações das regras de emprestimo podem ser todos em uma classe ou metodo usando ifs
o proprio usuario pode conter e chamar seu verificador
*/

public class EmprestimoAlunoGrad implements IVerificadorEmprestimo{

  private VerificadorAtraso verificadorAtraso;
  private VerificadorReserva verificadorReserva;
  private VerificadorLimiteEmprestimos verificadorLimiteEmprestimos;
  private VerificadorEmprestimosAtivos verificadorEmprestimosAtivos;

  public EmprestimoAlunoGrad(){
    this.verificadorAtraso = new VerificadorAtraso();
    this.verificadorReserva = new VerificadorReserva();
    this.verificadorLimiteEmprestimos = new VerificadorLimiteEmprestimos();
    this.verificadorEmprestimosAtivos = new VerificadorEmprestimosAtivos();
  }
  
  @Override
  public boolean verificar(IUsuario usuario, Livro livro){

    if(!verificadorAtraso.usuarioValido(usuario)){
      System.err.println("\nO usuário possui exemplares ainda não devolvidos em atraso.");
      return false;
    }

    if(!verificadorLimiteEmprestimos.usuarioValido(usuario)){
      System.err.println("\nO usuário ultrapassou o limite de empréstimos.");
      return false;
    }

    //se livro ter qtd de reservas < exemplares disponíveis OU usuario tem reserva
    //disponilidade de exemplar do livro (não-emprestados)
    boolean existeExemplarDisponivel = true;
    int qtdReservasLivro = livro.getQtdReservas();
    int qtdExemplaresLivro = livro.getQtdExemplares();
    if(qtdExemplaresLivro <= qtdReservasLivro){
      existeExemplarDisponivel = false;
    }

    boolean usuarioFezReserva = verificadorReserva.usuarioValido(usuario, livro);
    
    if(!existeExemplarDisponivel && !usuarioFezReserva){
      System.err.println("Não há exemplares disponíveis.");
      return false;
    }

    if(!verificadorEmprestimosAtivos.usuarioValido(usuario, livro)){
      System.err.println("\nO livro já foi emprestado pelo usuário.");
      return false;
    }

    return true;
  }
}