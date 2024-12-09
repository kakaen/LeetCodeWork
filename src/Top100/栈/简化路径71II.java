package Top100.栈;

import java.util.Deque;
import java.util.LinkedList;

public class 简化路径71II {
    public static void main(String[] args) {
        简化路径71II test = new 简化路径71II();
        System.out.println(test.simplifyPath("/home/user/documents/../Pictures/"));
        System.out.println(test.simplifyPath("/home//foo/"));
        System.out.println(test.simplifyPath("/.../a/../b/c/../d/./"));
        System.out.println(test.simplifyPath("/../"));
    }
    public String simplifyPath(String path){
        Deque<String> deque=new LinkedList<>(); //创建一个双端队列
        String[] split = path.split("/");
        for (String str:split){
            System.out.println(str);
            if (!str.equals("..")&&!str.equals(".")&&str!=""){
                deque.push(str);
            } else if (str.equals("..")) {
                if (!deque.isEmpty()){
                    deque.pop();
                }
            }
        }

        if (deque.isEmpty()) return "/";
        StringBuilder builder=new StringBuilder();
        while (!deque.isEmpty()){
            builder.append("/");
            builder.append(deque.pollLast());
        }
        return builder.toString();
    }
    public String simplifyPath2(String path){
        //首先将path进行切割，str可能为空，.,..
        String[] split = path.split("/");
        Deque<String> stack=new LinkedList<>();
        for (String str:split){
            if ("..".equals(str)){
                if(!stack.isEmpty()){
                    stack.pollLast();
                }
            } else if (str.length()>0&&!".".equals(str)) {
                stack.addLast(str);
            }
        }
        StringBuilder builder=new StringBuilder();
        if (stack.isEmpty()) return builder.append("/").toString();
        while (!stack.isEmpty()){
            builder.append("/");
            builder.append(stack.pollFirst());
        }
        return builder.toString();
    }
}
