class Solution {
    public int longestMountain(int[] arr) {
        int[] inc=new int[arr.length];
        int[] dec=new int[arr.length];
        int cnt=1;
        inc[arr.length-1]=cnt;
        for(int i=arr.length-2;i>=0;i--){
            if(arr[i]<arr[i+1]){
                inc[i]=cnt;
            }else inc[i]=++cnt;
        }
        cnt=1;
        dec[0]=cnt;
        for(int i=1;i<arr.length;i++){
            if(arr[i]<arr[i-1]){
                dec[i]=cnt;
            }else dec[i]=++cnt;
        }
        int ans=0;
        System.out.println(Arrays.toString(inc)+" "+Arrays.toString(dec));
        for(int i=1;i<arr.length-1;i++){
            int lm=inc[i];
            int rm=dec[i];
            int r=0;
            int l=0;
            // System.out.println(arr[i]+" "+lm+" "+rm);
            for(int j=i;j<arr.length;j++){
                if(dec[j]!=rm) break;
                r++;
            }
            for(int j=i;j>=0;j--){
                if(inc[j]!=lm) break;
                l++;
            }
            System.out.println(i+" "+l+" "+r);
            if(l==1 || r==1) continue;
            ans=Math.max(ans,l+r-1);
        }
        return ans;
    }
}