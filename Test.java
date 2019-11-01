1.
请判断一个链表是否为回文链表。
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null){
            return true;
        }
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        slow = reverse(slow);
        while(slow != null) {
            if (head.val != slow.val) {
                return false;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }
    public ListNode reverse(ListNode head){
        ListNode pre=null;
        ListNode cur=head;
        ListNode newHead=null;
        while(cur!=null){
            ListNode curNext=cur.next;
            if(curNext==null){
                newHead=cur;
            }
            cur.next=pre;
            pre=cur;
            cur=curNext;
        }
        return newHead;
    }
}


2.
给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
方法一：
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
       if(head==null||(n==getLen(head)&&n==1)){
            return null;
        }
        ListNode fast=head;
        ListNode slow=head;
        ListNode pre=head;
        while(fast!=null&&n-1!=0){
            if(fast.next!=null){
                fast=fast.next;
                n--;
            }else{
                return null;
            }
           
        }
        while(fast!=null&&fast.next!=null){
            fast=fast.next;
            pre=slow;
            slow=slow.next;
        }
        if(slow.next!=null){
             slow.val=slow.next.val;
            slow.next=slow.next.next;
        }else{
            pre.next=null;
        }
        return head;
       
    }
    public int getLen(ListNode head){
        ListNode cur=head;
        int len=0;
        while(cur!=null){
            len++;
            cur=cur.next;
        }
        return len;
    }
}

方法二：
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
       ListNode newHead=new ListNode(-100);
        newHead.next=head;
        ListNode fast=newHead;
        ListNode slow=newHead;
        while(n!=0){
            fast=fast.next;
            n--;
        }
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return newHead.next;
    }
}


