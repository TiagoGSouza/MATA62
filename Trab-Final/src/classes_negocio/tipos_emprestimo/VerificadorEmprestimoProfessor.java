package classes_negocio.tipos_emprestimo;

import classes_negocio.Livro;
import classes_negocio.tipos_emprestimo.tipos_verificador.VerificadorAtraso;
import interfaces.IUsuario;
import interfaces.IVerificadorEmprestimo;
import controllers.Console;

public class VerificadorEmprestimoProfessor implements IVerificadorEmprestimo {

    private VerificadorAtraso verificadorAtraso;

    public VerificadorEmprestimoProfessor(){
    this.verificadorAtraso = new VerificadorAtraso();
  }

    @Override
    public boolean verificar(IUsuario usuario, Livro livro) {

        if(!verificadorAtraso.usuarioValido(usuario)){
            Console.imprimirMensagem("\nO usuário " + usuario.getNome() + " possui exemplares ainda não devolvidos em atraso.");
            return false;
        }

        if(!livro.existeExemplarDisponivel()){
            Console.imprimirMensagem("\nNão existe exemplar do livro " + livro.getTitulo() + " disponível.");
            return false;
        }


        return true;
    }
    
}
