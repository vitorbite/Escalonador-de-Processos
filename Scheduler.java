public class Scheduler {
    ListaDeProcessos lista_alta_prioridade = new ListaDeProcessos();
    ListaDeProcessos lista_media_prioridade = new ListaDeProcessos();
    ListaDeProcessos lista_baixa_prioridade = new ListaDeProcessos();

    ListaDeProcessos lista_bloqueados = new ListaDeProcessos();
    int contador_ciclos_alta_prioridade = 0;

    public void executarCicloDeCpu() {
        while (!lista_alta_prioridade.eVazia() || !lista_media_prioridade.eVazia()  !lista_baixa_prioridade.eVazia() || !lista_bloqueados.eVazia()) {
        // Desbloqueando Processo da lista de bloqueados
            if (!lista_bloqueados.eVazia()) {
                switch (lista_bloqueados.cabeça.prioridade) {
                    case 1:
                        lista_bloqueados.DesbloquearProcesso(lista_alta_prioridade);
                        break;
                    case 2:
                        lista_bloqueados.DesbloquearProcesso(lista_media_prioridade);
                        break;
                    case 3:
                        lista_bloqueados.DesbloquearProcesso(lista_baixa_prioridade);
                        break;
                }
                lista_bloqueados.Imprimir();
            }

    // aplicando regra de anti-inanição

        if (contador_ciclos_alta_prioridade == 5) {
            lista_media_prioridade.Remover(lista_bloqueados);
            if (lista_media_prioridade.tamanho == 0) {
                lista_baixa_prioridade.Remover(lista_bloqueados);
            }
            contador_ciclos_alta_prioridade = 0;
            
        }
            else {
             lista_alta_prioridade.Remover(lista_bloqueados);
             contador_ciclos_alta_prioridade++;
             lista_media_prioridade.Remover(lista_bloqueados);
             lista_baixa_prioridade.Remover(lista_bloqueados);
            }
        } 
    }  
}
