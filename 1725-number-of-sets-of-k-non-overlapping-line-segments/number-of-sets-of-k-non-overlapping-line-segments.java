class Solution {
    long[][] dp;
    long max=(long)(Math.pow(10,9)+7);
    public int numberOfSets(int n, int q) {
        dp=new long[1001][1001];
        long[][] pref=new long[1001][1001];
        for(int i=0;i<=n-1;i++) dp[0][i]=1;
        pref[0][0]=1;
        for(int i=1;i<=n-1;i++){
            pref[0][i]=dp[0][i]+pref[0][i-1];
        }
        for(int K=1;K<=q;K++){
            for(int i=n-1;i>=0;i--){
                long skip=dp[K][i+1]%max;
                long take=pref[K-1][n-1]-pref[K-1][i];
                dp[K][i]=(take+skip)%max;
            }
            pref[K][0]=1;
            for(int i=1;i<=n-1;i++){
                pref[K][i]=dp[K][i]+pref[K][i-1];
            }
        }
        return (int)dp[q][0];
    }
}