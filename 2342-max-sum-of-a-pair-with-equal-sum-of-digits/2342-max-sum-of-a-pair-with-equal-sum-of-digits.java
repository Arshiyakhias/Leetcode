class Solution {
    public int maximumSum(int[] nums) {
        HashMap<Long,List<Long>>map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            long n=(long)nums[i];
            long sum=0;
            while(n>0){
                sum=sum+n%10;
                n=n/10;

            }
            if(map.containsKey(sum)){
                List<Long>lis=map.get(sum);
                
                lis.add((long)nums[i]);
                //Collections.sort(lis,Collections.reverseOrder());
                map.put(sum,lis);
            }
            else{
                List<Long>addon=new ArrayList<>();
                addon.add((long)nums[i]);
                map.put(sum,addon);

            }

        }
        List<List<Long>>find=new ArrayList<>(map.values());
        long max=0;
        Boolean flag=false;
        for(List<Long>sing:find){
            if(sing.size()>=2){
                Collections.sort(sing);
                long sums=sing.get(sing.size()-1)+sing.get(sing.size()-2);
                max=Math.max(max,sums);
                flag=true;
            }
        }
        if(flag==false){
            return -1;
        }
       
        return (int)max;
    }
}