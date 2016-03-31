import java.util.Scanner;

/**
 * Created by leyiqiang on 2/26/16.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int knum = input.nextInt();
        int[] ks = new int[knum];
        for (int i = 0; i < knum; i++) {
            ks[i] = input.nextInt();
        }

        int lnum = input.nextInt();
        int[] ls = new int[lnum];
        for (int i = 0; i < lnum; i++) {
            ls[i] = input.nextInt();
        }
        knum--;
        lnum--;
        int cmax = knum + lnum;
        int acc;
        int atZero=cmax;
        for (int i = cmax; i >= 0; i--) {
            acc = 0;
            if(cmax == 0) {
                System.out.print(acc);
                break;
            }
            for (int j = 0; j <= i; j++) {
                int kacc = j;
                int lacc = i - j;
                if (kacc > knum || lacc > lnum) {
                    continue;
                }
                if(ks[knum-kacc] > 100 || ls[lnum-lacc] > 100) {
                    throw new RuntimeException("as");
                }
                acc += ks[knum-kacc] * ls[lnum-lacc];
            }
            if(acc==0 && i == atZero) {
                atZero--;
                continue;
            }
            System.out.print(acc + " ");
        }
        if(atZero ==-1) {
            System.out.print("0");
        }
    }

}
