#include <math.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <assert.h>
#include <limits.h>
#include <stdbool.h>

int main(){
    //a*3 + (n-a) *5 = a[n]
    int t; 
    scanf("%d",&t);
    for(int a0 = 0; a0 < t; a0++){
        int n; 
        scanf("%d",&n);
        int flag = 0;
        for (int i = n; i >=0; i--) {
            if(i % 3 == 0 && (n-i) % 5 == 0) {
                flag = 1;
                for(int j = 1; j <= n; j++) {
                    if(j<=i) {
                        printf("5");
                    } else {
                        printf("3");
                    }
                }
                break;
            }
        }
        if(flag == 0) {
            printf("-1");
        }
        printf("\n");
    }
    return 0;
}