package classes_negocio.tipos_emprestimo.tipos_verificador;

import classes_negocio.Emprestimo;
import classes_negocio.Livro;
import interfaces.IUsuario;

public class VerificadorEmprestimosAtivos {

    public boolean usuarioValido(IUsuario usuario, Livro livro){
        for (Emprestimo emprestimo : usuario.getEmprestimos()) {
            if(emprestimo.getLivro().equals(livro)){
                return false;
            }
        }
        return true;
    }

}
