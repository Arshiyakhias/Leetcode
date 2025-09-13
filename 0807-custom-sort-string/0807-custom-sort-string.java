class Solution {
    public String customSortString(String order, String s) {
        
        HashMap<Character,Integer>map=new HashMap<>();
        for(int i=0;i<order.length();i++){
            map.put(order.charAt(i),i);
        }
        List<Character>lis=new ArrayList<>();

        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                lis.add(s.charAt(i));
            }
        }
        Collections.sort(lis,(a,b)->
        Integer.compare(map.get(a),map.get(b))
        );
        String ans=new String();
        for(int i=0;i<lis.size();i++){
            ans=ans+lis.get(i);
        }
        for(int i=0;i<s.length();i++){
            if(!map.containsKey(s.charAt(i))){
                ans=ans+s.charAt(i);
            }
        }
        return ans;
    }
}