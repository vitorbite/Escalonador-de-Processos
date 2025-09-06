public class Processo {
    int id = 0;
    String nome;
    int prioridade;
    int ciclos_necessarios;
    String recurso_necessario;
    Processo proximo;
    
    public Processo(String nome) {
        this.nome = nome;
        this.proximo = null;
    }
}
