class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int len=nums[0].length();
        int wtv=(int)Math.pow(2,len);

        HashSet<String>set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }

        for(int i=0;i<wtv;i++){
            String vasl=Integer.toBinaryString(i);
            StringBuilder str=new StringBuilder(vasl);
            if(str.length()!=len){
                str.reverse();
                int check=len-str.length();
                for(int k=0;k<check;k++){
                    str.append('0');
                }
                str.reverse();
            }
            if(!set.contains(str.toString())){
                return str.toString();
            }
        }

        return nums[0];
    }
}