package classes_negocio.tipos_emprestimo.tipos_verificador;

import java.time.LocalDate;

import classes_negocio.Emprestimo;
import interfaces.IUsuario;

public class VerificadorAtraso {

    public boolean usuarioValido(IUsuario usuario){
        for (Emprestimo emprestimo : usuario.getEmprestimos()) {
            if(LocalDate.now().isAfter(emprestimo.getDataDevolucao())){
                return false;
            }
        }
        return true;
    }
}