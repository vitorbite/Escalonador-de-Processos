public class ListaDeProcessos {
    String nome;
    Processo cabeça;
    Processo cauda;
    int tamanho;

    public ListaDeProcessos(String nome) {
        this.nome = nome;
        this.cabeça = null;
        this.tamanho = 0;
    }

    public void Adicionar(Processo novo) {

        if (cabeça == null) {
            cabeça = novo;
            cauda = novo;
        } else {
            cauda.proximo = novo;
            cauda = novo;
        }
        tamanho++;

    }

    public boolean Remover(ListaDeProcessos lista_bloqueados) {
        if (cabeça == null) {
            System.out.println("Nenhum processo na lista de " + nome + "\n");
            return false;
        }
        if (cabeça.recurso_necessario != null) {
            if (cabeça.recurso_necessario.equalsIgnoreCase("DISCO") && cabeça.i == 0) {
                Processo bloqueado = cabeça;
                cabeça = cabeça.proximo;
                bloqueado.proximo = null;
                tamanho--;
                lista_bloqueados.Adicionar(bloqueado);
                System.out.println("\nProcesso " + bloqueado.nome + " movido para bloqueados.");
                lista_bloqueados.Imprimir();
                bloqueado.i++;
                return Remover(lista_bloqueados);
            }
        }
        System.out.println(
                "Quantidade de ciclos de " + cabeça.nome + ": " + cabeça.ciclos_necessarios + ", da lista " + nome);
        System.out.println("Executando " + cabeça.nome + "...");
        cabeça.ciclos_necessarios--; // remove 1 ciclo
        if (cabeça.ciclos_necessarios == 0) {
            System.out.println("------Processo " + cabeça.nome + " concluído.------");
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

    public void DesbloquearProcesso(ListaDeProcessos lista_original) {
        if (this.cabeça == null) {
            System.out.println("Nenhum processo bloqueado");
            return;
        }
        Processo desbloqueado = cabeça;
        cabeça = cabeça.proximo;
        desbloqueado.proximo = null;
        tamanho--;
        lista_original.Adicionar(desbloqueado);
        System.out.println("Processo " + desbloqueado.nome + " desbloqueado e movido para sua lista original: " + lista_original.nome);
        lista_original.Imprimir();
    }

    public void Imprimir() {
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

    public boolean eVazia() {
        return tamanho == 0;
    }
}