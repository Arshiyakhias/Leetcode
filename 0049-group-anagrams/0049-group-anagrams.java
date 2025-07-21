class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,ArrayList<String>>map=new HashMap<>();
        for(String word:strs){
            char[]arr=word.toCharArray();
            Arrays.sort(arr);
            String sortedstr=new String(arr);
            if(map.containsKey(sortedstr)){
                map.get(sortedstr).add(word);
            }
            else{
                map.put(sortedstr,new ArrayList<>());
                map.get(sortedstr).add(word);
            }
        }
        List<List<String>>ans=new ArrayList<>();
        for(String sorts:map.keySet()){
            ans.add(map.get(sorts));

        }
        return ans;

    }
}