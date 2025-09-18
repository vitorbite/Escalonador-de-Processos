package src;
public class Scheduler {
    ListaDeProcessos lista_alta_prioridade = new ListaDeProcessos("Alta Prioridade");
    ListaDeProcessos lista_media_prioridade = new ListaDeProcessos("Média Prioridade");
    ListaDeProcessos lista_baixa_prioridade = new ListaDeProcessos("Baixa Prioridade");
    // Criando instâncias das listas de processos
    ListaDeProcessos lista_bloqueados = new ListaDeProcessos("Bloqueados");
    int contador_ciclos_alta_prioridade = 0; // contador para a regra de anti-inanição

    public void executarCicloDeCpu() {
        while (!lista_alta_prioridade.eVazia() || !lista_media_prioridade.eVazia() || !lista_baixa_prioridade.eVazia() || !lista_bloqueados.eVazia()) {
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
                System.out.println("Regra de Anti-inanição acionada.");
                if (!lista_media_prioridade.eVazia()) {

                    lista_media_prioridade.Remover(lista_bloqueados); // executa média prioridade
                    lista_media_prioridade.Imprimir();

                } else if (!lista_baixa_prioridade.eVazia()) {
                    lista_baixa_prioridade.Remover(lista_bloqueados); // executa baixa prioridade
                    lista_baixa_prioridade.Imprimir();
                }
                contador_ciclos_alta_prioridade = 0;
                System.out.println("==========================================");

            } else {

                // Regra de execução padrão
                if (!lista_alta_prioridade.eVazia()) {
                    boolean executado = lista_alta_prioridade.Remover(lista_bloqueados); // executa alta prioridade
                    lista_alta_prioridade.Imprimir();
                    if (executado) {
                        contador_ciclos_alta_prioridade++;
                    }
                    System.out.println("Contador de ciclos de alta prioridade: " + contador_ciclos_alta_prioridade);
                } else if (!lista_media_prioridade.eVazia()) {
                    lista_media_prioridade.Remover(lista_bloqueados); // executa média prioridade
                    lista_media_prioridade.Imprimir();
                } else if (!lista_baixa_prioridade.eVazia()) {
                    lista_baixa_prioridade.Remover(lista_bloqueados); // executa baixa prioridade
                    lista_baixa_prioridade.Imprimir();
                }
            }
            System.out.println("\n");
        }
    }
}
