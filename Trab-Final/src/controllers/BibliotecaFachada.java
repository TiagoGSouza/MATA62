package controllers;

import java.util.ArrayList;
import java.util.List;

import classes_negocio.Emprestimo;
import classes_negocio.Exemplar;
import classes_negocio.Livro;
import classes_negocio.Reserva;
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
        livros.add(new Livro("101", "UML - Guia do Usuário", "Campus", "Grady Booch, James Rumbaugh, Ivar Jacobson", "7", "2000")); 
        livros.get(0).addExemplar(new Exemplar(livros.get(0), "01"));
        livros.get(0).addExemplar(new Exemplar(livros.get(0), "02"));
        livros.get(1).addExemplar(new Exemplar(livros.get(1), "03"));        
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

    public void reservarLivro(String codigoUsuario, String codigoLivro){
        IUsuario usuario = getUsuario(codigoUsuario);
        Livro livro = getLivro(codigoLivro);
        if(livro.existeExemplarDisponivel()){
            Reserva reserva = usuario.reservarLivro(livro);
            livro.addReserva(reserva);
        } else{
            System.out.println("Não existe exemplar disponivel.");
        }
    }

    public void devolverLivro(String codigoUsuario, String codigoLivro){
        IUsuario usuario = getUsuario(codigoUsuario);
        Livro livro = getLivro(codigoLivro);
        String codigoExemplar = usuario.getExemplarEmprestado(livro);
        if(usuario.devolverExemplar(livro)){
            livro.setExemplarDisponivel(codigoExemplar);
        } else {
            System.out.println("\nNão foi possível realizar a operação: o usuário " + usuario.getNome() + " não possui emprestimos do livro " + livro.getTitulo());
        }
    }

    public void consultarLivro(String codigoLivro){
        Livro livro = getLivro(codigoLivro);
        System.out.println("\nQt exemplares: " + livro.getQtdExemplares());
        int nReservas = livro.getQtdReservas();
        // Titulo
        System.out.println("\nTítulo: " + livro.getTitulo());
        

        // Reservas
        if(nReservas == 0){
            System.out.println("\nNúmero de reservas: " + nReservas);
        }else{
            System.out.println("\nReservas: ");
            int i = 1;
            for(Reserva reserva : livro.getReservas()){
                System.out.println("\n" + i + ". " + reserva.getUsuarioNome());
                i = i+1;
            }
        }

        // Exemplares
        System.out.println("\nExemplares: \nCodigo / Status /    Se Emprestado:    / Nome do Usuario / Data de Emprestimo / Data de Devolucao");
        for(Exemplar exemplar : livro.getExemplares()){
            System.out.println("\n" + exemplar.getCodigo() + " | " + exemplar.getDisponibilidade() + " | " + exemplar.getEmprestimoUsuarioNome() + " | " + exemplar.getEmprestimoDataEmp() + " | " + exemplar.getEmprestimoDataDev());
        }

    }

    public void consultarAluno(String codigoAluno){
        IUsuario usuario = getUsuario(codigoAluno);
        System.out.println("Emprestimos");
        for (Emprestimo emprestimo : usuario.getEmprestimos()) {
            System.out.println("Livro: " + emprestimo.getLivro());
            System.out.println("Data do emprestimo: " + emprestimo.getDataEmprestimo());
            System.out.println("Data de devolução: " + emprestimo.getDataDevolucao());
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
