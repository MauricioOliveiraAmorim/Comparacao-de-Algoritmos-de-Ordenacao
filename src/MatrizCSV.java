import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MatrizCSV {
    public static List<Integer> Tamanhos = new ArrayList<>();
    public static List<String> Distribuicao = new ArrayList<>();
    public static List<String> Algoritmo = new ArrayList<>();
    public static List<String> Teorico = new ArrayList<>();
    public static List<String> Pratico = new ArrayList<>();
    public static List<Double> TempoMedio = new ArrayList<>();
    public static List<Integer> Comparacao = new ArrayList<>();
    public static List<Integer> Troca = new ArrayList<>();

    // Método para salvar dados 
    public static void AdicionarMatriz(int n, String distribuicao, String algoritimo, String teorico, 
    String pratico, double tM, int comparacao, int troca){

        Tamanhos.add(n);
        Distribuicao.add(distribuicao);
        Algoritmo.add(algoritimo);
        Teorico.add(teorico);
        Pratico.add(pratico);
        TempoMedio.add(tM);
        Comparacao.add(comparacao);
        Troca.add(troca);

    }


    // Exporta CSV para pasta do projeto 
    public static void exportarCSV(String nomeArquivo) {
        try (FileWriter writer = new FileWriter(nomeArquivo + ".csv")) {
            writer.write("n,Distribuicao,Algoritmo,Teorico,Pratico,TempoMedio(ms),Comparacoes,Trocas\n");
            
            for (int i = 0; i < Tamanhos.size(); i++) {
                writer.write(String.format(Locale.US,"%d,%s,%s,%s,%s,%.6f,%d,%d\n",
                        Tamanhos.get(i),
                        Distribuicao.get(i),
                        Algoritmo.get(i),
                        Teorico.get(i),
                        Pratico.get(i),
                        TempoMedio.get(i),
                        Comparacao.get(i),
                        Troca.get(i)
                ));
            }
            System.out.println("Arquivo CSV exportado com sucesso: " + nomeArquivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
