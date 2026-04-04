class Solution {
    public String reorganizeString(String s) {
        HashMap<Character,Integer>map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                int val=map.get(s.charAt(i));
                val++;
                map.put(s.charAt(i),val);
            }
            else{
                map.put(s.charAt(i),1);
            }
        }
        
        PriorityQueue<Character>pq=new PriorityQueue<Character>((a,b)->map.get(b)-map.get(a));
        for(int i=0;i<s.length();i++){
            if(!pq.contains(s.charAt(i))){
                pq.add(s.charAt(i));

            }
        }

        String ans=new String();
        char prev='0';
        while(!pq.isEmpty()){
            char sing=pq.poll();
            if(prev!=sing){
                ans=ans+sing;
                int vals=map.get(sing);
                vals--;
                if(vals!=0){
                    map.put(sing,vals);
                    pq.add(sing);
                }
                else{
                    map.remove(sing);
                }
                
                prev=sing;
                System.out.println(prev);
                
            }
            else{
                if (pq.isEmpty()) {
                    return "";
                }
                
                char nex=pq.poll();
                if(prev!=nex){
                ans=ans+nex;
                int vals=map.get(nex);
                vals--;
                if(vals!=0){
                    map.put(nex,vals);
                    pq.add(nex);
                }
                else{
                    map.remove(nex);
                }
                
                pq.add(sing);
              
                prev=nex;
                
            }

            }
        }
       
        return ans;

    }
}