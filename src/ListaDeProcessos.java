public class ListaDeProcessos {
    String nome;
    Processo cabeça;
    Processo cauda;
    int tamanho;

    public ListaDeProcessos(String nome) { // Construtor
        this.nome = nome;
        this.cabeça = null;
        this.tamanho = 0;
    }

    public void Adicionar(Processo novo) {

        if (cabeça == null) { // Verifica se a lista está vazia
            cabeça = novo;
            cauda = novo;
        } else {
            cauda.proximo = novo;
            cauda = novo;
        }
        tamanho++;

    }

    public boolean Remover(ListaDeProcessos lista_bloqueados) { // Executa o processo na cabeça da lista
        if (cabeça == null) {
            System.out.println("Nenhum processo na lista de " + nome + "\n");
            return false;
        }
        if (cabeça.recurso_necessario != null) {
            if (cabeça.recurso_necessario.equalsIgnoreCase("DISCO") && cabeça.i == 0) {
                System.out.println("O Processo " + cabeça.nome + " necessita do recurso DISCO e será bloqueado.");
                Processo bloqueado = cabeça;
                cabeça = cabeça.proximo;
                bloqueado.proximo = null;
                tamanho--;
                lista_bloqueados.Adicionar(bloqueado);
                System.out.println("\nProcesso " + bloqueado.nome + " movido para bloqueados.");
                bloqueado.i++;
                return false; // Não executou ciclo, apenas bloqueou
            }
        }
        System.out.println("Quantidade de ciclos de " + cabeça.nome + ": " + cabeça.ciclos_necessarios + ", da lista " + nome);
        System.out.println("Executando " + cabeça.nome + "...");
        cabeça.ciclos_necessarios--; // remove 1 ciclo
        if (cabeça.ciclos_necessarios == 0) { // Conclusão de processo
            System.out.println("------Processo " + cabeça.id + "- " + cabeça.nome + " concluído.------");
            cabeça = cabeça.proximo;
        } else {
            Processo atual = cabeça;
            cabeça = cabeça.proximo;
            atual.proximo = null; // Limpa o ponteiro!
            Adicionar(atual);
            // Precisa mover para o final da lista
        }
        tamanho--;
        return true;
    }

    public void DesbloquearProcesso(ListaDeProcessos lista_original) { // Desbloqueia o primeiro processo da lista de bloqueados
        if (this.cabeça == null) { // lista de bloqueados vazia
            System.out.println("Nenhum processo bloqueado");
            return;
        }
        Processo desbloqueado = cabeça;
        cabeça = cabeça.proximo;
        desbloqueado.proximo = null;
        tamanho--;
        lista_original.Adicionar(desbloqueado); // Adiciona o processo desbloqueado na sua lista original
        System.out.println("Processo " + desbloqueado.nome + " desbloqueado e movido para sua lista original: " + lista_original.nome);
    }

    public void Imprimir() { // Imprime a lista de processos
        if (cabeça == null) {
            System.out.println("================================");
            System.out.println("\n" + nome + ": ");
            System.out.println("Lista vazia.\n");
            return;
        }

        Processo atual = cabeça;
        System.out.println("================================");
        System.out.println(nome + ": ");
        while (atual != null) {
            System.out.print(atual.id + "- " + atual.nome + " -> ");
            atual = atual.proximo;
        }
        System.out.println("null\n");
    }

    public boolean eVazia() { // Verifica se a lista está vazia
        return tamanho == 0;
    }
}