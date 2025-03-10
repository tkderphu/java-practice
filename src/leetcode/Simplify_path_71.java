package leetcode;

import java.util.Stack;

public class Simplify_path_71 {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        for(int i = 0; i < path.length(); i++) {
            String r = "";
            if(path.charAt(i) == '/') continue;

            while(i < path.length() && path.charAt(i) != '/') {
                r += path.charAt(i);
                i ++;
            }

            if(r.equals(".")) continue;
            else if(r.equals("..") ) {
                if(!st.isEmpty()) {
                    st.pop();
                }
            } else {
                st.push(r);
            }

        }

        String res = "";
        while(!st.isEmpty()) {
            res =  "/" + st.pop()  + res;
        }

        if(res.isEmpty()) {
            return "/";
        }

        return res;
    }

    public static void main(String[] args) {
        new Simplify_path_71().simplifyPath("/home/user/Documents/../Pictures");
    }
}
