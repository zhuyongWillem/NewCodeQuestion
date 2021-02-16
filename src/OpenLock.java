import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * description:
 * author: 朱勇
 * time: 2021/2/3  17:12
 */
public class OpenLock {
    public String plusOne(String str, int j){
        char[] chars = str.toCharArray();
        if(chars[j] == '9'){
            chars[j] = '0';
        }else {
            chars[j]++;
        }
        return new String(chars);
    }
    public String minusOne(String str, int j){
        char[] chars = str.toCharArray();
        if(chars[j] == '0'){
            chars[j] = '9';
        }else {
            chars[j]--;
        }
        return new String(chars);
    }
    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Set<String> dead = new HashSet<>();
        for(String str : deadends){
            dead.add(str);
        }
        queue.offer("0000");
        visited.add("0000");
        int depth = 0;
        while (! queue.isEmpty()){
            int nums = queue.size();
            for(int i = 0; i < nums; i++){
                String cur = queue.poll();
                if(dead.contains(cur)){
                    continue;
                }
                if(cur.equals(target)){
                    return depth;
                }
                for(int j = 0; j < 4; j++){
                    String up = plusOne(cur, j);
                    String down = minusOne(cur, j);
                    if(! visited.contains(up)){
                        queue.offer(up);
                        visited.add(up);
                    }
                    if(! visited.contains(down)){
                        queue.offer(down);
                        visited.add(down);
                    }
                }
            }
            depth++;
        }
        return -1;
    }
}
