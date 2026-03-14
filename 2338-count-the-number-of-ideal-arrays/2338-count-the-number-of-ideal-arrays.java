class Solution {
    static final int MOD = 1000000007;

    public int idealArrays(int n, int maxValue) {

        int maxP = 14;

        long[][] C = new long[n + maxP][maxP + 1];

        for(int i = 0; i < C.length; i++){
            C[i][0] = 1;
            for(int j = 1; j <= Math.min(i, maxP); j++){
                C[i][j] = (C[i-1][j-1] + C[i-1][j]) % MOD;
            }
        }

        long ans = 0;

        for(int x = 1; x <= maxValue; x++){
            int num = x;
            long ways = 1;

            for(int p = 2; p * p <= num; p++){
                if(num % p == 0){
                    int cnt = 0;
                    while(num % p == 0){
                        num /= p;
                        cnt++;
                    }
                    ways = (ways * C[n-1 + cnt][cnt]) % MOD;
                }
            }

            if(num > 1){
                ways = (ways * C[n][1]) % MOD;
            }

            ans = (ans + ways) % MOD;
        }

        return (int)ans;
    }
}