public class BubbleSort {

    // Método que implementa o Bubble Sort
    public static void bubbleSort(int[] v) {
        for (int i = 0; i < v.length - 1; i++) {
            for (int j = 0; j < v.length - 1 - i; j++) {
                if (v[j] > v[j + 1]) {
                    int temp = v[j];
                    v[j] = v[j + 1];
                    v[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] v = {5, 3, 2, 7, 4, 1, 0, 6};
        bubbleSort(v);
        System.out.print("Vetor ordenado: ");
        for (int i = 0; i < v.length; i++) {
            System.out.print(v[i] + " ");
        }
    }
}
