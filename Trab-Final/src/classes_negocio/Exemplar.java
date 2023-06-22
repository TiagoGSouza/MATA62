package classes_negocio;

public class Exemplar {
    private Livro livro;
    private String codigo;
    private boolean disponilidade;

    public Exemplar(Livro livro, String codigo){
        this.livro = livro;
        this.codigo = codigo;
        this.disponilidade = true;
    }

    public Livro getLivro(){
        return this.livro;
    }

    public String getCodigo(){
        return this.codigo;
    }

    public boolean getDisponibilidade(){
        return this.disponilidade;
    }

    public void setDisponilidade(boolean d){
        this.disponilidade = d;
    }
}
