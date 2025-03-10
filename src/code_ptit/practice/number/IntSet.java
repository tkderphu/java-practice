package code_ptit.practice.number;

import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IntSet {
    private List<BigInteger> list;
    public IntSet(String fileName) {
        try {
            list = new ArrayList<>();
            Scanner scanner = new Scanner(new File(fileName));
            int n = scanner.nextInt();
            for(int i = 0; i < n; i++) {
                list.add(scanner.nextBigInteger());
            }
        } catch (Exception e) {

        }
    }

    public BigInteger max() {
        BigInteger res = list.get(0);
        for(int i = 1; i < list.size(); i++) {
            if(res.compareTo(list.get(i)) < 0) {
                res = list.get(i);
            }
        }
        return res;
    }

    public BigInteger min() {
        BigInteger res = list.get(0);
        for(int i = 1; i < list.size(); i++) {
            if(res.compareTo(list.get(i)) > 0) {
                res = list.get(i);
            }
        }
        return res;
    }

    public BigInteger sum() {
        BigInteger res = list.get(0);
        for(int i = 1; i < list.size(); i++) {
            res = res.add(list.get(i));
        }
        return res;
    }
}
