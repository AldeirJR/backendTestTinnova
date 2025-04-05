import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BubbleSortTest {

    @Test
    public void testBubbleSort() {
        int[] input = {5, 3, 2, 7, 4, 1, 0, 6};
        int[] expected = {0, 1, 2, 3, 4, 5, 6, 7};
        BubbleSort.bubbleSort(input);
        assertArrayEquals(expected, input, "O vetor deve estar ordenado de forma crescente.");
    }
    
    @Test
    public void testBubbleSortAlreadySorted() {
        int[] input = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        BubbleSort.bubbleSort(input);
        assertArrayEquals(expected, input, "O vetor já está ordenado.");
    }
    
    @Test
    public void testBubbleSortEmptyArray() {
        int[] input = {};
        int[] expected = {};
        BubbleSort.bubbleSort(input);
        assertArrayEquals(expected, input, "Vetor vazio deve continuar vazio após a ordenação.");
    }
    
    @Test
    public void testBubbleSortSingleElement() {
        int[] input = {42};
        int[] expected = {42};
        BubbleSort.bubbleSort(input);
        assertArrayEquals(expected, input, "Vetor com um único elemento não deve ser alterado.");
    }
}
