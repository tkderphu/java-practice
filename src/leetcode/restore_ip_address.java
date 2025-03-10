package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class restore_ip_address {
    public List<String> restoreIpAddresses(String s) {
        if(s.length() < 4) {
            return new ArrayList<>();
        }

        List<String> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        solve(0, s, list, res);
        return res;
    }
    public void solve(int index, String s, List<String> list, List<String> res) {
        if(list.size() == 4 && index != s.length()) return;
        if(index == s.length()) {
            res.add(list.stream()
                    .map(str -> str.substring(0, str.lastIndexOf(".")))
                    .collect(Collectors.joining(".")));
        }
        String current = "";
        for(int i = index; i < 3 + index && i < s.length(); i++) {
            current += s.charAt(i);
            Integer value = Integer.parseInt(current);
            if(current.charAt(0) == '0') {
                if(current.length() == 1) {
                    list.add(current + "_" + i);
                    solve(i + 1, s, list, res);

                }
            } else if(value <= 255){
                list.add(current + "_" + i);
                solve(i + 1, s, list, res);
            }

            list.remove(current + "_" + i);

        }
    }

    public static void main(String[] args) {
        new restore_ip_address().restoreIpAddresses("101023");
    }
}
