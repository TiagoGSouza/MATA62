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
            if(livro.existeExemplarNaoReservado() || usuario.fezReserva(livro)){
                if(usuario.realizarEmprestimo(livro)){
                    System.out.println("Empréstimo  do livro " + livro.getTitulo() + " realizado para o usuário " + usuario.getNome() + ".");
                }
            } else {
                System.out.println("Não foi possível emprestar o livro " + livro.getTitulo() + " para o usuário " + usuario.getNome() + " pois os exemplares estão reservados ou emprestados.");
            }
        } else{
            System.out.println("Não foi possível emprestar o livro " + livro.getTitulo() + " para o usuário " + usuario.getNome() + " pois não existe exemplar disponivel.");
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
        int nReservas = livro.getQtdReservas();
        // Titulo
        System.out.println("Título: " + livro.getTitulo());
        // Reservas
        if(nReservas == 0){
            System.out.println("Número de reservas: " + nReservas);
        }else{
            System.out.println("Reservas: ");
            int i = 1;
            for(Reserva reserva : livro.getReservas()){
                System.out.println(i + ". " + reserva.getUsuarioNome());
                i = i+1;
            }
        }
        // Exemplares
        System.out.println("\nExemplares: \nCodigo | Status | Nome do Usuario | Data de Emprestimo | Data de Devolucao");
        for(Exemplar exemplar : livro.getExemplares()){
            System.out.println(exemplar.getCodigo() + " | " + exemplar.getStringDisponibilidade() + " | " + exemplar.getEmprestimoUsuarioNome() + " | " + exemplar.getEmprestimoDataEmp() + " | " + exemplar.getEmprestimoDataDev());
        }

    }

    public void consultarAluno(String codigoAluno){
        IUsuario usuario = getUsuario(codigoAluno);
        try{
            System.out.println("\nEmprestimos: \nTitulo | Data de Emprestimo | Status | Data de Devolucao");
            int i = 1;
            for (Emprestimo emprestimo : usuario.getEmprestimos()) {
                System.out.println(i + ". " + emprestimo.getTituloLivro() + " | " + emprestimo.getDataEmprestimo() + " | " + usuario.getStatusEmprestimo(emprestimo) + " | " + emprestimo.getDataDevolucao());
                i=i+1;            
            }
        }catch(Exception e){
                System.out.println("O usuário não possui emprestimos.");
        }
        try{
            System.out.println("\nReservas: \nTitulo | Data de solicitação");
            int j = 1;
            for (Reserva reserva : usuario.getReservas()) {
                System.out.println(j + ". " + reserva.getTituloLivro() + " | " + reserva.getDataReserva());
                j=j+1;
            }
        } catch (Exception e){
            System.out.println("O usuário não possui reservas.");
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
