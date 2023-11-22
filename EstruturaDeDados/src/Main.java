import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

    private int tamanho;
    private LinkedList<Integer> tabela[];

    public Main(int tamanho) {
        this.tamanho = tamanho;
        this.tabela = new LinkedList[tamanho];
    }

    private void adicionar(Integer chave){
        if (tabela[funcaoHash(chave)]== null) {
            tabela[funcaoHash(chave)] = new LinkedList<>();
            tabela[funcaoHash(chave)].add(chave);
        }else{
            tabela[funcaoHash(chave)].add(chave);
        }
    }

    private boolean remover(Integer chave){

        return false;
    }

    private boolean buscar(Integer chave){

        return false;
    }

    @Override
    public String toString(){
        for (int i = 0; i < tabela.length; i++) {
            System.out.print(i+" -> ");
            if (tabela[i] != null) {
                tabela[i].forEach(list -> System.out.print(list+" -> "));
                System.out.println("\\");
            }else{
                System.out.println("\\");
            }
        }

        return "";
    }

    private Integer funcaoHash(Integer chave){
        return chave%this.tamanho;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        int numDeCasosDeTeste = Integer.parseInt(entrada.readLine());
        String linha[];
        int tamanhoHash, numDeChaves, chave;

        while (numDeCasosDeTeste > 0) {
            linha = entrada.readLine().split(" ");
            tamanhoHash = Integer.parseInt(linha[0]);
            //numDeChaves = Integer.parseInt(linha[1]);
            numDeChaves = 0;
            Main hashTable = new Main(tamanhoHash);
            linha = entrada.readLine().split(" ");
            while(numDeChaves < linha.length){
                hashTable.adicionar(Integer.parseInt(linha[numDeChaves]));
                numDeChaves++;
            }
            System.out.println(" ");
           hashTable.toString();
            numDeCasosDeTeste--;
        }


    }
}