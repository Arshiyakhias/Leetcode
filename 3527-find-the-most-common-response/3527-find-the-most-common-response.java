class Solution {
    public String findCommonResponse(List<List<String>> responses) {
        HashMap<String,List<Integer>>map=new HashMap<>();
        int count=0;
        String ans=new String();


        for(List<String>lis:responses){
            for(int i=0;i<lis.size();i++){
                if(map.containsKey(lis.get(i))){
                    List<Integer>check=map.get(lis.get(i));
                    if(!check.contains(count)){
                        map.get(lis.get(i)).add(count);

                    }
                }
                else{
                    List<Integer>addon=new ArrayList<>();
                    addon.add(count);
                    map.put(lis.get(i),addon);
                }
            }
            count++;

        }
        List<String>resp=new ArrayList<>(map.keySet());
        int max=0;
        for(int i=0;i<resp.size();i++){
            List<Integer>lists=map.get(resp.get(i));
            max=Math.max(max,lists.size());
        }
        List<String>answer=new ArrayList<>();
        for(int i=0;i<resp.size();i++){
            List<Integer>lists1=map.get(resp.get(i));
            if(lists1.size()==max){
                answer.add(resp.get(i));
            }
        }
        Collections.sort(answer);
        return answer.get(0);
    }
}