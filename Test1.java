1.
给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点
之前。你应当保留两个分区中每个节点的初始相对位置。
示例:

输入: head = 1->4->3->2->5->2, x = 3
输出: 1->2->2->4->3->5
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head==null){
            return null;
        }
        ListNode newBefore=new ListNode(-100);
        ListNode before=newBefore;
        ListNode newAfter=new ListNode(-100);
        ListNode after=newAfter;
        while(head!=null){
            if(head.val<x){
                before.next=head;
                before=before.next;
            }else{
                after.next=head;
                after=after.next;
            }
            head=head.next;
        }
        after.next=null;
        before.next=newAfter.next;
        return newBefore.next;
    }
}

2.
