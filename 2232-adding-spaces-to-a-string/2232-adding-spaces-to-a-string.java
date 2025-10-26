class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder str=new StringBuilder();
        HashSet<Integer>set=new HashSet<>();
        for(int i=0;i<spaces.length;i++){
            set.add(spaces[i]);
        }
        for(int i=0;i<s.length();i++){
            if(set.contains(i)){
                str.append(" ");
                str.append(s.charAt(i));
            }
            else{
                str.append(s.charAt(i));
            }
        }
        return str.toString();
    }
}