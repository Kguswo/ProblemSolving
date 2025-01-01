class Solution {
    public String simplifyPath(String path) {
        String[] dirArr = path.split("/");
        Deque<String> dq = new ArrayDeque<>();

        for(int i=0; i<dirArr.length; i++){
            if(!dirArr[i].equals(".") && !dirArr[i].isEmpty()){
                if(dirArr[i].equals("..")){
                    if(!dq.isEmpty()) dq.pollLast();
                }
                else{
                    dq.addLast(dirArr[i]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();

        // case4 위한 조건문
        if(dq.isEmpty()) return "/";

        while(!dq.isEmpty()){
            sb.append("/").append(dq.poll());
        }
        return sb.toString();
    }
}