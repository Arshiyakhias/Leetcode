class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Integer,List<List<Integer>>>map=new HashMap<>();

        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                int sum=nums1[i]+nums2[j];
                if(pq.size()<k){
                    

                    if(!map.containsKey(sum)){
                        List<List<Integer>>ads=new ArrayList<>();
                    
                        List<Integer>addon=new ArrayList<>();
                        addon.add(nums1[i]);
                        addon.add(nums2[j]);
                        ads.add(addon);
                        map.put(sum,ads);
                        
                    }
                    else{
                        List<List<Integer>>gets=map.get(sum);
                        List<Integer>addon=new ArrayList<>();
                        addon.add(nums1[i]);
                        addon.add(nums2[j]);
                        gets.add(addon);
                        map.put(sum,gets);

                    }
                    pq.add(sum);
                }
                else{
                    int val=pq.peek();
                    if(sum<val){
                        pq.poll();
                      
                        
                        if(!map.containsKey(sum)){
                            List<List<Integer>>ads=new ArrayList<>();
                            List<Integer>addon=new ArrayList<>();
                         
                            addon.add(nums1[i]);
                            addon.add(nums2[j]);
                            ads.add(addon);
                        map.put(sum,ads);
                        
                        }
                        else{
                        List<List<Integer>>gets=map.get(sum);
                        List<Integer>addon=new ArrayList<>();
                        addon.add(nums1[i]);
                        addon.add(nums2[j]);
                        gets.add(addon);
                        map.put(sum,gets);

                    }
                        pq.add(sum);


                    }
                    else{
                        break;
                    }
                }
                
            }
        }
        System.out.println(map);
        List<List<Integer>>ans=new ArrayList<>();
        int count=0;
        List<Integer>fin=new ArrayList<>();
        while(!pq.isEmpty()){
            int val=pq.poll();
            if(!fin.contains(val)){
                fin.add(val);

            }
            
            
        }
        Collections.sort(fin);
        System.out.println(fin);
        for(int j=0;j<fin.size();j++){
            List<List<Integer>>ad=map.get(fin.get(j));
            for(int i=0;i<ad.size();i++){
                ans.add(ad.get(i));
            }

        }
        List<List<Integer>>fins=new ArrayList<>();
        for(int i=0;i<k;i++){
            fins.add(ans.get(i));
        }
        return fins;
    }
}