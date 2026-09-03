class Solution {
    public long maxSum(List<Integer> nums, int m, int k) {
        HashMap<Integer,Integer>map=new HashMap<>();
        long sum=0;
        for(int i=0;i<k;i++){
            sum=sum+nums.get(i);
            if(map.containsKey(nums.get(i))){
                int val=map.get(nums.get(i));
                val++;
                map.put(nums.get(i),val);
            }
            else{
                map.put(nums.get(i),1);
            }


        }
        long max=0;
        if(map.size()>=m){
            max=sum;

        }
        System.out.println(max);

      
        for(int i=1;i<(nums.size()-k+1);i++){
            if(map.containsKey(nums.get(i-1))){
                int vals=map.get(nums.get(i-1));
                vals--;
                if(vals==0){
                    map.remove(nums.get(i-1));
                }
                else{
                    map.put(nums.get(i-1),vals);
                }

            }
            
            if(map.containsKey(nums.get(i+k-1))){
                int values=map.get(nums.get(i+k-1));
                values++;
                map.put(nums.get(i+k-1),values);
            }
            else{
                map.put(nums.get(i+k-1),1);
            }
            sum=sum-nums.get(i-1);
            sum=sum+nums.get(i+k-1);
            if(map.size()>=m){
                max=Math.max(max,sum);
             

            }
        }
        return max;
    }
}