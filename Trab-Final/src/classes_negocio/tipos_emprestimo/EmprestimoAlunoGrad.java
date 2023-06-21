package classes_negocio.tipos_emprestimo;

import classes_negocio.Emprestimo;
import classes_negocio.Livro;
import classes_negocio.Reserva;
import interfaces.IUsuario;
import interfaces.IVerificadorEmprestimo;

public class EmprestimoAlunoGrad implements IVerificadorEmprestimo{
  
  @Override
  public boolean verificar(IUsuario usuario, Livro livro){

    //usuario nao ter exemplares em atraso
    boolean exemplaresEmAtraso = usuario.existeExemplarEmAtraso();
    if(exemplaresEmAtraso==true){
      System.err.println("\nO usuário possui exemplares ainda não devolvidos em atraso.");
      return false;
    }

    //estar dentro do limite de emprestimos
    if (usuario.getEmprestimosAtivos() >= 3){
      System.err.println("\nO usuário ultrapassou o limite de empréstimos.");
      return false;
    }

    //se livro ter qtd de reservas < exemplares disponíveis OU usuario tem reserva
    //disponilidade de exemplar do livro (não-emprestados)
    boolean exemplarDisponivel = true;
    int qtdReservasLivro = livro.getQtdReservas();
    int qtdExemplaresLivro = livro.getQtdExemplares();
    if(qtdExemplaresLivro <= qtdReservasLivro){
      exemplarDisponivel = false;
    }

    boolean usuarioFezReserva = false;
    for (Reserva  reserva: usuario.getReservas()) {
      if(reserva.getLivro() == livro){
        usuarioFezReserva = true;
      }
    }
    
    if(!exemplarDisponivel && !usuarioFezReserva){
      System.err.println("Não há exemplares disponíveis.");
      return false;
    }

    //usuario nao ter emprestimos do livro
    for (Emprestimo emprestimo : usuario.getEmprestimos()) {
      if(emprestimo.getLivro().equals(livro)){
        System.err.println("\nO livro já foi emprestado pelo usuário.");
        return false;
      }
    }
    return true;
  }
}