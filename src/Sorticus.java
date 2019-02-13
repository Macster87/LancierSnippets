import java.util.Random;


public class Sorticus {
    // Vorgegebene Arrays
    private static int[] a1 = {10, 20, 1, 8, 9};
    private static int[] a2 = {1, 2, 17, 3, 8};
    private static int[] a3 = {5, 6, 22, 80, 2};
    private static int[] a4 = {7, 8, 42, 2, 2, 4711};
    private static int[] a5 = {80, 8086, 6502, 68000, -753};
    private static int[] a6 = {9,8,7,6,5,4,3,2,1};
    private static int[] a7 = {1,5,17,23,43};
    private static int[] a8 = {1,4,6,7,8,22,160,161,162};

    // Zufalls-Deklaration
    private static final Random rnd = new Random();

    /**
     * Methode zur Bestimmung der Position der kleinsten Zahl in einem Array. Ähnlich wie die Methode in der Klasse "Methode"
     * jedoch mit einem zusätzlichem Start-Parameter, wenn man die Suche von anderer Stelle aus vorwärts ausführen möchte.
     * @param input Ein beliebiges Array mit Integer-Zahlen
     * @param start Startposition. Die Suche wird rechts dieser Position ablaufen.
     * @return Die Positions-Nummer im Array der kleinsten Zahl im gewähltem Abschnitt.
     */
    private static int getSmallestNumberPosition(int[] input, int start) {
        int min = 2147483647;

        for(int i = start; i < input.length; i++) {
            if(input[i] < min) {
                min = input[i];
                start = i;
            }
        }
        return start;
    }

    private static int partition(int[] arr, int left, int right)
    {
        int i = left, j = right;
        int tmp;
        int pivot = arr[(left + right) / 2];

        while (i <= j) {
            while (arr[i] < pivot)
                i++;
            while (arr[j] > pivot)
                j--;
            if (i <= j) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }

        return i;
    }

    private static void quickSort(int[] arr, int left, int right) {
        int index = partition(arr, left, right);
        if (left < index - 1)
            quickSort(arr, left, index - 1);
        if (index < right)
            quickSort(arr, index, right);
    }

    private static int initiative(int arrayLength) {
        int i = 1;
        while(i < arrayLength) i = i*2;
        return i-1;
    }

    private static int[] preSort(int[] input, int width, int offset) {
        int temp;
        int vergleich;
        for(int i = 1 + offset; i < input.length; i = i + width) {
            temp = input[i];
            vergleich = i-(1+width);
            while (vergleich >= 0 && temp < input[vergleich]) {
                input[vergleich + 1 + width] = input[vergleich];
                vergleich--;
            }
            input[vergleich + 1 + width] = temp;
        }
        return input;
    }

    /**
     * Insertion-Sort Algorithmus
     * Mit Dank von Andrea
     * @param input Ein beliebiges Array mit Integer-Zahlen
     * @return Jenes Array aufsteigend sortiert
     */
    private static int[] insertionSort(int[] input) {
        int temp;
        int vergleich;
        for(int i = 1; i < input.length; i++) {
            temp = input[i];
            vergleich = i-1;
            while (vergleich >= 0 && temp < input[vergleich]) {
                input[vergleich + 1] = input[vergleich];
                vergleich--;
            }
            input[vergleich + 1] = temp;
        }
        return input;
    }

    /**
     * Standard Selection-Sort Algorithmus
     * @param input Ein beliebiges Array mit Integer-Zahlen
     * @return Jenes Array aufsteigend sortiert
     */
    private static int[] selectionSort(int[] input) {

        int tmp;

        for(int i = 0; i < input.length-1; i++) {
            int position = getSmallestNumberPosition(input, i+1);
                if(input[position] < input[i]) {
                    tmp = input[position];
                    input[position] =  input[i];
                    input[i] = tmp;
                }
        }

        return input;
    }

