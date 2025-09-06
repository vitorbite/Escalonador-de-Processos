public class ListaDeProcesso {

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
            tamanho++;
            return;
        }
    }
}