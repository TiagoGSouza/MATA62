package classes_negocio.tipos_aluno;

public enum TempoEmprestimo {
    ALUNOGRAD (3), 
    ALUNOPOS (4),
    PROFESSOR (7);

    private final int dias;
    TempoEmprestimo(int qtDias){
        this.dias = qtDias;
    }

    public int getQtdDias(){
        return this.dias;
    }
}
