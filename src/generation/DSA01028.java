package generation;

import java.util.*;

public class DSA01028 {

    public static void main(String[] g) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        int p[] = new int[n];
        for(int i = 0; i < k; i++) p[i] = i + 1;
        boolean isExist[] = new boolean[1001];
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int x = input.nextInt();
            if(!isExist[x]) list.add(x);
            isExist[x] = true;
        }
        Collections.sort(list);
        boolean isConfigEnd = false;
        while(!isConfigEnd) {
            for(int i = 0; i < k; i++) {
                System.out.print(list.get(p[i] - 1) + " ");
            }
            System.out.println();
            isConfigEnd = nextCombination(p, list.size(), k);
        }

    }
    private static boolean nextCombination(int[] arr, int n, int k) {
        int i = k - 1;
        while(i >= 0 && arr[i] >= n - k + i + 1) i--;
        if(i >= 0) {
            arr[i] += 1;
            for(int j = i + 1; j < k; j++) arr[j] = arr[i] + j - i;
            return false;
        } return true;
    }
}
