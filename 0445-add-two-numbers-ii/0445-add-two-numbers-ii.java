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
        ListNode prev_rev=null;
        ListNode curr_rev=l1;
        while(curr_rev!=null){
            ListNode nextnode_rev=curr_rev.next;
            curr_rev.next=prev_rev;

            //update
            prev_rev=curr_rev;
            curr_rev=nextnode_rev;
        }
        l1=prev_rev;

        ListNode prev_rev2=null;
        ListNode curr_rev2=l2;
        while(curr_rev2!=null){
            ListNode nextnode_rev2=curr_rev2.next;
            curr_rev2.next=prev_rev2;

            //update
            prev_rev2=curr_rev2;
            curr_rev2=nextnode_rev2;
        }
        l2=prev_rev2;
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


        ListNode prev_ans=null;
        ListNode curr_ans=dummy;
        while(curr_ans!=null){
            ListNode nextnode_ans=curr_ans.next;
            curr_ans.next=prev_ans;

            //update
            prev_ans=curr_ans;
            curr_ans=nextnode_ans;
        }
        dummy=prev_ans;
        ListNode blah=dummy;
        ListNode fin_ans=new ListNode(0);
        ListNode tails=fin_ans;
        while(blah.next!=null){
            ListNode addson=new ListNode(blah.val);
            tails.next=addson;
            tails=tails.next;
            blah=blah.next;
        }
        
        return fin_ans.next;
    }
}