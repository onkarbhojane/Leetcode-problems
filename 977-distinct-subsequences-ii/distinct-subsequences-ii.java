class Solution {
    long[] dp;
    long max=1000000007;
    public int distinctSubseqII(String s) {
        dp=new long[s.length()+1];
        Arrays.fill(dp,-1);
        return (int)find(s,-1);
    }
    public long find(String s,int i){
        if(i==s.length()) return 0;
        if(dp[(i+s.length())%s.length()]!=-1) return dp[i];
        long ans=0;
        HashSet<Character> set=new HashSet<>();
        for(int j=i+1;j<s.length();j++){
            if(set.contains(s.charAt(j))) continue;
            ans=(ans%max+(find(s,j)%max+1)%max)%max;
            set.add(s.charAt(j));
        }
        return dp[(i+s.length())%s.length()]=ans%max;
    }
}