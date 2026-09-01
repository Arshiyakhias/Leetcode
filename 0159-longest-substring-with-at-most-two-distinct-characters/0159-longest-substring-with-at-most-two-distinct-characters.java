class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
       
        HashMap<Character,Integer>map=new HashMap<>();
        int left=0;
        int right=0;
        int max=Integer.MIN_VALUE;
        while(right<s.length()){
           
                if(map.containsKey(s.charAt(right))){
                    int val=map.get(s.charAt(right));
                    val++;
                    map.put(s.charAt(right),val);
                }
                else{
                    map.put(s.charAt(right),1);
                }
            
            while(map.size()>2){
                int vals=map.get(s.charAt(left));
                vals--;
                if(vals==0){
                    map.remove(s.charAt(left));
                }
                else{
                    map.put(s.charAt(left),vals);
                }
                left++;
            }
            //System.out.println(s.substring(left,right));
            max=Math.max(max,(right-left+1));

            right++;
        }
        return max;
    }
}