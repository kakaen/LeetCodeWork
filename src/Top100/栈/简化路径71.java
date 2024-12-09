package Top100.栈;

import java.util.Deque;
import java.util.LinkedList;

public class 简化路径71 {
    public String simplifypath(String path){
        //Unix风格一个点'.'表示当前目录本身
        //此外两个点'..'表示给目标
        //以/为开头，点表示当前目录本身
        //任意多个连续的斜杠可以被视为单个斜杠/
        //任何其他格式的点都被视作有效的文件/目录名称
        int n = path.length();
        StringBuilder builder=new StringBuilder();
        Deque<String> queue=new LinkedList<>();
        builder.append("/");
        builder.reverse();
        for (int i=0;i<n;i++){
            if (path.charAt(i)=='/'){
                builder.append(path.charAt(i));
            }else{
                
            }
        }
        return null;
    }
}
