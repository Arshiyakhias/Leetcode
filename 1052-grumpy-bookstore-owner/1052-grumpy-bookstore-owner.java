class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int sum=0;
        for(int i=0;i<minutes;i++){
            if(grumpy[i]==1){
                sum=sum+customers[i];

            }
            
        }
        HashMap<Integer,Integer>map=new HashMap<>();
        map.put(0,sum);
        int val=sum;

        for(int i=1;i<=customers.length-minutes;i++){
            if(grumpy[i-1]==1){
                val=val-customers[i-1];

            }
            if(grumpy[i+minutes-1]==1){
                val=val+customers[i+minutes-1];

            }
            
          
            map.put(i,val);
            sum=Math.max(sum,val);



        }
        int j=0;
        List<Integer>nums=new ArrayList<>(map.keySet());
        for(int i=0;i<nums.size();i++){
            if(map.get(nums.get(i))==sum){
                j=i;
                break;
            }
        }
        System.out.println(j);
        System.out.println(sum);
        int ans=0;

        for(int i=0;i<customers.length;i++){
            if(i>=j && i<=(j+minutes-1)){
                ans=ans+customers[i];
            }
            else{
                
                if(grumpy[i]==0){
                    ans=ans+customers[i];
                }
            }
        }
        return ans;
    }
}