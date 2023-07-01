package classes_negocio.tipos_emprestimo.regras;

public enum LimiteEmprestimos {
    ALUNOGRAD (3), 
    ALUNOPOS (4);

    private final int dias;
    LimiteEmprestimos(int qtDias){
        this.dias = qtDias;
    }

    public int getQtdDias(){
        return this.dias;
    }
}
