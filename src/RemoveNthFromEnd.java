import java.util.HashMap;
import java.util.LinkedList;

/**
 * description:
 * author: 朱勇
 * time: 2021/2/9  21:29
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd (ListNode head, int n) {
        // write code here
        int len = 0;
        ListNode temp = head;
        while (temp != null){
            temp = temp.next;
            len++;
        }
        ListNode pre = head, cur = head.next;
        for(int i = 0; i < len - n; i++){
            pre = cur;
            cur = cur.next;
        }
        pre.next = cur.next;
        return head;
    }
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        LinkedList<ListNode> linkedList = new LinkedList<>();
        ListNode a = pHead1;
        while (a != null){
            linkedList.add(a);
            a = a.next;
        }
        ListNode cur = pHead2;
        while (cur != null){
            if(linkedList.contains(cur)){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }
}
