class Solution {
    public int totalDistance(String s) {
        List<String>lis=new ArrayList<>();
        lis.add("qwertyuiop");
        lis.add("asdfghjkl");
        lis.add("zxcvbnm");
        HashMap<Character,List<Integer>>map=new HashMap<>();
        int count=-1;

        for(String sing:lis){
            count++;

            for(int i=0;i<sing.length();i++){
                List<Integer>addon=new ArrayList<>();
                addon.add(count);
                addon.add(i);
                map.put(sing.charAt(i),addon);

            }

        }
        int sum=0;
        s='a'+s;
        for(int i=1;i<s.length();i++){
            List<Integer>first=map.get(s.charAt(i-1));
            List<Integer>second=map.get(s.charAt(i));
            int val1=Math.abs(first.get(0)-second.get(0));
            int val2=Math.abs(first.get(1)-second.get(1));
            sum=sum+val1+val2;
        }
        return sum;
    }
}