class Solution {
    public int numKLenSubstrNoRepeats(String s, int k) {


        if(s.length()<k){
            return 0;
        }

        HashMap<Character,Integer>map=new HashMap<>();

        for(int i=0;i<k;i++){
            if(map.containsKey(s.charAt(i))){
                int val=map.get(s.charAt(i));
                val++;
                map.put(s.charAt(i),val);
            }
            else{
                map.put(s.charAt(i),1);
            }
        }
        int ans=0;
        if(map.size()==k){
            ans++;

        }
        for(int i=0;i<(s.length()-k);i++){
            int val_remove=map.get(s.charAt(i));
            val_remove--;
            if(val_remove==0){
                map.remove(s.charAt(i));
            }
            else{
                map.put(s.charAt(i),val_remove);
            }
            if(map.containsKey(s.charAt(i+k))){
                int val_add=map.get(s.charAt(i+k));
                val_add++;
                map.put(s.charAt(i+k),val_add);
            }
            else{
                map.put(s.charAt(i+k),1);
            }
            if(map.size()==k){
                ans++;
            }

        }
        return ans;
        
    }
}