import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static int count1;
    static int count2;
    static int count3;

    static int[] count_silly_sort(int n, int[] array) {
        if (n < 2) {
            return array;
        } else {
            for (int i = 0; i < n; i++) {
                int k = array[0];
                array[0] = array[i];
                array[i] = k;
                int maybe_sorted[] = new int[n];
                maybe_sorted[0] = array[0];
                int[] newArray = count_silly_sort(n - 1, Arrays.copyOfRange(array, 1, n));
                for (int j = 1; j < n; j++) {
                    maybe_sorted[j] = newArray[j - 1];
                }
                int m = 0;
                int flag = 0;
                for (; m < n - 1; m++) {
                    count1++;
                    if (maybe_sorted[m] > maybe_sorted[m + 1]) {
                        flag = 1;
                        break;
                    }
                }
                if (flag == 0) {
                    return maybe_sorted;
                } else {
                    k = array[0];
                    array[0] = array[i];
                    array[i] = k;
                }
            }
        }

        return array;
    }

    static int[] count_bubble_sort(int n, int[] array) {
        while (true) {
            boolean swapped_this_turn = false;
            for (int i = 0; i < n - 1; i++) {
                count2++;
                if (array[i] > array[i + 1]) {
                    int k = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = k;
                    swapped_this_turn = true;
                }
            }
            if (!swapped_this_turn) {
                return array;
            }
        }
    }

    static int[] count_merge_sort(int n, int[] array) {
        if (n < 2) {
            return array;
        }
        int middle = (int) Math.floor((double) (n) / 2);
        int[] left = Arrays.copyOfRange(array, 0, middle);
        int[] right = Arrays.copyOfRange(array, middle, n);
        left = count_merge_sort(middle, left);
        right = count_merge_sort(n - middle, right);
        int i = 0;
        int j = 0;
        int k = 0;
        while (i<left.length && j < right.length) {
            count3++;
            if(left[i] < right[j]) {
                array[k] = left[i];
                k++;
                i++;
            } else {
                array[k] = right[j];
                k++;
                j++;
            }
        }
        if(i < left.length) {
            for(; k < n; k++) {
                array[k] = left[i];
                i++;
            }
        } else {
            for(int l = k; l < n; l++) {
                array[l] = right[j];
                j++;
            }
        }
        return array;
    }


    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        int n = reader.nextInt();
        int array[] = new int[n];
        int array1[] = new int[n];
        int array2[] = new int[n];
        for (int i = 0; i < n; i++) {
            int r = reader.nextInt();
            array[i] = r;
            array1[i] = r;
            array2[i] = r;
        }

        if (n > 9) {
            System.out.println("-1");
        } else {
            Solution.count_silly_sort(n, array);
            System.out.println(count1);
        }

        if (n > Math.pow(10, 5)) {
            System.out.println("-1");
        } else {
            Solution.count_bubble_sort(n,array1);
            System.out.println(count2);
        }

        Solution.count_merge_sort(n, array2);
        System.out.println(count3);

    }
}