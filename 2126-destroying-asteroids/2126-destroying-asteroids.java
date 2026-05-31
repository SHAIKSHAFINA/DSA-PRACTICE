class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
         Arrays.sort(asteroids);

        long currentMass = mass;

        for (int rock : asteroids) {

            if (currentMass < rock) {
                return false;
            }

            currentMass += rock;
        }

        return true;
    }
}