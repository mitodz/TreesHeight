import java.util.Scanner;

public class Main implements Runnable{

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) { //заполняем первоначальный массив родителей
            a[i] = scanner.nextInt();
        }
        System.out.println(getHeight(a) + 1);
    }

    private static int getHeight(int[] a) {
        int n = a.length;
        int[] p = new int[n];
        int height = 0;
        for (int i = 0; i < n; i++) { // далее создаем массив (дети-индексы) со счетчиками родителей в ячейках
            int t = i;
            while(a[t]!=-1) {
                p[i]++;
                if (p[i]>height) {
                    height=p[i]; //запоминаем максимально длинный список родителей
                }
                t=a[t];
            }
        }
        return height;
    }

    public static void main(String[] args) {
        new Main().run();
    }
}