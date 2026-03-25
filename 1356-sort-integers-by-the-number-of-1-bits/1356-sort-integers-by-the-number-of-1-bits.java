class Solution {
    public int[] sortByBits(int[] arr) {
        PriorityQueue<Integer>pq=new PriorityQueue<>(
            (a,b)-> {
                int counta=Integer.bitCount(a);
                int countb=Integer.bitCount(b);
                if(counta<countb){
                    return -1;
                }
                else if(counta==countb){
                    if(a<b){
                        return -1;
                    }
                    else{
                        return 1;
                    }
                }
                else{
                    return 1;
                }
            }
        );
        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
        }

        int[]ans;
        ans=new int[arr.length];
        int count=0;

        while(!pq.isEmpty()){
            ans[count]=pq.poll();
            count++;

        }
    
        return ans;
    }
}