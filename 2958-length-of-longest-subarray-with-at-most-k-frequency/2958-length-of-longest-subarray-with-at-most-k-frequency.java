class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int left=0;
        int right=0;
        int max=Integer.MIN_VALUE;
        while(right<nums.length){
            if(map.containsKey(nums[right])){
                int val=map.get(nums[right]);
                val++;
                map.put(nums[right],val);
            }
            else{
                map.put(nums[right],1);
            }
            while(map.get(nums[right])>k){
                if(map.containsKey(nums[left])){
                    int vals=map.get(nums[left]);
                    vals--;
                    if(vals==0){
                        map.remove(nums[left]);
                    }
                    else{
                        map.put(nums[left],vals);
                    }
                }
                left++;
            }
            max=Math.max(max,(right-left+1));
            right++;
            
        }
        return max;
    }
}