class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {

        int n = landStartTime.length;
        int m = waterStartTime.length;

        long minLandFinish = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            minLandFinish = Math.min(minLandFinish,
                                     (long) landStartTime[i] + landDuration[i]);
        }

        long minWaterFinish = Long.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            minWaterFinish = Math.min(minWaterFinish,
                                      (long) waterStartTime[j] + waterDuration[j]);
        }

        long ans = Long.MAX_VALUE;

        // Land -> Water
        for (int j = 0; j < m; j++) {
            long finish = Math.max(minLandFinish, (long) waterStartTime[j])
                          + waterDuration[j];
            ans = Math.min(ans, finish);
        }

        // Water -> Land
        for (int i = 0; i < n; i++) {
            long finish = Math.max(minWaterFinish, (long) landStartTime[i])
                          + landDuration[i];
            ans = Math.min(ans, finish);
        }

        return (int) ans;
    }
}