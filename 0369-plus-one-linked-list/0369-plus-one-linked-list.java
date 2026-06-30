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
    public ListNode plusOne(ListNode head) {
        ListNode curr=head;
        ListNode prev=null;
        while(curr!=null){
            ListNode nextnode=curr.next;
            curr.next=prev;

            prev=curr;
            curr=nextnode;
            
        }

        head=prev;
        int carry=0;
        ListNode add=head;
        int count=0;
        while(add!=null){
            count++;
            if(count==1){
                int init=add.val+1;
                add.val=add.val+1;
                System.out.println(add.val);
                if(add.val>=10){
                    
                    int current=add.val%10;
                    add.val=current;
                    System.out.println(add.val);
                    System.out.println(init);

                    carry=init/10;
                    System.out.println(carry);
                  
                    
                }
            }

                else{

                    if(carry!=0){
                        add.val=add.val+carry;
                        int init=add.val+carry;
                        carry=0;
                        if(add.val>=10){
                            int current=add.val%10;
                            add.val=current;
                            carry=init/10;

                        }

                    }
                
            }
            add=add.next;

        }
        //System.out.println(add.val);
        ListNode go=head;
        while(go.next!=null){
            go=go.next;
        }
        
        if(carry!=0){
            ListNode fin=new ListNode(carry);
        
            go.next=fin;
            System.out.println("hello");
        }
        


        ListNode curr1=head;
        ListNode prev1=null;
        while(curr1!=null){
            ListNode nextnode1=curr1.next;
            curr1.next=prev1;

            prev1=curr1;
            curr1=nextnode1;
            
        }

        head=prev1;
        
    
        return head;
    }
}