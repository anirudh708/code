package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;


public class KMP {

    private int[] failureBuilder(String s){
        /*
         * Failure array generation for KMP algorithm.
         * 
         */
        char[] st = s.toCharArray();
        int m = s.length();
        int[] ar = new int[m+1];
        
        ar[0] = 0;
        ar[1] = 0;
        
        for(int k=2; k<=m; k++){
            int j = ar[k-1];
            
            while(true){
                if(st[k-1] == st[j]){
                    ar[k] = j+1;
                    break;
                }
                if(j==0){
                    ar[k]=0;
                    break;
                }
                j = ar [j];
            }

        }
        return ar;
    }
    
    private int findMatches(int[] ar,String text,String pattern){
        
        char[] t = text.toCharArray();
        char[] p = pattern.toCharArray();
        int tl = t.length;
        int pl = p.length;
        
        int i=0;
        int j=0,best=0,x=0,ans=0;
        
        while(i<tl){
            if(t[i] == p[j]){
                i++;
                j++;
                best++;
                if(best>x){
                    x = best;
                    ans = i-j;
                }
                if(j==(pl))
                    break;
            }
            
            else {best=0;
                if(j>0){
                j=ar[j];
                }
            else i++;
                }
            

        }
        
        
        return ans;
    }
    
    public static void main(String[] args) {
        KMP kmp = new KMP();
        
        MyScanne scan = new MyScanne();
        int x = scan.nextInt();
        String a = scan.next();
        String b = scan.next();
        int [] ar = kmp.failureBuilder(a);
        int ans = kmp.findMatches(ar,b+b,a);
        System.out.print(ans);
    }
}
class MyScanne {
    BufferedReader br;
    StringTokenizer st;
 
    public MyScanne() {
            br = new BufferedReader(new InputStreamReader(System.in));
    }
 
    boolean hasNext(){
            if(st.hasMoreElements())
                    return true;
            try {
                    st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                    e.printStackTrace();
            }
            return st.hasMoreTokens();
    }
    String next() {
            while (st == null || !st.hasMoreElements()) {
                    try {
                            st = new StringTokenizer(br.readLine());
                    } catch (Exception e) {
                            e.printStackTrace();
                    }
            }
            return st.nextToken().trim();
    }
 
    int nextInt() {
            return Integer.parseInt(next());
    }
 
    int nextint() {
            return Integer.parseInt(next());
    }
 
    double nextDouble() {
            return Double.parseDouble(next());
    }
 
    String nextLine(){
            String str = "";
            try {
                    str = br.readLine();
            } catch (IOException e) {
                    e.printStackTrace();
            }
            return str;
    }
 
    public long nextLong() {
            return Long.parseLong(next());
    }
 
} 
/*
 * You are given two strings A and B of the same length.
 * Each string contains N Lower case Latin character (from 'a' to 'z').
 * A shift operation will remove the first character of a string and add the same character at the end of that string.
 * For example after you perform a shift operation on a string 'abcd', the new string will be 'bcda'.
 * If you perform this operation two times, the new string will be 'cdab'. 
 * You need to use some (maybe none) shift operations on the string B to maximize the length of the longest common prefix of A and B.
 * If more than one result can be found pick the one that use smallest number of shift operations.
 */
