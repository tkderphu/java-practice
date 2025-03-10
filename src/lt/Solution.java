package lt;

public class Solution {
    public String multiply(String num1, String num2) {
        String max = reverse(num1);
        String min = reverse(num2);

        int[][] matrix = new int[min.length()][max.length() + min.length()];

        /**
         * Fill into matrix
         */
        for(int i = 0; i < min.length(); i++) {
            int remember = 0;
            for(int j = 0; j < max.length(); j++) {
                int mul = (min.charAt(i) - '0') * (max.charAt(j) - '0') + remember;
                if(mul >= 10) {
                    remember = mul / 10;
                    mul = mul - remember * 10;
                } else {
                    remember = 0;
                }
                matrix[i][j + i] = mul;
                if(j == max.length() - 1 && remember != 0) {
                    matrix[i][j + i + 1] = remember;
                    remember = 0;
                }
            }
        }

        /**
         * Calculate total of column
         */

        StringBuilder res = new StringBuilder();
        int remem = 0;
        for(int i = 0; i < max.length() + min.length(); i++) {
            int sumColum = 0;
            for(int j = 0; j < min.length(); j++) {
                sumColum += matrix[j][i];
            }
            sumColum += remem;
            if(i == max.length() + min.length() - 1 && sumColum != 0) {
                res.append(sumColum);
                break;
            }
            if(sumColum >= 10) {
                remem = sumColum/10;
                sumColum = sumColum - remem * 10;
            } else {
                remem = 0;
            }
            res.append(sumColum);
        }
        String string = res.reverse().toString();
        int index = 0;
        int cnt = 0;
        for(int i = 0; i < string.length(); i++) {
            if(string.charAt(i) == 0) {
                cnt ++;
            } else {
                index = i;
                break;
            }
        }
        if(cnt == string.length()) return "0";
        return string.substring(index);

    }

    public String reverse(String x) {
        StringBuilder builder = new StringBuilder();
        for(int i = x.length() - 1; i >= 0; i--) {
            builder.append(x.charAt(i));
        }
        return builder.toString();
    }


    public static void main(String[] args) {
        String multiply = new Solution().multiply("98", "9");
        System.out.println(multiply);
    }
}
