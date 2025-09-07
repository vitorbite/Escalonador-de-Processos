public class ListaDeProcessos {

    Processo cabeça;
    Processo cauda;
    int tamanho;
      
   public ListaDeProcesso(){
    this.cabeça = null;
    this.tamanho = 0;
   }

    public void Adicionar(Processo novo) {
        // Processo no = new Processo();
        if (cabeça == null) {
            cabeça = novo;
            cauda = novo;
            tamanho++;
            return;
        }
    }

     public void Remover() {
        if (cabeça.recurso_necessario == "DISCO") {
            scheduler.lista_bloqueados.Adicionar(cabeça);
            
        }
        // Processo atual = cabeça;
        if (cabeça == null) {
            System.out.println("Nenhum processo\n");
            return;
        }    

        if (cabeça.ciclos_necessarios == 0) {
            cabeça = cabeça.proximo;
            tamanho--;
        }else{
            // Adicionar(scheduler.lista_bloqueados.cabeça);
            
            cabeça.ciclos_necessarios--; // remove 1 ciclo
            // Precisa mover para o final da lista
            // Implementar a melhor estrutura de dados depois

            
        }
    }
}