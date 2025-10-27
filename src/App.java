import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner Teclado = new Scanner(System.in);

        //Inicio
        System.out.println("=== Comparação de Algoritmos de Ordenação ===");
        System.out.println("Digite os tamanhos dos Vetores a testar (Ex: 1000, 10000, 100000)");
        int Tamanho = Teclado.nextInt(); //Tamanho dos Vetores utilizados 


        System.out.println("Digite o número de repetições (K) para cada teste: ");
        int K = Teclado.nextInt(); //Número de repetições para cada algoritimo de ordenação
        

        System.out.println("Escolha a política de pivô do Quick Sort: "); // O pivô é o ponto de corte que divide o vetor em partes menores e maiores no Quick Sort.
        System.out.println("1-Primeiro elemento");
        System.out.println("2-Aleatório");
        System.out.println("3-Mediana de três");
        int pivo = Teclado.nextInt(); // pivo escolhido 



        //Aleatória (uniforme)
        for(int i = 0; i<K; i++){
            Random randomGlobal = new Random(67+i);
            //Cria VetorBase
            int[] VetorBase = new int[Tamanho];

            //Gerando conjunto de dados sendo Aleatorio
            for(int j = 0; j< Tamanho; j++){
                VetorBase[j] = randomGlobal.nextInt(Tamanho * 100 + 1);
            }

            //Clonar VetorBase para os 3 algoritimos de ordenação 
            int[] VetorMergeSort = VetorBase.clone();
            int[] VetorHeapSort = VetorBase.clone();
            int[] VetorQuickSort = VetorBase.clone();

            // MERGE SORT
            MergeSort.Trocas = 0; //Evitar Somatoria quando K != 0
            MergeSort.Comparacoes = 0; //Evitar Somatoria quando K != 0
            long start = System.nanoTime(); //Começa a contagem em nano
            MergeSort.mergeSort(VetorMergeSort, 0, VetorMergeSort.length-1); //Ordenação
            long end = System.nanoTime(); //Encerra a contagem
            double TM = (end - start) / 1_000_000.0; //Converte nanos → milissegundos
            MatrizCSV.AdicionarMatriz(Tamanho,"Aleatória","Merge Sort","O(n log n)","O(n log n)",TM,MergeSort.Comparacoes,MergeSort.Trocas);
            for(int confirm = 0; confirm<VetorMergeSort.length - 1;confirm++){
                if(VetorMergeSort[confirm]>VetorMergeSort[confirm+1]){
                    System.out.println("Erro na MergeSort Aleatoria, repetição: " + i);
                }
            }



            HeapSort.Trocas = 0; //Evitar Somatoria quando K != 0
            HeapSort.Comparacoes = 0; //Evitar Somatoria quando K != 0
            start = System.nanoTime(); //Começa a contagem em nano
            HeapSort.heapSort(VetorHeapSort); //Ordenação
            end = System.nanoTime(); //Encerra a contagem
            TM = (end - start) / 1_000_000.0; //Converte nanos → milissegundos
            MatrizCSV.AdicionarMatriz(Tamanho,"Aleatória","Heap Sort","O(n log n)","O(n log n)",TM,HeapSort.Comparacoes,HeapSort.Trocas);
            for(int confirm = 0; confirm<VetorHeapSort.length-1;confirm++){
                if(VetorHeapSort[confirm]>VetorHeapSort[confirm+1]){
                    System.out.println("Erro na HeapSort Aleatoria, repetição: " + i);
                }
            }



            QuickSort.Trocas = 0; //Evitar Somatoria quando K != 0
            QuickSort.Comparacoes = 0; //Evitar Somatoria quando K != 0
            start = System.nanoTime(); //Começa a contagem em nano
            QuickSort.quickSort(VetorQuickSort, 0, VetorQuickSort.length-1, pivo); //Ordenação
            end = System.nanoTime(); //Encerra a contagem
            TM = (end - start) / 1_000_000.0; //Converte nanos → milissegundos
            MatrizCSV.AdicionarMatriz(Tamanho,"Aleatória","Quick Sort","O(n log n)","O(n log n)",TM,QuickSort.Comparacoes,QuickSort.Trocas);
            for(int confirm = 0; confirm<VetorQuickSort.length-1;confirm++){
                if(VetorQuickSort[confirm]>VetorQuickSort[confirm+1]){
                    System.out.println("Erro na QuickSort Aleatoria, repetição: " + i);
                }
            }
        }

        //Quase ordenada (10% de perturbacao)
        for(int i = 0; i<K; i++){
            Random randomGlobal = new Random(67+i);
            //Cria VetorBase
            int[] VetorBase = new int[Tamanho];

            //Gerando conjunto de dados sendo Aleatorio 
            for(int j = 0; j< Tamanho; j++){
                VetorBase[j] = randomGlobal.nextInt(Tamanho * 100 + 1);
            }
            HeapSort.heapSort(VetorBase);

            //Criando pertubação no Vetor ordenado
            int perturbacao = (int)(Tamanho*0.1);
            Random random = new Random();
            for(int j = 0; j<perturbacao;j++){
                int index1 = random.nextInt(Tamanho);
                int index2 = random.nextInt(Tamanho);

                int aux = VetorBase[index1];
                VetorBase[index1] = VetorBase[index2];
                VetorBase[index2] = aux;
            }

            //Clonar VetorBase para os 3 algoritimos de ordenação 
            int[] VetorMergeSort = VetorBase.clone();
            int[] VetorHeapSort = VetorBase.clone();
            int[] VetorQuickSort = VetorBase.clone();

            // MERGE SORT
            MergeSort.Trocas = 0; //Evitar Somatoria quando K != 0
            MergeSort.Comparacoes = 0; //Evitar Somatoria quando K != 0
            long start = System.nanoTime(); //Começa a contagem em nano
            MergeSort.mergeSort(VetorMergeSort, 0, VetorMergeSort.length-1); //Ordenação
            long end = System.nanoTime(); //Encerra a contagem
            double TM = (end - start) / 1_000_000.0; //Converte nanos → milissegundos
            MatrizCSV.AdicionarMatriz(Tamanho,"Quase ordenada","Merge Sort","O(n log n)","O(n log n)",TM,MergeSort.Comparacoes,MergeSort.Trocas);
            for(int confirm = 0; confirm<VetorMergeSort.length-1;confirm++){
                if(VetorMergeSort[confirm]>VetorMergeSort[confirm+1]){
                    System.out.println("Erro na MergeSort Quase ordenada, repetição: " + i);
                }
            }


            HeapSort.Trocas = 0; //Evitar Somatoria quando K != 0
            HeapSort.Comparacoes = 0; //Evitar Somatoria quando K != 0
            start = System.nanoTime(); //Começa a contagem em nano
            HeapSort.heapSort(VetorHeapSort); //Ordenação
            end = System.nanoTime(); //Encerra a contagem
            TM = (end - start) / 1_000_000.0; //Converte nanos → milissegundos
            MatrizCSV.AdicionarMatriz(Tamanho,"Quase ordenada","Heap Sort","O(n log n)","O(n log n)",TM,HeapSort.Comparacoes,HeapSort.Trocas);
            for(int confirm = 0; confirm<VetorHeapSort.length-1;confirm++){
                if(VetorHeapSort[confirm]>VetorHeapSort[confirm+1]){
                    System.out.println("Erro na HeapSort Quase ordenada, repetição: " + i);
                }
            }

            QuickSort.Trocas = 0; //Evitar Somatoria quando K != 0
            QuickSort.Comparacoes = 0; //Evitar Somatoria quando K != 0
            start = System.nanoTime(); //Começa a contagem em nano
            QuickSort.quickSort(VetorQuickSort, 0, VetorQuickSort.length-1, pivo); //Ordenação
            end = System.nanoTime(); //Encerra a contagem
            TM = (end - start) / 1_000_000.0; //Converte nanos → milissegundos
            MatrizCSV.AdicionarMatriz(Tamanho,"Quase ordenada","Quick Sort","O(n log n)","O(n log n)",TM,QuickSort.Comparacoes,QuickSort.Trocas);
            for(int confirm = 0; confirm<VetorQuickSort.length-1;confirm++){
                if(VetorQuickSort[confirm]>VetorQuickSort[confirm+1]){
                    System.out.println("Erro na QuickSort Quase ordenada, repetição: " + i);
                }
            }
        }


        //Reversa (estritamente decrescente)
        for(int i = 0; i<K; i++){
            //Cria VetorBase
            int[] VetorBase = new int[Tamanho];

            //Gerando conjunto de dados sendo Reverso
            int reverso = Tamanho;
            for(int j = 0; j< Tamanho; j++){
                VetorBase[j] = reverso;
                reverso--;
            }

            //Clonar VetorBase para os 3 algoritimos de ordenação 
            int[] VetorMergeSort = VetorBase.clone();
            int[] VetorHeapSort = VetorBase.clone();
            int[] VetorQuickSort = VetorBase.clone();

            // MERGE SORT
            MergeSort.Trocas = 0; //Evitar Somatoria quando K != 0
            MergeSort.Comparacoes = 0; //Evitar Somatoria quando K != 0
            long start = System.nanoTime(); //Começa a contagem em nano
            MergeSort.mergeSort(VetorMergeSort, 0, VetorMergeSort.length-1); //Ordenação
            long end = System.nanoTime(); //Encerra a contagem
            double TM = (end - start) / 1_000_000.0; //Converte nanos → milissegundos
            MatrizCSV.AdicionarMatriz(Tamanho,"Reversa","Merge Sort","O(n log n)","O(n log n)",TM,MergeSort.Comparacoes,MergeSort.Trocas);
            for(int confirm = 0; confirm<VetorMergeSort.length-1;confirm++){
                if(VetorMergeSort[confirm]>VetorMergeSort[confirm+1]){
                    System.out.println("Erro na MergeSort Reversa, repetição: " + i);
                }
            }


            HeapSort.Trocas = 0; //Evitar Somatoria quando K != 0
            HeapSort.Comparacoes = 0; //Evitar Somatoria quando K != 0
            start = System.nanoTime(); //Começa a contagem em nano
            HeapSort.heapSort(VetorHeapSort); //Ordenação
            end = System.nanoTime(); //Encerra a contagem
            TM = (end - start) / 1_000_000.0; //Converte nanos → milissegundos
            MatrizCSV.AdicionarMatriz(Tamanho,"Reversa","Heap Sort","O(n log n)","O(n log n)",TM,HeapSort.Comparacoes,HeapSort.Trocas);
            for(int confirm = 0; confirm<VetorHeapSort.length-1;confirm++){
                if(VetorHeapSort[confirm]>VetorHeapSort[confirm+1]){
                    System.out.println("Erro na HeapSort Reversa, repetição: " + i);
                }
            }


            QuickSort.Trocas = 0; //Evitar Somatoria quando K != 0
            QuickSort.Comparacoes = 0; //Evitar Somatoria quando K != 0
            start = System.nanoTime(); //Começa a contagem em nano
            QuickSort.quickSort(VetorQuickSort, 0, VetorQuickSort.length-1, pivo); //Ordenação
            end = System.nanoTime(); //Encerra a contagem
            TM = (end - start) / 1_000_000.0; //Converte nanos → milissegundos
            MatrizCSV.AdicionarMatriz(Tamanho,"Reversa","Quick Sort","O(n log n)","O(n log n)",TM,QuickSort.Comparacoes,QuickSort.Trocas);
            for(int confirm = 0; confirm<VetorHeapSort.length-1;confirm++){
                if(VetorHeapSort[confirm]>VetorHeapSort[confirm+1]){
                    System.out.println("Erro na QuickSort Reversa, repetição: " + i);
                }
            }
        }



        System.out.println("Digite o tamanho da amostragem de valores distintos deseja : ");
        int distintos = Teclado.nextInt();
        //Com muitos repetidos (amostragem de poucos valores distintos)
        for(int i = 0; i<K; i++){
            Random randomGlobal = new Random(67+i);
            //Cria VetorBase
            int[] VetorBase = new int[Tamanho];

            //Gerando conjunto de dados sendo Aleatorio 
            for(int j = 0; j< Tamanho; j++){
                VetorBase[j] = randomGlobal.nextInt(distintos);
            }

            //Clonar VetorBase para os 3 algoritimos de ordenação 
            int[] VetorMergeSort = VetorBase.clone();
            int[] VetorHeapSort = VetorBase.clone();
            int[] VetorQuickSort = VetorBase.clone();

            // MERGE SORT
            MergeSort.Trocas = 0; //Evitar Somatoria quando K != 0
            MergeSort.Comparacoes = 0; //Evitar Somatoria quando K != 0
            long start = System.nanoTime(); //Começa a contagem em nano
            MergeSort.mergeSort(VetorMergeSort, 0, VetorMergeSort.length-1); //Ordenação
            long end = System.nanoTime(); //Encerra a contagem
            double TM = (end - start) / 1_000_000.0; //Converte nanos → milissegundos
            MatrizCSV.AdicionarMatriz(Tamanho,"Repetidos","Merge Sort","O(n log n)","O(n log n)",TM,MergeSort.Comparacoes,MergeSort.Trocas);
            for(int confirm = 0; confirm<VetorMergeSort.length-1;confirm++){
                if(VetorMergeSort[confirm]>VetorMergeSort[confirm+1]){
                    System.out.println("Erro na MergeSort Repetidos, repetição: " + i);
                }
            }


            HeapSort.Trocas = 0; //Evitar Somatoria quando K != 0
            HeapSort.Comparacoes = 0; //Evitar Somatoria quando K != 0
            start = System.nanoTime(); //Começa a contagem em nano
            HeapSort.heapSort(VetorHeapSort); //Ordenação
            end = System.nanoTime(); //Encerra a contagem
            TM = (end - start) / 1_000_000.0; //Converte nanos → milissegundos
            MatrizCSV.AdicionarMatriz(Tamanho,"Repetidos","Heap Sort","O(n log n)","O(n log n)",TM,HeapSort.Comparacoes,HeapSort.Trocas);
            for(int confirm = 0; confirm<VetorHeapSort.length-1;confirm++){
                if(VetorHeapSort[confirm]>VetorHeapSort[confirm+1]){
                    System.out.println("Erro na HeapSort Repetidos, repetição: " + i);
                }
            }

            QuickSort.Trocas = 0; //Evitar Somatoria quando K != 0
            QuickSort.Comparacoes = 0; //Evitar Somatoria quando K != 0
            start = System.nanoTime(); //Começa a contagem em nano
            QuickSort.quickSort(VetorQuickSort, 0, VetorQuickSort.length-1, pivo); //Ordenação
            end = System.nanoTime(); //Encerra a contagem
            TM = (end - start) / 1_000_000.0; //Converte nanos → milissegundos
            MatrizCSV.AdicionarMatriz(Tamanho,"Repetidos","Quick Sort","O(n log n)","O(n log n)",TM,QuickSort.Comparacoes,QuickSort.Trocas);
            for(int confirm = 0; confirm<VetorQuickSort.length-1;confirm++){
                if(VetorQuickSort[confirm]>VetorQuickSort[confirm+1]){
                    System.out.println("Erro na QuickSort Repetidos, repetição: " + i);
                }
            }
        }
        MatrizCSV.exportarCSV("arroz");
    }
}