    /**
     * Standard Bubble-Sort Algorithmus
     * @param input Ein beliebiges Array mit Integer-Zahlen
     * @return Jenes Array aufsteigend sortiert
     */
    private static int[] bubbleSort(int[] input) {
        boolean finished = false;

        int tmp;
        int changes = 1;

        while(changes != 0) {
            changes = 0;
            for(int i = 0; i < input.length-1; i++) {
                if(input[i] > input[i+1]) {
                    tmp = input[i];
                    input[i] =  input[i+1];
                    input[i+1] = tmp;
                    changes++;
                }
            }
        }
        return input;
    }

    private static int[] bogoSort(int[] input) {

        while (!isSorted(input)) { // Prüfen, ob sortiert
            int a = rnd.nextInt(input.length);
            int b = rnd.nextInt(input.length);

            int tmp = input[a];
            input[a] = input[b];
            input[b] = tmp;
        }

        return input;
    }

    private static boolean isSorted(int[] input) {
        for(int i = 0; i < input.length-1; i++) {
            if(input[i] >= input[i+1]) return false;
        }
        return true;
    }

    /**
     * Hilfsfunktion zur Ausgabe eines Arrays in der Konsole
     * @param input Ein beliebiges Array mit Integer-Zahlen
     */
    private static void showArray(int[] input) {
        for(int item : input) {
            System.out.print(item + " ");
        }
    }

    /**
     * Eine spezielle Form der showArray-Funktion, die auf einem anderen Aufgabenzettel gefordert wurde.
     * Diese Funktion zeigt die ersten 5 und die letzten 5 Elemente des Arrays.
     * @param input Ein beliebiges Array mit Integer-Zahlen
     */
    private static void showArrayFiveFive(int[] input) {
        if(input.length<10) {
            for(int item : input) {
                System.out.print(item + " ");
            }
        } else {
            System.out.print(input[0] + " ");
            System.out.print(input[1] + " ");
            System.out.print(input[2] + " ");
            System.out.print(input[3] + " ");
            System.out.print(input[4] + " ");
            System.out.print("... ");
            System.out.print(input[input.length-5] + " ");
            System.out.print(input[input.length-4] + " ");
            System.out.print(input[input.length-3] + " ");
            System.out.print(input[input.length-2] + " ");
            System.out.print(input[input.length-1] + " ");
        }

    }

    /**
     * Erzeugt einen Array der Länge n und füllt ihn mit Zufallszahlen von 0 bis n. Misst dabei die Zeit.
     * @param n Länge des zu erzeugenden Arrays und zugleich maximalgrenze für den Zufallsgenerator
     * @return Zeit für das Sortieren
     */
    private static int speedtest(int n) {
        int[] array = new int[n];
        for(int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(n);
        }
        long start = System.nanoTime();
        int[] result = bogoSort(array);
        long ende = System.nanoTime();

        showArrayFiveFive(result);
        System.out.println();

        return (int) (ende-start);
    }

    private static int[] melt(int[] input1, int[] input2) {
        int i = 0;
        int pos1 = 0;
        int pos2 = 0;
        int[] merge = new int[input1.length+input2.length];

        while (i<input1.length && pos1 <input2.length)
        {
            if (input1[i] < input2[pos1])
                merge[pos2++] = input1[i++];
            else
                merge[pos2++] = input2[pos1++];
        }

        while (i < input1.length)
            merge[pos2++] = input1[i++];
        while (pos1 < input2.length)
            merge[pos2++] = input2[pos1++];

        return merge;
    }

    public static void main(String[] args) {
        // showArray(bubbleSort(a5));
        // System.out.println(speedtest(4));

        int i = 0;
        int sum = 0;

        //showArray(preSort(a6, 3, 3));
        showArray(melt(a7,a8));
        //while(i < 30) {
        //    sum = sum + speedtest(129);
        //    i++;
        //}
        //System.out.println(sum/i);
    }

}