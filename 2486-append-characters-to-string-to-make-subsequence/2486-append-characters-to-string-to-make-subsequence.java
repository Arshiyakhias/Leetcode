class Solution {
    public int appendCharacters(String s, String t) {
        if(s.contains(t)){
            return 0;
        }
        int s_count=0;
        int t_count=0;
        while(s_count<s.length() && t_count<t.length() ){
            if(s.charAt(s_count)==t.charAt(t_count)){
                s_count++;
                t_count++;
                            }
                            else{
                                s_count++;
                            }
        }
        String addon=new String();
        for(int i=t_count;i<t.length();i++){
            addon=addon+t.charAt(i);
        }
        return addon.length();
    }
}