import java.util.LinkedHashMap;

/**
 * description:
 * author: 朱勇
 * time: 2021/2/11  9:43
 */
public class LRU {
    int cap;
    LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
    public LRU(int capacity) {
        this.cap = capacity;
    }
    public void makeRecent(int key){
        int val = linkedHashMap.get(key);
        linkedHashMap.remove(key);
        linkedHashMap.put(key, val);
    }
    public int get(int key) {
        if(!linkedHashMap.containsKey(key)){
            return -1;
        }
        makeRecent(key);
        return linkedHashMap.get(key);
    }
    public void put(int key, int value) {
        if(linkedHashMap.containsKey(key)){
            makeRecent(key);
            linkedHashMap.put(key, value);
        }else {
            linkedHashMap.put(key, value);
            if(linkedHashMap.size() > cap){
                linkedHashMap.remove(linkedHashMap.keySet().iterator().next());
            }
        }
    }
}
