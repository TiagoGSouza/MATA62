package classes_negocio.tipos_emprestimo.tipos_verificador;

import interfaces.IUsuario;

public class VerificadorLimiteEmprestimos {

    public boolean usuarioValido(IUsuario usuario){
        //estar dentro do limite de emprestimos
        if (usuario.getEmprestimosAtivos() >= usuario.getQtdEmprestimosPossiveis()){
            return false;
        }
        return true;
    }
}
