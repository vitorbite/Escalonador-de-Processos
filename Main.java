public class Main {
    public static void main(String[] args) {
        Scheduler scheduler = new Scheduler();
        ListaDeProcessos lista_alta = scheduler.lista_alta_prioridade;
        ListaDeProcessos lista_media = scheduler.lista_media_prioridade;
        ListaDeProcessos lista_baixa = scheduler.lista_baixa_prioridade;
        ListaDeProcessos lista_bloqueados = scheduler.lista_bloqueados;

        LerArquivo leitor = new LerArquivo();
        
    }
}