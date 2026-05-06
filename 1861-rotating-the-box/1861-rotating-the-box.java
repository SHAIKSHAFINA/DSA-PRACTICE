class Solution {
    public char[][] rotateTheBox(char[][] arr) {
        int n=arr.length;
        int m=arr[0].length;

        char[][] ans=rotate(arr);

        for(int i=0;i<m;i++){
            reverse(ans[i]);
        }


        for(int j=0;j<n;j++){
            for(int i=m-1;i>=0;i--){
                if(ans[i][j]=='.'){
                    int stone=-1;

                    for(int k=i-1;k>=0;k--){
                        if(ans[k][j]=='*'){
                           break;
                        }
                        else if(ans[k][j]=='#'){
                            stone=k;
                            break;
                        }
                    }

                    if(stone!=-1){
                        ans[i][j]='#';
                        ans[stone][j]='.';
                    }
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