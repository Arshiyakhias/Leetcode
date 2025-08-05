class Solution {
    public int maxArea(int[] height) {
      int left=0;
       int right=height.length-1;
       int max_area=0;
       while(left<right){
        int min=Math.min(height[left],height[right]);
        int area=min*(right-left);
        max_area=Math.max(max_area,area);
        if(min==height[left]){
            left++;
        }
        else{
            right--;
        }

       } 
       return max_area;  
    }
}