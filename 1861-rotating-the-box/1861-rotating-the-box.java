class Solution {
    public char[][] rotateTheBox(char[][] arr) {
        int n=arr.length;
        int m=arr[0].length;

        char[][] ans=rotate(arr);

        for(int i=0;i<m;i++){
            reverse(ans[i]);
        }


        for(int j=0;j<n;j++){
            int space=m-1;;
            for(int i=m-1;i>=0;i--){
               if(ans[i][j]=='*'){
                    space=i-1;
                    continue;
               }
               else if(ans[i][j]=='#'){
                    ans[i][j]='.';
                    ans[space][j]='#';
                    space--;
               }
                    
                
            }
        }

        return ans;
    }

    char[][] rotate(char arr[][]){
        int n=arr.length;
        int m=arr[0].length;
        char a[][]=new char[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                a[i][j]=arr[j][i];
            }
        }
        return a;
    }

    void reverse(char arr[]){
        int n=arr.length;
        for(int i=0;i<n/2;i++){
            char temp=arr[i];
            arr[i]=arr[n-i-1];
            arr[n-i-1]=temp;
        }
    }
}