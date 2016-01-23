#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>
/*
 CS4800 Programming Assignment 1
 Sort of Sotring
 Leyi Qiang
 HackerRank ID: drunkbug
 */

/*
 Initialize the count for each sorting method to zero
 */
int count1 = 0;
int count2 = 0;
int count3 = 0;


void merge_compare(int *left, int lsize, int *right, int rsize, int *a);

/*
 the function that count the number of comparision in silly sort
 */
int *count_silly_sort(int begin, int n, int *a) {
    if (n < 2) {
        return a;
    } else {
        int i = 0;
        for (; i < n; i++) {
            int k = a[0];
            a[0] = a[i];
            a[i] = k;
            int maybe_sorted[n];
            maybe_sorted[0] = a[0];
            int *newArray;
            int buffer[n-1];
            for (int b = 1; b < n; b++) {
                buffer[b-1] = a[b];
            }
            newArray = count_silly_sort(begin,n-1, buffer);
            int l = 1;
            for(; l < n; l++) {
                maybe_sorted[l] = newArray[l-1];
            }
            int j = 0;
            int flag = 0;
            for (; j < n - 1; j++) {
                count1++;
                if (maybe_sorted[j] > maybe_sorted[j + 1]) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                return maybe_sorted;
            } else {
                k = a[0];
                a[0] = a[i];
                a[i] = k;
            }
            
        }
    }
    return a;
}

/*
 the funtion that count the number of comparison in bubble sort
 */
int *count_bubble_sort(int n, int a[]) {
    while (1) {
        int swapped_this_turn = 0;
        int i = 0;
        for (; i < n - 1; i++) {
            count2++;
            if (a[i] > a[i + 1]) {
                int k = a[i];
                a[i] = a[i + 1];
                a[i + 1] = k;
                swapped_this_turn = 1;
            }
        }
        
        if (!swapped_this_turn) {
            return a;
        }
        
    }
}


/*
 the funtion that count the number of comparison in merge sort
 */
int *count_merge_sort(int n, int* a) {
    int *left, *right, i;
    if (n < 2) {
        return a;
    }
    int middle = n/2;
    left = (int *)malloc(middle * sizeof(int));
    right = (int *)malloc((n-middle) * sizeof(int));
    
    for (i = 0; i < middle; i++) {
        left[i] = a[i];
    }
    
    for (i = middle; i < n; i++) {
        right[i-middle] = a[i];
    }
    count_merge_sort(middle, left);
    count_merge_sort(n - middle, right);
    merge_compare(left,middle, right, n-middle, a);
    free(left);
    free(right);
    return a;
}

/*
 helper function for count_merge_sort
 */
void merge_compare(int *left, int lsize, int *right, int rsize, int *a) {
    int i = 0;
    int j = 0;
    int k = 0;
    while (i < lsize && j < rsize) {
        count3++;
        if (left[i] < right[j]) {
            a[k] = left[i];
            k++;
            i++;
        } else {
            a[k] = right[j];
            k++;
            j++;
        }
    }
    while(i<lsize) {
        a[k++] = left[i++];
    }
    
    while(j < rsize) {
        a[k++] = right[j++];
    }
}

int main() {
    
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    int n;
    scanf("%d", &n);
    int a[n];
    int a1[n];
    int a2[n];
    int i = 0;
    for (; i < n; i++) {
        int x;
        scanf("%d", &x);
        a[i] = x;
        a1[i] = x;
        a2[i] = x;
    }
    if (n > 9) {
        printf("-1\n");
    } else {
        int *hold = count_silly_sort(0,n, a);
        int j = 0;
        printf("%d\n", count1);
    }
    if (n > pow(10, 5)) {
        printf("-1\n");
    } else {
        count_bubble_sort(n, a1);
        printf("%d\n", count2);
    }
    
    count_merge_sort(n, a2);
    printf("%d\n", count3);
}
