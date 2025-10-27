public class HeapSort {
    
    public static int Comparacoes;
    public static int Trocas = 0;

    // Método principal para ordenar o array usando HeapSort
    public static void heapSort(int[] array) {
        int arrayLength = array.length;

        // Constrói um heap máximo
        // Começa do último nó pai (n/2-1) até a raiz
        for (int i = arrayLength / 2 - 1; i >= 0; i--) {
            heapify(array, arrayLength, i);
        }

        // Extrai elementos do heap um por um
        for (int i = arrayLength - 1; i > 0; i--) {
            // Move a raiz atual (maior elemento) para o fim
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            Trocas++;

            // Chama heapify no heap reduzido
            heapify(array, i, 0);
        }
    }

    // Método para transformar uma subárvore em heap máximo
    // rootIndex é o índice da raiz da subárvore
    private static void heapify(int[] array, int heapSize, int rootIndex) {
        int largest = rootIndex;     // Inicializa o maior como raiz
        int leftChild = 2 * rootIndex + 1;   // Índice do filho esquerdo
        int rightChild = 2 * rootIndex + 2;  // Índice do filho direito

        // Se filho esquerdo é maior que a raiz
        if (leftChild < heapSize && array[leftChild] > array[largest]) {
            largest = leftChild;
            Comparacoes++;
        }

        // Se filho direito é maior que o maior até agora
        if (rightChild < heapSize && array[rightChild] > array[largest]) {
            largest = rightChild;
            Comparacoes++;
        }

        // Se o maior não é a raiz
        if (largest != rootIndex) {
            // Troca a raiz com o maior
            int swap = array[rootIndex];
            array[rootIndex] = array[largest];
            array[largest] = swap;
            Trocas++;

            // Recursivamente heapify a subárvore afetada
            heapify(array, heapSize, largest);
        }
    }

}