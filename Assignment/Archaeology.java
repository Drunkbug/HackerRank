import java.util.*;


public class Solution {
    static int acc = -1;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        Set<String> encodings = new HashSet<>();
        for (int i = 0; i < size; i++) {
            String encode = input.next();
            encodings.add(encode);
            if (encode.length() > acc) {
                acc = encode.length();
            }
        }
        String s = input.next();


        long[] opt = new long[s.length() + 1];
        opt[0] = 1;// initial state
        count(s, encodings, opt);

        long answer = (long) (opt[opt.length - 1] % (Math.pow(10,8)+7));
        System.out.println(answer);



    }

    static void count(String s, Set<String> encodings, long[] opt) {
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= Math.min(i+acc, s.length()); j++) {
                String sub = s.substring(i, j);
                if (encodings.contains(sub)) {
                    opt[j] = (long) ((opt[j]+ opt[i])% (Math.pow(10,8)+7));
                }
            }

        }
    }
}
