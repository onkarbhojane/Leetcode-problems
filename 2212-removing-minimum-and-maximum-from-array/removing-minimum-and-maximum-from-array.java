class Solution {
    public int minimumDeletions(int[] nums) {
        int min=0;
        int max=0;
        for(int i=0;i<nums.length;i++){
            if(nums[min]>nums[i]) min=i;
            if(nums[max]<nums[i]) max=i;
        }
        return Math.min(Math.max(max,min)+1,Math.min(nums.length-Math.min(max,min),Math.min(max,min)+1+nums.length-Math.max(max,min)));
    }
}