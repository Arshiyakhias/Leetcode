class Solution {
    public int countDigitOccurrences(int[] nums, int digit) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            String check=new String();
            check=check+nums[i];
            String num=new String();
            num=num+digit;
            for(int j=0;j<check.length();j++){
                if(check.charAt(j)==num.charAt(0)){
                    count++;
                }
            }
        }
        return count;
    }
}