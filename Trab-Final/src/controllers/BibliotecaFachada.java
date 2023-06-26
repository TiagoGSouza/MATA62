package controllers;

import java.util.ArrayList;
import java.util.List;

import classes_negocio.Exemplar;
import classes_negocio.Livro;
import classes_negocio.tipos_aluno.AlunoGrad;
import interfaces.IUsuario;

public class BibliotecaFachada {

    private BibliotecaFachada(){};

    private static BibliotecaFachada biblioteca;
    private List<IUsuario> usuarios = new ArrayList<IUsuario>();
    private List<Livro> livros = new ArrayList<Livro>();

    public static BibliotecaFachada obterInstancia(){
        if(biblioteca == null){
            biblioteca = new BibliotecaFachada();
        }
        return biblioteca;
    }

    public void inicializarBiblioteca(){
        usuarios.add(new AlunoGrad("123", "João da Silva"));
        usuarios.add(new AlunoGrad("789", "Pedro Paulo"));
        livros.add(new Livro("100", "Engenharia de Software", "AddisonWesley", "Ian Sommervile", "6", "2000"));
        Exemplar exemplar = new Exemplar(livros.get(0), "01");
        livros.get(0).addExemplar(exemplar);        
    }

    public void realizarEmprestimo(String codigoUsuario, String codigoLivro){
        IUsuario usuario = getUsuario(codigoUsuario);
        Livro livro = getLivro(codigoLivro);
        if(livro.existeExemplarDisponivel()){
            if(usuario.realizarEmprestimo(livro)){
                System.out.println("Empréstimo realizado.");
            }
            System.out.println("Usuario: " + usuario.getNome());
            System.out.println("Livro: " + livro.getTitulo());
        } else{
            System.out.println("Não existe exemplar disponivel.");
        }
    }

    public Livro getLivro(String codigoLivro){
        for (Livro livro : livros) {
            if(livro.getCodigo().equals(codigoLivro)){
                return livro;
            }
        }
        return null;
    }

    public IUsuario getUsuario(String codigoUsuario){
        for (IUsuario usuario : usuarios) {
            if(usuario.getCodigo().equals(codigoUsuario)){
                return usuario;
            }
        }
        return null;
    }
    
}
