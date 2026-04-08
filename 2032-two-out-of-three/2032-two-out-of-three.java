class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        HashMap<Integer,HashSet<Integer>>map=new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            if(map.containsKey(nums1[i])){
                HashSet<Integer>set1=map.get(nums1[i]);
                set1.add(1);
                map.put(nums1[i],set1);
            }
            else{
                HashSet<Integer>set=new HashSet<>();
                set.add(1);
                map.put(nums1[i],set);
            }
        }

         for(int i=0;i<nums2.length;i++){
            if(map.containsKey(nums2[i])){
                HashSet<Integer>set1=map.get(nums2[i]);
                set1.add(2);
                map.put(nums2[i],set1);
            }
            else{
                HashSet<Integer>set=new HashSet<>();
                set.add(2);
                map.put(nums2[i],set);
            }
        }

         for(int i=0;i<nums3.length;i++){
            if(map.containsKey(nums3[i])){
                HashSet<Integer>set1=map.get(nums3[i]);
                set1.add(3);
                map.put(nums3[i],set1);
            }
            else{
                HashSet<Integer>set=new HashSet<>();
                set.add(3);
                map.put(nums3[i],set);
            }
        }

        List<Integer>keyss=new ArrayList<>(map.keySet());
        System.out.println(map);
        List<Integer>lis=new ArrayList<>();
        for(int i=0;i<keyss.size();i++){
            HashSet<Integer>sets=map.get(keyss.get(i));
            if(sets.size()>=2){
                lis.add(keyss.get(i));
            }
        }
        return lis;
    }
}