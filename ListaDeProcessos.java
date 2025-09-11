public class ListaDeProcessos {

    Processo cabeça;
    Processo cauda;
    int tamanho;
      
   public ListaDeProcessos(){
    this.cabeça = null;
    this.tamanho = 0;
   }

    public void Adicionar(Processo novo) {
        
        if (cabeça == null) {
            cabeça = novo;
            cauda = novo;
        }else{
            cauda.proximo = novo;
            cauda = novo;
            }
            tamanho++;
            
        }
    
    // Fazer alterações no futuro ------------------------
     public void Remover(ListaDeProcessos lista_bloqueados) {
        if (cabeça.recurso_necessario == "DISCO") {
            
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
            //Adicionar(scheduler.lista_bloqueados.cabeça);
            
            cabeça.ciclos_necessarios--; // remove 1 ciclo
            // Precisa mover para o final da lista
            // Implementar a melhor estrutura de dados depois

            //
        }
    }
}