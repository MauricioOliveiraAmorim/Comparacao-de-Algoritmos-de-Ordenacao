public class QuickSort {

    public static int Comparacoes = 0;
    public static int Trocas = 0;
    private static final java.util.Random RAND = new java.util.Random();

    public static void quickSort(int[] array, int inicio, int fim, int pivPolicy) {
        if (inicio < fim) {
            particionar3Vias(array, inicio, fim, pivPolicy);
        }
    }

    private static void particionar3Vias(int[] array, int inicio, int fim, int pivPolicy) {
        if (inicio >= fim) return;

        // Escolhe o pivô conforme a política
        int pivotIndex;
        switch (pivPolicy) {
            case 1: // primeiro elemento
                pivotIndex = inicio;
                break;
            case 2: // aleatório
                pivotIndex = inicio + RAND.nextInt(fim - inicio + 1);
                break;
            case 3: // mediana de três
                int meio = inicio + (fim - inicio) / 2;
                pivotIndex = indiceMediana(array, inicio, meio, fim);
                break;
            default: // último elemento
                pivotIndex = fim;
        }

        int pivo = array[pivotIndex];
        trocar(array, inicio, pivotIndex);
        Trocas++;

        int lt = inicio;     // elementos < pivo
        int gt = fim;        // elementos > pivo
        int i = inicio + 1;  // índice atual

        while (i <= gt) {
            Comparacoes++;
            if (array[i] < pivo) {
                trocar(array, lt++, i++);
                Trocas++;
            } else if (array[i] > pivo) {
                trocar(array, i, gt--);
                Trocas++;
            } else {
                i++;
            }
        }

        // Recursão: divide em três partes
        particionar3Vias(array, inicio, lt - 1, pivPolicy);
        particionar3Vias(array, gt + 1, fim, pivPolicy);
    }

    private static int indiceMediana(int[] array, int a, int b, int c) {
        int va = array[a], vb = array[b], vc = array[c];
        if ((va <= vb && vb <= vc) || (vc <= vb && vb <= va)) return b;
        if ((vb <= va && va <= vc) || (vc <= va && va <= vb)) return a;
        return c;
    }

    private static void trocar(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
