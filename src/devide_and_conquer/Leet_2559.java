package devide_and_conquer;

public class Leet_2559 {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] ans = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            int count = 0;
            for(int j = 0; j < words.length; j++) {
                if(words[j].length() < end) {
                   
                }
            }
            ans[i] = count;

        }
        return ans;
    }

    public boolean isVowel(char c) {
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }
        return false;
    }
}
