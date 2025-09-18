import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LerArquivo {
        public ListaDeProcessos LeituraDeArquivo() {
            String caminho = "../processo.txt"; // nome do arquivo
            ListaDeProcessos lista = new ListaDeProcessos("Processos Lidos");

            try (BufferedReader br = new BufferedReader(new FileReader(caminho)))  { // cria o buffer para ler o arquivo
                String linha;
                

                while ((linha = br.readLine()) != null) {
                    
                    linha = linha.trim(); //remover os espaços da leitura

                    String[] partes = linha.split(","); //separa os atributos por virgula

                    int id = Integer.parseInt(partes[0].trim());
                    String nome = partes[1].trim().replace("\"", "");
                    int prioridade = Integer.parseInt(partes[2].trim());
                    int ciclos = Integer.parseInt(partes[3].trim());
                    String recurso = partes[4].trim().replace("\"", "");
                    if (recurso.isEmpty()) {
                        recurso = null; // se o recurso for vazio, atribui como null
                    }

                    Processo processo = new Processo(id, nome, prioridade, ciclos, recurso);
                    lista.Adicionar(processo);
                }
                
            } catch (IOException e) {
                  e.printStackTrace();
            }
            return lista; // retorna a lista com todos os processos lidos
        }
}
