class Solution {
    char oddchr='-';
    public String lexPalindromicPermutation(String s, String target) {
        int[] freq=new int[26];
        for(int i=0;i<s.length();i++) freq[s.charAt(i)-'a']++;
        int cnt=0;
        for(int i=0;i<26;i++) cnt+=(freq[i]%2);
        if(cnt>1) return "";
        if(cnt==1 && target.length()%2==0) return "";
        for(int i=0;i<26;i++){
            if(freq[i]%2==1){
                oddchr=(char)('a'+i);
            }
            freq[i]/=2;
        }
        int ub=s.length()/2;
        char[] ans=new char[ub];
        if(find(freq,ans,target,0)) return "";
        String str=new String(ans);
        if(s.length()%2==1) str+=oddchr;
        for(int i=ans.length-1;i>=0;i--) str+=ans[i];
        System.out.println(str+" "+target);
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)>target.charAt(i)) return str;
            else if(str.charAt(i)<target.charAt(i)) return "";
        }
        return "";
    }
    public boolean find(int[] freq,char[] ans,String t,int i){
        if(i==ans.length){
            if(t.length()%2==0) return false;
            System.out.println(Arrays.toString(ans)+" "+oddchr+" "+t.charAt(i));
            for(int j=0;j<ans.length;j++){
                if(t.charAt(j)<ans[j]) return false;
                else if(t.charAt(j)>ans[j]) return true;
            }
            if(oddchr>t.charAt(i)) return false;
            else if(oddchr<t.charAt(i)) return true;
            int k=i+1;
            for(int j=ans.length-1;j>=0;j--){
                System.out.println(ans[j]+" "+t.charAt(k));
                if(t.charAt(k)<ans[j]) return false;
                else if(t.charAt(k)>ans[j]) return true;
                k++;
            }
            return true;
        }
        char p=t.charAt(i);
        for(char k=p;k<='z';k++){
            if(freq[k-'a']==0) continue;
            freq[k-'a']--;
            if(k>p){
                ans[i]=k;
                int l=i+1;
                for(char j='a';j<='z';j++){
                    while(freq[j-'a']>0){
                        freq[j-'a']--;
                        ans[l++]=j;
                    }   
                }
                return false;
            }
            if(k==p && gen(freq,ans,t,i+1)){
                ans[i]=k;
                if(!find(freq,ans,t,i+1)){
                    return false;
                }
            }
            freq[k-'a']++;
        }
        return true;
    }
    public boolean gen(int[] freq,char[] ans,String t,int i){
        int[] freql=new int[26];
        int e=i;
        for(int j=0;j<26;j++) freql[j]=freq[j];
        while(i<t.length()){
            char p=t.charAt(i);
            for(char k='z';k>='a';k--){
                if(freql[k-'a']==0) continue;
                if(k>p) return true;
                if(k==p){
                    freql[k-'a']--;
                    break;
                }
            }
            i++;
        }
        int l=t.length()/2-1;
        int r=t.length()/2;
        if(t.length()%2==1){
            if(oddchr>=t.charAt(r)) return true;
            r++;
        }
        while(l>=0 && r<t.length()){
            if(t.charAt(r)<t.charAt(l)) return true;
            else if(t.charAt(r)>t.charAt(l)) return false;
            l--;
            r++;
        } 
        return false;
    }
}