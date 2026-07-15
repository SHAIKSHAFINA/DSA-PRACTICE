class Solution {
    public String reverseVowels(String s) {
        int n=s.length();

        //int a[]={'a','e','i','o','u','A','E','I','O','U'};
        char arr[]=s.toCharArray();
        HashSet<Character> sc=new HashSet<>();
        sc.add('a');
        sc.add('e');
        sc.add('i');
        sc.add('o');
        sc.add('u');
        sc.add('A');
        sc.add('E');
        sc.add('I');
        sc.add('O');
        sc.add('U');

        int l=0,r=n-1;

        while(l<=r){
            if(sc.contains(arr[l]) && sc.contains(arr[r])){
                char temp=arr[l];
                arr[l]=arr[r];
                arr[r]=temp;
                l++;
                r--;
            }
            else if(sc.contains(s.charAt(l))){
                r--;
            }
            else{
                l++;
            }
        }

        StringBuilder sb=new StringBuilder();

        for(char x:arr){
            sb.append(x);
        }

        return sb.toString();
    }
}