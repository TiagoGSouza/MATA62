import classes_negocio.tipos_aluno.AlunoGrad;
import interfaces.IUsuario;


public class App {


    public static void main(String[] args) throws Exception {
        
        IUsuario aluno1 = new AlunoGrad("123", "Teste");
        System.out.println("Nome: " + aluno1.getNome());
        System.out.println("Emprestimos: " + aluno1.getEmprestimos());
        System.out.println("Emprestimos ativos: " + aluno1.getEmprestimosAtivos());

    }



}
