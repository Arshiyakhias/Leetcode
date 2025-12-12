class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        HashSet<Integer>set=new HashSet<>();
        int[]arr;
        arr=new int[A.length];
         int prev=0;
        for(int i=0;i<A.length;i++){

            int sum=0;
           
            if(A[i]!=B[i]){
                if(set.contains(A[i])){
                    sum++;
                }
                else{
                    set.add(A[i]);
                }
                if(set.contains(B[i])){
                    sum++;
                }
                else{
                    set.add(B[i]);
                    
                }
                sum=sum+prev;
                prev=sum;
                
            }
            else{
                sum++;
                sum=sum+prev;
                prev=sum;
            }
            arr[i]=sum;

        }
        return arr;
    }
}