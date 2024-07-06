class Solution {
    public static final String delimiter = "/";
    public String simplifyPath(String path) {
        Deque<String> dq = new LinkedList();
        for (String token : path.split(delimiter)) {
            if (token.equals("..")) { 
                if (dq.isEmpty() == false) {
                    dq.removeLast();
                }
            } else if(isDir(token)) {
                dq.addLast(token);
            }
        }

        if (dq.isEmpty()) 
        {
            return "/";
        }

        StringBuilder sb = new StringBuilder();
        while (dq.isEmpty() == false) {
            sb.append("/").append(dq.removeFirst());
        }

        return sb.toString();
    }

    private boolean isDir(String token) {
        return (token != null) && (token.isEmpty() == false) && (token.equals(".") == false);
    }
}