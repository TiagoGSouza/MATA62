package controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import interfaces.IComandos;

public class Console {

    private Map<String, IComandos> comandos = new HashMap<String, IComandos>();

    public Console(){
        iniciarComandos();
    }

    public void iniciarComandos(){
        this.comandos.put("res", new RealizarEmprestimo());
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
            
            System.out.println("Comando: " + comando);
            System.out.println("Paramentros: " + parametros);
            
            IComandos c = comandos.get(comando);
            condicao = c.executa(biblioteca, parametros);

        }

        teclado.close();
    }
    
}
