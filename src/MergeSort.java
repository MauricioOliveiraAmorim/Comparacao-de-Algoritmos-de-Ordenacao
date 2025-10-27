public class MergeSort {

    public static int Comparacoes;
    public static int Trocas;

    // Função principal do MergeSort
    public static void mergeSort(int[] array, int left, int right) {
        // Se o subarray tem mais de um elemento
        if (left < right) {
            int middle = (left + right) / 2; // Calcula o meio do array

            // Ordena a metade esquerda
            mergeSort(array, left, middle);

            // Ordena a metade direita
            mergeSort(array, middle + 1, right);

            // Junta as duas metades ordenadas
            merge(array, left, middle, right);
        }
    }

    // Função que mescla dois subarrays ordenados
    static void merge(int[] array, int left, int middle, int right) {
        int leftSize = middle - left + 1; // Tamanho do subarray esquerdo
        int rightSize = right - middle;   // Tamanho do subarray direito

        int[] leftArray = new int[leftSize];  // Array temporário para a esquerda
        int[] rightArray = new int[rightSize]; // Array temporário para a direita

        // Copia os elementos para os arrays temporários
        for (int i = 0; i < leftSize; i++) {
            leftArray[i] = array[left + i];
        }
        for (int i = 0; i < rightSize; i++) {
            rightArray[i] = array[middle + 1 + i];
        }

        int leftIndex = 0;   // Índice para percorrer o leftArray
        int rightIndex = 0;  // Índice para percorrer o rightArray
        int mergedIndex = left; // Índice para inserir no array original

        // Mescla os arrays temporários de volta ao array original
        while (leftIndex < leftSize && rightIndex < rightSize) {
            Comparacoes++;
            if (leftArray[leftIndex] <= rightArray[rightIndex]) {
                array[mergedIndex] = leftArray[leftIndex];
                leftIndex++;
            } else {
                array[mergedIndex] = rightArray[rightIndex];
                rightIndex++;
            }
            Trocas++;
            mergedIndex++;
        }

        // Copia os elementos restantes do leftArray, se houver
        while (leftIndex < leftSize) {
            array[mergedIndex] = leftArray[leftIndex];
            leftIndex++;
            mergedIndex++;
            Trocas++;
        }

        // Copia os elementos restantes do rightArray, se houver
        while (rightIndex < rightSize) {
            array[mergedIndex] = rightArray[rightIndex];
            rightIndex++;
            mergedIndex++;
            Trocas++;
        }
    }

}