class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int[] prefmin=new int[nums.length];
        prefmin[nums.length-1]=nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--) prefmin[i]=Math.min(prefmin[i+1],nums[i]);
        int max=nums[0];
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
            if(max-prefmin[i]<=k) return i;
        }
        return -1;
    }
}