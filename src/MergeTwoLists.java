/**
 * description:
 * author: 朱勇
 * time: 2021/2/4  21:19
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists (ListNode l1, ListNode l2){
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        if(l1.val <= l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        if(l2.val < l1.val){
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }
        return null;
    }
}
