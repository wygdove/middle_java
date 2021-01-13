package nowcoder;

/**
 * @Title: NC78_ReverseList
 * @Question: 输入一个链表，反转链表后，输出新链表的表头。
 * @Input: {1,2,3}
 * @Output: {3,2,1}
 * @Description:
 */
public class NC78ReverseList {
    public static void main(String[] args) {
        ListNode a=new ListNode(1);
        ListNode b=new ListNode(2);
        ListNode c=new ListNode(3);
        a.next=b;
        b.next=c;

        ListNode temp=a;
        do{System.out.println(temp.val);temp=temp.next;}while(temp!=null);

        temp=new Solution().reverseList(a);
        System.out.println("------");
        do{System.out.println(temp.val);temp=temp.next;}while(temp!=null);
    }
}

class ListNode {
    int val;
    ListNode next=null;
    ListNode(int val) {
        this.val=val;
    }
    @Override
    public String toString() {
        return val+"->"+(next==null?"null":next.val);
    }
}
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode iterHead=head;
        ListNode newHead=head;
        ListNode temp;
        while(iterHead!=null&&iterHead.next!=null) {
            temp=new ListNode(iterHead.val);
            if(newHead!=head) {
                temp.next=newHead.next;
            }
            newHead=new ListNode(iterHead.next.val);
            newHead.next=temp;
            iterHead=iterHead.next;
        }
        return newHead;
    }
}

