class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)
        {
            return false;
        }
        List<Integer>list=new ArrayList();
        while(x>0){
            list.add(x%10);
            x/=10;
        }
         List<Integer> rev = new ArrayList<>(list);
        Collections.reverse(rev);
        if(list.equals(rev))
        {
            return true;
        }
        return false;
    }
}