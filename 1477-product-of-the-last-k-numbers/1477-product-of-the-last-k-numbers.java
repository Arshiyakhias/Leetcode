class ProductOfNumbers {
    List<Integer>lis=new ArrayList<>();

    public ProductOfNumbers() {
        
    }
    
    public void add(int num) {
        lis.add(num);
        
    }
    
    public int getProduct(int k) {
        int siz=lis.size();
        int pro=1;
        for(int i=lis.size()-1;i>=siz-k;i--){
            pro=pro*lis.get(i);

        }
        return pro;
        
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */