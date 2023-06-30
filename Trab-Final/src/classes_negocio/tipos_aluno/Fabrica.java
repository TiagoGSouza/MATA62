package classes_negocio.tipos_aluno;
import classes_negocio.tipos_emprestimo.VerificadorEmprestimoAluno;
import interfaces.IVerificadorEmprestimo;

public class Fabrica {

    public static IVerificadorEmprestimo obterVerificadorEmprestimoAluno(){
        return new VerificadorEmprestimoAluno();
    }
}