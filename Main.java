public class Main {
    public static void main(String[] args) {
        Scheduler scheduler = new Scheduler();
        ListaDeProcessos lista_alta = scheduler.lista_alta_prioridade;
        ListaDeProcessos lista_media = scheduler.lista_media_prioridade;
        ListaDeProcessos lista_baixa = scheduler.lista_baixa_prioridade;
        ListaDeProcessos lista_bloqueados = scheduler.lista_bloqueados;

        LerArquivo leitor = new LerArquivo();
        ListaDeProcessos lista = leitor.LeituraDeArquivo();
        Processo atual = lista.cabeça;
        while (atual != null) {
            Processo temp = new Processo(atual.id, atual.nome, atual.prioridade, atual.ciclos_necessarios, atual.recurso_necessario);
            switch (atual.prioridade) {
                case 1:
                    lista_alta.Adicionar(temp);
                    break;
                case 2:
                    lista_media.Adicionar(temp);
                    break;
                case 3:
                    lista_baixa.Adicionar(temp);
                    break;
            }
            atual = atual.proximo;
        }

        lista_alta.Imprimir();
        lista_media.Imprimir();
        lista_baixa.Imprimir();
        lista_bloqueados.Imprimir();
        scheduler.executarCicloDeCpu();
        lista_alta.Imprimir();
        lista_media.Imprimir();
        lista_baixa.Imprimir();
        lista_bloqueados.Imprimir();
    }
}