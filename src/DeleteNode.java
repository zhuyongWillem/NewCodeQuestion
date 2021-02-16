/**
 * description:
 * author: 朱勇
 * time: 2021/2/9  21:44
 */
public class DeleteNode {
    public ListNode deleteNode(ListNode head, int val) {
        if(head.val == val){
            return head.next;
        }
        ListNode pre = head, cur = head.next;
        while (cur.val != val && cur != null){
            pre = cur;
            cur = cur.next;
        }
        pre.next = cur.next;
        return head;
    }
}
