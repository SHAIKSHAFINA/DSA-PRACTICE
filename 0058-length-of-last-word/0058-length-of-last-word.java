class Solution {
    public int lengthOfLastWord(String s) {
        int n=s.length();
        String a[]=s.split(" ");
        int x=a.length;
        String t=a[x-1].trim();

        return t.length();
    }
}