import java.util.Scanner;

public class Main implements Runnable{

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        int[] p = new int[n];
        int height = 0;
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            int t = i;
            while(a[t]!=-1) {
                p[i]++;
                if (p[i]>height) {
                    height=p[i];
                }
                t=a[t];
            }
        }

        System.out.println(height + 1);
    }

    public static void main(String[] args) {
//        long startTime = System.currentTimeMillis();
        new Main().run();
//        long finishTime = System.currentTimeMillis();
//        System.out.println(finishTime - startTime + " ms");
    }
}