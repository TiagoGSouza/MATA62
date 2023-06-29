package interfaces;

import classes_negocio.Livro;

public interface IVerificadorEmprestimo{
  public boolean verificar(IUsuario usuario, Livro livro);
  public boolean verificarReserva(IUsuario usuario, Livro livro);
}