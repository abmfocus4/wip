// https://www.youtube.com/watch?v=ZV-Hi1e1KL8&ab_channel=codestorywithMIK
class Solution {
    public String simplifyPath(String path) {
        Deque<String> dq = new LinkedList(); // double ended queue
        for (String token : path.split("/")) {
            if (token.equals("..")) {
                dq.poll(); // stack pop but without checking for empty
            } else if (isDir(token)) {
                dq.push(token);
            }
        }
        
        if (dq.isEmpty()) {
            return "/";
        }

        StringBuilder sb = new StringBuilder();
        while (dq.isEmpty() == false) {
            sb.append("/").append(dq.pollLast());
        }

        return sb.toString();
    }

    // use string.equals to compare strings always
    private boolean isDir(String token) {
        return token != null && !token.equals("") && !token.equals(".");
    }
}