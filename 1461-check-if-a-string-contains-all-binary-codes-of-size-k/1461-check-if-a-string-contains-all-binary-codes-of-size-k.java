class Solution {
    public boolean hasAllCodes(String s, int k) {
        if(s.length()<k){
            return false;
        }
        int total_number=(int)Math.pow(2,k);

        HashSet<String>set=new HashSet<>();
        String subs=s.substring(0,k);
        set.add(subs);
        StringBuilder str=new StringBuilder(subs);

        int l=0;
        int r=k-1;
        while(r<s.length()-1){
            str.delete(0,1);
            l++;
            r++;
            str.append(s.charAt(r));
            set.add(str.toString());
           
        }

        if(set.size()==total_number){
            return true;
        }
        return false;
    }
}