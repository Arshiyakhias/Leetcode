class Solution {
    public int reverse(int x) {
        long ans=0;
        long vals=Math.abs(x);
        while(vals>0){
            long val=vals%10;
            
            vals=vals/10;
            ans=ans*10;
            ans=ans+val;
            



        }
        if(x<0){
            ans=ans*-1;
        }
       
        System.out.println(ans);
        if(ans<Integer.MIN_VALUE || ans>Integer.MAX_VALUE){
            return 0;
        }
        return (int)ans;
    }
}