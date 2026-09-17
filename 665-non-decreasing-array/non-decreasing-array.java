class Solution {
    public boolean checkPossibility(int[] nums) {
        if(nums.length==1) return true;
        int cnt1=0;
        int cnt2=0;
        int[] rep=new int[nums.length];
        for(int i=0;i<nums.length;i++) rep[i]=nums[i];
        for(int i=1;i<nums.length;i++){
            if(nums[i]<nums[i-1]){
                nums[i]=nums[i-1];
                cnt1++;
            }
        }
        for(int i=nums.length-2;i>=0;i--){
            if(rep[i]>rep[i+1]){
                rep[i]=rep[i+1];
                cnt2++;
            }
        }
        return cnt1<=1 || cnt2<=1;
    }
}