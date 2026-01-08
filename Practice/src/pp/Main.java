// package pp;
// import java.util.Scanner;
// public class Main {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int a = sc.nextInt();
//         int b = sc.nextInt();
//         int c = sc.nextInt();
//         int d = sc.nextInt();
//         int e = sc.nextInt();
//         int f = sc.nextInt();
//         for (int x = 0; x <= 999; x++) {
//             for (int y = 0; y <= 999; y++) {
//                 if (x * a + b * y == c && x * d + e * y == f) {
//                     System.out.println(x + " " + y);
//                 } else if ((-1) * x * a + b * y == c && (-1) * x * d + e * y == f) {
//                     System.out.println((-1) * x + " " + y);
//                 } else if (x * a + b * (-1) * y == c && x * d + e * (-1) * y == f) {
//                     System.out.println(x + " " + (-1) * y);
//                 } else if ((-1) * x * a + b * (-1) * y == c && (-1) * x * d + e * (-1) * y == f) {
//                     System.out.println((-1) * x + " " + (-1) * y);
//                 }
//             }
//         }
//         sc.close();
//     }
// }
package pp;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int i = 0;
        char board[][] = new char[N][M];
        for (int h = 0; h < N; h++) {
            String str = sc.nextLine();
            for (char e : str.toCharArray()) {
                board[h][i] = e;
                i++;
            }
            i = 0;
        }
        for (int h = 1; h < N; h++) {
            for (int w = 1; w < M; w++) {
                char tmp = board[h - 1][w - 1];
                if ()
            }
        }
        sc.close();
    }
}
