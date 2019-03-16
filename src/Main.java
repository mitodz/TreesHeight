import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main implements Runnable{

    @Override
    public void run() {
        Scanner scanner = new Scanner("10\n" +
                "9 7 5 5 2 9 9 9 2 -1");
        int n = scanner.nextInt();
        int[] a = new int[n];
        int r=0;
        StringBuilder[] sb = new StringBuilder[n];
        for (int i = 0; i < n; i++) {
            sb[i]=new StringBuilder();
        }
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            if(a[i]==-1) {
                r=i;
                continue;
            }
            sb[a[i]].append(i);
        }
        System.out.println(heightOfTree(sb, r));
    }


    public static Map<Integer, Integer> map = new HashMap<>();




    public static int heightOfTree(StringBuilder[] sb, int r) {
        int height = 1;
        if (map.containsKey(r)) return map.get(r);
        if (sb[r].length()>0) {
            for (int i = 0; i < sb[r].length(); i++) {
                height = Math.max(height, heightOfTree(sb, Integer.parseInt(Character.toString(sb[r].charAt(i)))) + 1);
            }
        }
        map.put(r, height);
        return height;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        new Main().run();
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime + " ms");
    }


}