class Solution {
    public int maxFreqSum(String s) {
        HashMap<Character,Integer>vowel=new HashMap<>();
        HashMap<Character,Integer>consonant=new HashMap<>();

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' || s.charAt(i)=='o' || s.charAt(i)=='u'){
                if(vowel.containsKey(s.charAt(i))){
                    int val=vowel.get(s.charAt(i));
                    val++;
                    vowel.put(s.charAt(i),val);
                }
                else{
                    vowel.put(s.charAt(i),1);
                }
            }
        }


        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!='a' && s.charAt(i)!='e' && s.charAt(i)!='i' && s.charAt(i)!='o' && s.charAt(i)!='u'){
                if(consonant.containsKey(s.charAt(i))){
                    int val=consonant.get(s.charAt(i));
                    val++;
                    consonant.put(s.charAt(i),val);
                }
                else{
                    consonant.put(s.charAt(i),1);
                }
            }
        }
        int max_vowel=0;
        int max_consonant=0;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' || s.charAt(i)=='o' || s.charAt(i)=='u'){
                if(vowel.containsKey(s.charAt(i))){
                    int val=vowel.get(s.charAt(i));
                    max_vowel=Math.max(max_vowel,val);
                    
                }
                
            }
        }

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!='a' && s.charAt(i)!='e' && s.charAt(i)!='i' && s.charAt(i)!='o' && s.charAt(i)!='u'){
                if(consonant.containsKey(s.charAt(i))){
                    int val=consonant.get(s.charAt(i));
                    max_consonant=Math.max(max_consonant,val);
                    
                }
                
            }
        }

        return max_vowel+max_consonant;
        
            
    }
}