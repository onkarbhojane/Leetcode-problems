class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        int[][] dp=new int[nums.length][multipliers.length];
        for(int i=0;i<nums.length;i++) Arrays.fill(dp[i],-1);
        return find(nums,multipliers,0,nums.length-1,0,dp);
    }
    public int find(int[] nums, int[] mp,int l,int r,int k,int[][] dp){
        if(k==mp.length) return 0;
        if(dp[l][k]!=-1) return dp[l][k];
        int ans=find(nums,mp,l+1,r,k+1,dp)+nums[l]*mp[k];
        ans=Math.max(ans,find(nums,mp,l,r-1,k+1,dp)+nums[r]*mp[k]);
        return dp[l][k]=ans;
    }
}