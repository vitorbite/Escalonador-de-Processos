public class Main {
    public static void main(String[] args) {
        // Inicializando Listas de Processos
        Scheduler scheduler = new Scheduler();
        ListaDeProcessos lista_alta = scheduler.lista_alta_prioridade;
        ListaDeProcessos lista_media = scheduler.lista_media_prioridade;
        ListaDeProcessos lista_baixa = scheduler.lista_baixa_prioridade;
        ListaDeProcessos lista_bloqueados = scheduler.lista_bloqueados;

        LerArquivo leitor = new LerArquivo(); 
        ListaDeProcessos lista = leitor.LeituraDeArquivo(); // Lendo o arquivo e armazenando a lista com todos os processos 
        Processo atual = lista.cabeça;
        while (atual != null) {
            Processo temp = new Processo(atual.id, atual.nome, atual.prioridade, atual.ciclos_necessarios, atual.recurso_necessario);
            switch (atual.prioridade) {
                case 1:
                    lista_alta.Adicionar(temp); // Adiciona o processo na alta prioridade
                    break;
                case 2:
                    lista_media.Adicionar(temp); // Adiciona o processo na média prioridade
                    break;
                case 3:
                    lista_baixa.Adicionar(temp); // Adiciona o processo na baixa prioridade
                    break;
                default:
                    System.out.println("Prioridade inválida para o processo: " + atual.id + " - " + atual.nome);
                    break;
            }
            atual = atual.proximo;
        }

        // Imprimindo os processos nas listas
        lista_alta.Imprimir();
        lista_media.Imprimir();
        lista_baixa.Imprimir();
        lista_bloqueados.Imprimir();
        scheduler.executarCicloDeCpu(); // Iniciando a execução do ciclo de CPU

    }
}