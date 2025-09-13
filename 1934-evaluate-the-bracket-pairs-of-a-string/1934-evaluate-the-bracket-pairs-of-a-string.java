class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String,String>map=new HashMap<>();
        for(List<String> know:knowledge){
            map.put(know.get(0),know.get(1));
        }
        StringBuilder find=new StringBuilder();
        Boolean flag=false;
        String ans=new String();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==')'){
                if(map.containsKey(find.toString())){
                    String adds=map.get(find.toString());
                    ans=ans+adds;
                    find.setLength(0);
                }
                else{
                    ans=ans+"?";
                    find.setLength(0);

                }
                flag=false;

            }
            else if(s.charAt(i)=='(' ){
                flag=true;
               
                

            }
            
            
            else if(flag==true){
                find.append(s.charAt(i));
            }
            else{
                ans=ans+s.charAt(i);
            }

        }
        return ans;

    }
}