/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curr1=l1;
        ListNode curr2=l2;
        int carry=0;
        ListNode dummy=new ListNode(0);
        ListNode tail=dummy;
        while(curr1!=null || curr2!=null){

            if(curr1!=null && curr2!=null){
                int sum=curr1.val+curr2.val;
                if(carry!=0){
                    sum=sum+carry;
                    carry=0;
                }
                else{
                    carry=0;//simply
                }
                if(sum>=10){
                    int unit=sum%10;
                    carry=sum/10;
                    ListNode addon=new ListNode(unit);
                    tail.next=addon;
                    tail=tail.next;

                }
                else{
                    ListNode addon=new ListNode(sum);
                    tail.next=addon;
                    tail=tail.next;
                }
            }
            else if(curr1==null && curr2!=null){
                int sum1=curr2.val;
                if(carry!=0){
                    sum1=sum1+carry;
                    carry=0;
                }
                else{
                    carry=0;//simply
                }
                if(sum1>=10){
                    int unit=sum1%10;
                    carry=sum1/10;
                    ListNode adds=new ListNode(unit);
                    tail.next=adds;
                    tail=tail.next;

                }
                else{
                    ListNode addon1=new ListNode(sum1);
                    tail.next=addon1;
                    tail=tail.next;
                }
            }
            else{
                int sum3=curr1.val;
                if(carry!=0){
                    sum3=sum3+carry;
                    carry=0;
                }
                else{
                    carry=0;//simply
                }
                if(sum3>=10){
                    int unit=sum3%10;
                    carry=sum3/10;
                    ListNode addon2=new ListNode(unit);
                    tail.next=addon2;
                    tail=tail.next;

                }
                else{
                    ListNode addon3=new ListNode(sum3);
                    tail.next=addon3;
                    tail=tail.next;
                }

            }
            if(curr1!=null){
                curr1=curr1.next;

            }
            if(curr2!=null){
                curr2=curr2.next;

            }
            
            


        }
        if(carry!=0){
            ListNode fin=new ListNode(carry);
            tail.next=fin;

        }
        return dummy.next;
    }
}