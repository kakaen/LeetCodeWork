package Top100.哈希表;

import org.omg.CORBA.INTERNAL;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.Map;

public class 同构字符串205 {
    public static void main(String[] args) {
        同构字符串205 test = new 同构字符串205();
        System.out.println(test.isIsomorphic("abb", "bcc"));
    }
    public boolean isIsomorphic(String s,String t){
      //创建两个映射hash表
        //s的字符作为键，t2s的字符作为键
        Map<Character,Character> s2t=new HashMap<>();
        Map<Character,Character> t2s=new HashMap<>();
        for (int i=0;i<s.length();i++){
            char sch=s.charAt(i);
            char tch=t.charAt(i);
            if (s2t.containsKey(sch)&&s2t.get(sch)!=tch) return false;
            if (t2s.containsKey(tch)&&t2s.get(tch)!=sch) return false;
            s2t.put(sch,tch);
            t2s.put(tch,sch);
        }
        return true;
    }
}
