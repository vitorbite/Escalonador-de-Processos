import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LerArquivo {
       
        public static void main(String[] args) {
            String caminho = "processo.txt"; // nome do arquivo

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

                    System.out.println("ID: " + id);
                    System.out.println("Nome: " + nome);
                    System.out.println("Prioridade: " + prioridade);
                    System.out.println("Ciclos: " + ciclos);
                    System.out.println("Recurso: " + recurso);
                    System.out.println("---------------------");


                    
                }
                
            } catch (IOException e) {
                  e.printStackTrace();
            }
        
    
        
    }
}
