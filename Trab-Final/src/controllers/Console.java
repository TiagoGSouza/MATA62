package controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import controllers.tipos_comando.ConsultarAluno;
import controllers.tipos_comando.ConsultarLivro;
import controllers.tipos_comando.DevolverLivro;
import controllers.tipos_comando.FinalizaApp;
import controllers.tipos_comando.RealizarEmprestimo;
import controllers.tipos_comando.ReservarLivro;
import interfaces.IComandos;

public class Console {

    private Map<String, IComandos> comandos = new HashMap<String, IComandos>();

    public Console(){
        iniciarComandos();
    }

    public void iniciarComandos(){
        this.comandos.put("emp", new RealizarEmprestimo());
        this.comandos.put("dev", new DevolverLivro());
        this.comandos.put("res", new ReservarLivro());

        this.comandos.put("liv", new ConsultarLivro());
        this.comandos.put("usu", new ConsultarAluno());
        this.comandos.put("sai", new FinalizaApp());
    }

    public void programa(){
        BibliotecaFachada biblioteca;
        biblioteca = BibliotecaFachada.obterInstancia();
        biblioteca.inicializarBiblioteca();
        Scanner teclado = new Scanner(System.in);
        String opcao;
        String comando;
        String parametros;
        boolean condicao = true;

        while (condicao) {
            opcao = teclado.nextLine();

            comando = opcao.substring(0, 3);
            try {
                parametros = opcao.substring(4);
            } catch (Exception e) {
                parametros = "vazio";
            }
            
            IComandos c = comandos.get(comando);
            condicao = c.executa(biblioteca, parametros);
            System.out.println("");

        }

        teclado.close();
    }

    public static void imprimirMensagem(String msg){
        System.out.println(msg);
    }
    
}
