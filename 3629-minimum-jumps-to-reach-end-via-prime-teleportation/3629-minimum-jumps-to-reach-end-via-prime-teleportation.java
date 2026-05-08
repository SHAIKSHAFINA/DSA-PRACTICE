class Solution {
    public int minJumps(int[] nums) {
        int n = nums.length;

        if (n == 1) return 0;

        // Map: prime factor -> all indices divisible by that prime
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            List<Integer> factors = getPrimeFactors(nums[i]);

            for (int p : factors) {
                map.computeIfAbsent(p, k -> new ArrayList<>()).add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];

        // To avoid processing same prime teleport multiple times
        Set<Integer> usedPrime = new HashSet<>();

        q.offer(0);
        visited[0] = true;

        int steps = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            for (int s = 0; s < size; s++) {

                int i = q.poll();

                if (i == n - 1) return steps;

                // Adjacent Left
                if (i - 1 >= 0 && !visited[i - 1]) {
                    visited[i - 1] = true;
                    q.offer(i - 1);
                }

                // Adjacent Right
                if (i + 1 < n && !visited[i + 1]) {
                    visited[i + 1] = true;
                    q.offer(i + 1);
                }

                // Prime Teleportation
                if (isPrime(nums[i])) {

                    int prime = nums[i];

                    // Process this prime only once
                    if (!usedPrime.contains(prime)) {

                        usedPrime.add(prime);

                        List<Integer> nextIndices = map.get(prime);

                        if (nextIndices != null) {

                            for (int idx : nextIndices) {

                                if (!visited[idx]) {
                                    visited[idx] = true;
                                    q.offer(idx);
                                }
                            }
                        }
                    }
                }
            }

            steps++;
        }

        return -1;
    }

    // Check Prime
    private boolean isPrime(int num) {

        if (num < 2) return false;

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }

        return true;
    }

    // Unique Prime Factors
    private List<Integer> getPrimeFactors(int num) {

        List<Integer> factors = new ArrayList<>();

        for (int i = 2; i * i <= num; i++) {

            if (num % i == 0) {

                factors.add(i);

                while (num % i == 0) {
                    num /= i;
                }
            }
        }

        if (num > 1) {
            factors.add(num);
        }

        return factors;
    }
}
