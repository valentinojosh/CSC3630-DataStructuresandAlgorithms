import java.util.Arrays;

public class Sorting2Arrays_Valentino {
    public static void main (String[] args)
    {
        int[] X = { 1, 4, 7, 8, 10 };
        int[] Y = { 2, 3, 9 };

        merge(X, Y);

        System.out.println("X: " + Arrays.toString(X));
        System.out.println("Y: " + Arrays.toString(Y));
    }

    private static void merge(int[] x, int[] y) {
        for(int i =0; i < x.length; i++){
            if (x[i] > y[0]){
                x[i] = x[i] + y[0];
                y[0] = x[i] - y[0];
                x[i] = x[i] - y[0];
                Arrays.sort(y);
            }
        }
    }
}
