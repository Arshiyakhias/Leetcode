class Solution {
    public int uniqueEmailGroups(String[] emails) {
        HashMap<String,Integer>map=new HashMap<>();
        for(String sing:emails){
            String[]arr=sing.split("@");
            String first=arr[0];
            String second=arr[1];
            second=second.toLowerCase();

            String firs=new String();

            for(int i=0;i<first.length();i++){
                if(first.charAt(i)=='+'){
                    break;
                }
                if(first.charAt(i)=='.'){
                    continue;
                }
                else{
                    first=first.toLowerCase();
                    firs=firs+first.charAt(i);

                }
            }
            firs=firs+'@'+second;
            
            System.out.println(firs);
            if(map.containsKey(firs)){
                int val=map.get(firs);
                val++;
                map.put(firs,val);
            }
            else{
                map.put(firs,1);
            }

        }
        return map.size();
    }
}