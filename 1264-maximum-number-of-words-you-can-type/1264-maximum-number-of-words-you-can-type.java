class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        HashSet<Character>set=new HashSet<>();
        String[]arr=text.split(" ");
        for(int i=0;i<brokenLetters.length();i++){
            set.add(brokenLetters.charAt(i));
        }
        Boolean flag=false;
        int count=0;
        for(String word: arr){
            for(int i=0;i<word.length();i++){
                if(set.contains(word.charAt(i))){
                    flag=true;
                    break;
                }
            }
            if(flag==false){
                count++;
                
            }
            flag=false;
        }
        return count;
    }
}