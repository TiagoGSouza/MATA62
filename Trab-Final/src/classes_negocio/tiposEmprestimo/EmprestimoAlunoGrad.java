import classes_negocio.Livro;
import interfaces.IUsuario;
import interfaces.IVerificadorEmprestimo;

public class EmprestimoAlunoGrad implements IVerificadorEmprestimo{
  
  @Override
  public boolean verificar(IUsuario usuario, Livro livro){
    //disponilidade de exemplar do livro (não-emprestados)
    boolean livroElegivel = livro.getDisponivel();
    //usuario nao ter exemplares em atraso
    boolean exemplaresEmAtraso = usuario.existeExemplareEmAtraso();
    //estar dentro do limite de emprestimos
    boolean emprestimosUsuario = usuario.limitouEmprestimos();
    //se livro ter qtd de reservas < exemplares disponíveis OU usuario tem reserva
    boolean usuarioFezReserva = usuario.getReservas();
    //usuario nao ter emprestimos do livro
    boolean livroAlugado = usuario.verificaEmprestimo(livro);
  
    return livroElegivel && exemplaresEmAtraso && emprestimosUsuario && usuarioFezReserva && livroAlugado;
  }
}