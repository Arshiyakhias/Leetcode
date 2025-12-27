class Solution {
    public int numberOfSubstrings(String s) {
        int k=3;

        int r=0;
        int l=0;
        HashMap<Character,Integer>map=new HashMap<>();
        int count=0;

        while(r<s.length()){
            if(map.containsKey(s.charAt(r))){
                int val=map.get(s.charAt(r));
                val++;
                map.put(s.charAt(r),val);
            }
            else{
                map.put(s.charAt(r),1);
            }
            while(map.size()>k){
                int val1=map.get(s.charAt(l));
                val1--;
                if(val1==0){
                    map.remove(s.charAt(l));
                }
                else{
                    map.put(s.charAt(l),val1);
                }
                l++;
            }
            if(map.size()<=k){
                count=count+(r-l+1);

            }
            r++;
        }


        k=k-1;

        int r1=0;
        int l1=0;
        HashMap<Character,Integer>map1=new HashMap<>();
        int count1=0;

        while(r1<s.length()){
            if(map1.containsKey(s.charAt(r1))){
                int val2=map1.get(s.charAt(r1));
                val2++;
                map1.put(s.charAt(r1),val2);
            }
            else{
                map1.put(s.charAt(r1),1);
            }
            while(map1.size()>k){
                int val3=map1.get(s.charAt(l1));
                val3--;
                if(val3==0){
                    map1.remove(s.charAt(l1));
                }
                else{
                    map1.put(s.charAt(l1),val3);
                }
                l1++;
            }
            if(map1.size()<=k){
                count1=count1+(r1-l1+1);

            }
            r1++;
        }
        return count-count1;
    }
}