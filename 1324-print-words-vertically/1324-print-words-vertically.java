class Solution {
    public List<String> printVertically(String s) {
        String[]arr=s.split(" ");
        int max=0;
        for(String single:arr){
            max=Math.max(max,single.length());
        }
        HashMap<Integer,String>map=new HashMap<>();
        int check=arr.length;
        for(String sing:arr){
            for(int i=0;i<max;i++){
                if(i<sing.length()){
                if(map.containsKey(i)){
                    String val=map.get(i);
                    val=val+sing.charAt(i);
                    map.put(i,val);
                }
                else{
                    String addon=new String();
                    addon=addon+sing.charAt(i);
                    map.put(i,addon);
                }
                }
                else{
                    String adds=new String(" ");
                    if(map.containsKey(i)){
                        String addson=map.get(i);
                        
                        addson=addson+adds;
                        map.put(i,addson);
                    }
                    else{
                        map.put(i,adds);
                    }
                    
                }
            }
        }
        int vals=map.size();
        List<String>ans=new ArrayList<>();
        for(int i=0;i<vals;i++){
            ans.add(map.get(i));

        }
        List<String>answer=new ArrayList<>();


        for(String checking:ans){
            StringBuilder str=new StringBuilder(checking);
            int valse=checking.length()-1;
            Boolean flag=true;
            for(int i=valse;i>=0;i--){
                if(str.charAt(i)==' '){
                    str.delete(i,i+1);

                }
                else{
                    flag=false;
                }
                if(flag==false){
                    break;
                }
            }
            answer.add(str.toString());
        }
        return answer;
    }
}