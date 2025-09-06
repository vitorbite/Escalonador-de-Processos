public class Processo {
    int id = 0;
    String nome;
    int prioridade;
    int ciclos_necessarios;
    String recurso_necessario;
    Processo proximo;
    
public Processo(int id, String nome, int prioridade, int ciclos_necessarios, String recurso_necessario) {
        this.nome = nome;
        this.id = id;
        this.prioridade = prioridade;
        this.ciclos_necessarios = ciclos_necessarios;
        this.recurso_necessario = recurso_necessario;
        this.proximo = null;
    }
}
