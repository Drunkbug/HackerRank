#include <math.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <assert.h>
#include <limits.h>
#include <stdbool.h>

int main(){
    int n; 
    scanf("%d",&n);
    int arr[n];
    int acc1 = 0;
    int acc2 = 0;
    int acc3 = 0;
    for(int arr_i = 0; arr_i < n; arr_i++){
       scanf("%d",&arr[arr_i]);
       if(arr[arr_i] > 0) {
           acc1++;
       } else if(arr[arr_i] < 0) {
           acc2++;
       } else {
           acc3++;
       }
    }
    printf("%.6f\n%.6f\n%.6f\n", (float)acc1/n,(float)acc2/n,(float)acc3/n);
}
