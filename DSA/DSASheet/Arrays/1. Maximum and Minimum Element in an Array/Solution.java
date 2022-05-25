class Solution {
    // create pair
    static class Pair {
        int min;
        int max;
    }

    static Pair getMinMax(int arr[], int n) {
        Pair minMax = new Pair();

        // assuming n is always greater than 0
        if (n == 1) {
            minMax.min = arr[0];
            minMax.max = arr[0];
            return minMax;
        }

        int remainder = n % 2;
        int i;

        if (remainder == 0) {
            if (arr[0] < arr[1]) {
                minMax.min = arr[0];
                minMax.max = arr[1];
            } else {
                minMax.min = arr[1];
                minMax.max = arr[0];
            }
            i = 2;
        } else {
            minMax.min = arr[0];
            minMax.max = arr[0];
            i = 1;
        }

        // compare in pairs
        while (i < n - 1) {
            if (arr[i] < arr[i + 1]) {
                if (arr[i] < minMax.min)
                    minMax.min = arr[i];

                if (arr[i + 1] > minMax.max)
                    minMax.max = arr[i + 1];
            } else {
                if (arr[i + 1] < minMax.min)
                    minMax.min = arr[i + 1];

                if (arr[i] > minMax.max)
                    minMax.max = arr[i];
            }
            i = i + 2;
        }
        return minMax;
    }

    public static void main(String[] args) {
        int arr[] = { 1000, 11, 445, 1, 330, 3000 };
        int arr_size = 6;
        Pair minmax = getMinMax(arr, arr_size);
        System.out.printf("\nMinimum element is %d", minmax.min);
        System.out.printf("\nMaximum element is %d", minmax.max);
    }
}