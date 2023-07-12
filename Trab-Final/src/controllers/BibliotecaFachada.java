package controllers;

import java.util.ArrayList;
import java.util.List;

import classes_negocio.Emprestimo;
import classes_negocio.Exemplar;
import classes_negocio.Livro;
import classes_negocio.Reserva;
import classes_negocio.tipos_usuario.AlunoGrad;
import classes_negocio.tipos_usuario.AlunoPos;
import classes_negocio.tipos_usuario.Professor;
import interfaces.IUsuario;
import interfaces.Observer;

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
        //Usuarios
        usuarios.add(new AlunoGrad("123", "João da Silva"));
        usuarios.add(new AlunoPos("456", "Luiz Fernando Rodrigues"));
        usuarios.add(new AlunoGrad("789", "Pedro Paulo"));
        usuarios.add(new Professor("100", "Carlos Lucena"));
        //Livros
        livros.add(new Livro("100", "Engenharia de Software", "AddisonWesley", "Ian Sommervile", "6", "2000"));
        livros.add(new Livro("101", "UML - Guia do Usuário", "Campus", "Grady Booch, James Rumbaugh, Ivar Jacobson", "7", "2000")); 
        livros.add(new Livro("200", "Code Complete", "Microsoft Press", "Steve McConnel", "2", "2014")); 
        livros.add(new Livro("201", "Agile Software Development Principles, Patterns, and Practices", "Prentice Hall", "Robert Martin", "1", "2002")); 
        livros.add(new Livro("300", "Refactoring: Improving the Design of Existing Code", "Addison-Wesley Professional", "Martin Fowler", "1", "1999"));
        livros.add(new Livro("301", "Software Metrics: A Rigorous and Practical Approach", "CRC Press", "Norman Fenton, James Bieman", "3", "2014"));
        livros.add(new Livro("400", "Design Patterns: Elements of Reusable Object-Oriented Software", "Addison-Wesley Professional", "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides", "1", "1994"));
        livros.add(new Livro("401", "UML Distilled: A Brief Guide to the Standard Object Modeling Language", "Addison-Wesley Professional", "Martin Fowler", "3", "2003"));
        //Exemplares
        livros.get(0).addExemplar(new Exemplar(livros.get(0), "01"));//100
        livros.get(0).addExemplar(new Exemplar(livros.get(0), "02"));//100
        livros.get(1).addExemplar(new Exemplar(livros.get(1), "03"));//101
        livros.get(2).addExemplar(new Exemplar(livros.get(2), "04"));//200
        livros.get(3).addExemplar(new Exemplar(livros.get(3), "05"));//201
        livros.get(4).addExemplar(new Exemplar(livros.get(4), "06"));//300
        livros.get(4).addExemplar(new Exemplar(livros.get(4), "07"));//300
        livros.get(6).addExemplar(new Exemplar(livros.get(6), "08"));//400
        livros.get(6).addExemplar(new Exemplar(livros.get(6), "09"));//400
        livros.get(6).addExemplar(new Exemplar(livros.get(6), "10"));//400    
    
    }

    public void realizarEmprestimo(String codigoUsuario, String codigoLivro){
        IUsuario usuario = getUsuario(codigoUsuario);
        Livro livro = getLivro(codigoLivro);
        String resp;
        if(livro.existeExemplarDisponivel()){
            if(usuario.realizarEmprestimo(livro)){
                resp = "\nEmpréstimo  do livro " + livro.getTitulo() + " realizado para o usuário " + usuario.getNome() + ".";
                Console.imprimirMensagem(resp);
            }
        } else{
            resp = "\nNão foi possível emprestar o livro " + livro.getTitulo() + " para o usuário " + usuario.getNome() + " pois não existe exemplar disponivel.";
            Console.imprimirMensagem(resp);
        }
    }

    public void reservarLivro(String codigoUsuario, String codigoLivro){
        IUsuario usuario = getUsuario(codigoUsuario);
        Livro livro = getLivro(codigoLivro);
        String resp;
        if(livro.existeExemplarDisponivel()){
            if(livro.getQtdExemplares() > livro.getQtdReservas()){
                Reserva reserva = usuario.reservarLivro(livro);
                if(reserva != null){
                    livro.addReserva(reserva);
                    resp = "\nO usuário " + usuario.getNome() + " reservou o livro " + livro.getTitulo() + ".";
                    Console.imprimirMensagem(resp);
                } else {
                    resp = "\nO usuário " + usuario.getNome() + " já está no limite de reservas.";
                    Console.imprimirMensagem(resp);
                }
            } else {
                resp = "\nTodos exemplares do livro " + livro.getTitulo() + " estão reservados.";
                Console.imprimirMensagem(resp);
            }
        } else{
            resp = "\nNão existe exemplar disponivel do livro " + livro.getTitulo() + ".";
            Console.imprimirMensagem(resp);
        }
    }

    public void devolverLivro(String codigoUsuario, String codigoLivro){
        IUsuario usuario = getUsuario(codigoUsuario);
        Livro livro = getLivro(codigoLivro);
        String codigoExemplar = usuario.getExemplarEmprestado(livro);
        String resp;
        if(usuario.devolverExemplar(livro)){
            livro.setExemplarDisponivel(codigoExemplar);
            resp = "\nExemplar do livro " + livro.getTitulo() + " devolvido pelo usuário " + usuario.getNome() + ".";
            Console.imprimirMensagem(resp);
        } else {
            resp = "\nNão foi possível realizar a operação: o usuário " + usuario.getNome() + " não possui emprestimos do livro " + livro.getTitulo();
            Console.imprimirMensagem(resp);
        }
    }

    public void consultarLivro(String codigoLivro){
        Livro livro = getLivro(codigoLivro);
        int nReservas = livro.getQtdReservas();
        // Titulo
        Console.imprimirMensagem("\nTítulo: " + livro.getTitulo());
        // Reservas
        if(nReservas == 0){
            Console.imprimirMensagem("Número de reservas: " + nReservas);
        }else{
            Console.imprimirMensagem("Reservas: ");
            int i = 1;
            for(Reserva reserva : livro.getReservas()){
                Console.imprimirMensagem(i + ". " + reserva.getUsuarioNome());
                i = i+1;
            }
        }
        // Exemplares
        Console.imprimirMensagem("\nExemplares: \nCodigo | Status | Nome do Usuario | Data de Emprestimo | Data de Devolucao");
        for(Exemplar exemplar : livro.getExemplares()){
            Console.imprimirMensagem(exemplar.getCodigo() + " | " + exemplar.getStringDisponibilidade() + " | " + exemplar.getEmprestimoUsuarioNome() + " | " + exemplar.getEmprestimoDataEmp() + " | " + exemplar.getEmprestimoDataDev());
        }

    }

    public void consultarAluno(String codigoAluno){
        IUsuario usuario = getUsuario(codigoAluno);
        try{
            Console.imprimirMensagem("\nEmprestimos: \nTitulo | Data de Emprestimo | Status | Data de Devolucao");
            int i = 1;
            for (Emprestimo emprestimo : usuario.getEmprestimos()) {
                Console.imprimirMensagem(i + ". " + emprestimo.getTituloLivro() + " | " + emprestimo.getDataEmprestimo() + " | " + usuario.getStatusEmprestimo(emprestimo) + " | " + emprestimo.getDataDevolucao());
                i=i+1;            
            }
        }catch(Exception e){
                Console.imprimirMensagem("O usuário não possui emprestimos.");
        }
        try{
            Console.imprimirMensagem("\nReservas: \nTitulo | Data de solicitação");
            int j = 1;
            for (Reserva reserva : usuario.getReservas()) {
                Console.imprimirMensagem(j + ". " + reserva.getTituloLivro() + " | " + reserva.getDataReserva());
                j=j+1;
            }
        } catch (Exception e){
            Console.imprimirMensagem("O usuário não possui reservas.");
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
    
    public void registrarObservador(String codigoUsuario, String codigoLivro){
        Livro livro = getLivro(codigoLivro);
        IUsuario usuario = getUsuario(codigoUsuario);

        livro.registrarObserver( (Observer) usuario);
    }

    public void consultarProfessor(String codigoProf){
        Observer professor = (Observer) getUsuario(codigoProf);
        String resp = Integer.toString(professor.getNotificacoes());
        Console.imprimirMensagem(resp);
    }

}
