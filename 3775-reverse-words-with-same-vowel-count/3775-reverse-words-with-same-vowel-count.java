class Solution {
    public String reverseWords(String s) {
        HashSet<Character>set=new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        String[]arr=s.split(" ");
        int count=0;
        for(int i=0;i<arr[0].length();i++){
            if(set.contains(arr[0].charAt(i))){
                count++;
            }
        }
        int check=0;
        String ans=new String();
        for(String word:arr){
            check++;
            if(check==1){
                ans=ans+word;
            }
            else{
                int vals=0;
                for(int i=0;i<word.length();i++){
                    if(set.contains(word.charAt(i))){
                        vals++;

                    }
                }
                if(vals==count){
                    StringBuilder str=new StringBuilder(word);
                    str.reverse();
                    ans=ans+" ";
                    ans=ans+str.toString();
                }
                else{
                    ans=ans+" ";
                    ans=ans+word;
                }
            }


        }
        System.out.println(ans);
        return ans;

    }
}