package heap;

import java.util.*;

public class Main {
    static HashMap<Integer, ArrayList<Integer>> a;

    static int findMin(int[] dist, boolean[] isVisited, int n, boolean[] exists) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 1; i <= n; i++) {
            if (!isVisited[i] && exists[i] && min > dist[i]) {
                min = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    static int dijkstra(int u, int n, boolean[] exists, int c) {
        int t = u;
        int[] dist = new int[n + 1];
        boolean[] isVisited = new boolean[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(isVisited, false);
        dist[u] = 0;
        for (int i = 1; i <= c; i++) {
            if (exists[i]) {
                int m = findMin(dist, isVisited, n, exists);
                isVisited[m] = true;
                for (int v : a.get(m)) {
                    if (dist[m] + 1 < dist[v]) {
                        dist[v] = dist[m] + 1;
                    }
                }
            }
        }

//        System.out.println("Duong di: " + t + ":");
//        for (int i = 1; i <= n; i++) {
//            if (exists[i]) {
//                System.out.println("( " + t + ", " + i + ") = " + dist[i]);
//            }
//        }

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (exists[i]) {
                sum += dist[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            boolean[] exists = new boolean[120];
            a = new HashMap<>();
            for (int i = 1; i <= n; i++) {
                a.put(i, new ArrayList<>());
            }
            Arrays.fill(exists, false);
            for (int i = 1; i <= m; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                a.get(x).add(y);
                exists[x] = true;
                exists[y] = true;
            }
            int sum = 0;
            int c = 0;
            for (int i = 1; i <= n; i++) {
                if (exists[i]) {
                    c++;
                }
            }
            for (int i = 1; i <= n; i++) {
                if (exists[i]) {
                    sum += dijkstra(i, n, exists, c);
                }
            }
//            dijkstra(2, n, exists, c);
            System.out.println(sum);
            double s = sum * 1.0/(c * (c - 1));
            System.out.println(String.format("%.2f", s));
        }
    }
}
