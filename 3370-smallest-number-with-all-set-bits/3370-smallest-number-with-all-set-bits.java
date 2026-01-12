class Solution {
    public int smallestNumber(int n) {
        StringBuilder bin=new StringBuilder();
        int count=1;
        while(n!=1){
            
            int val=n%2;

            bin.append(val);
            System.out.println(val);
            n=n/2;
            count++;



        }
        bin.append(n);
        bin.reverse();
        

        String binary_ans=new String();
        int sum=0;
        for(int i=0;i<count;i++){
            sum=sum+(int)Math.pow(2,i);
        }
     
      
        return sum;
    }
}