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
    }

    public void programa(){
        BibliotecaFachada biblioteca;
        biblioteca = BibliotecaFachada.obterInstancia();
        biblioteca.inicializarBiblioteca();
        Scanner teclado = new Scanner(System.in);
        String opcao;
        String[] parametros;
        boolean condicao = true;

        while (condicao) {
            opcao = teclado.nextLine();

            parametros = opcao.split(" ");
            System.out.println("Paramentros[0]: " + parametros[0]);
            System.out.println("Paramentros[1]: " + parametros[1]);
            System.out.println("Paramentros[2]: " + parametros[2]);
            
            IComandos c = comandos.get(parametros[0]);
            condicao = c.executa(biblioteca, parametros[1], parametros[2]);

        }

        teclado.close();
    }
    
}
