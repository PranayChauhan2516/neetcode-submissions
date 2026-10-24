class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] cars = new int[n][2];
        for(int i=0; i<n; ++i) {
            cars[i] = new int[]{position[i], speed[i]};
        }
        Arrays.sort(cars, (car1, car2) -> car2[0] - car1[0]);
        Deque<Double> times = new ArrayDeque<>();
        for(int i=0; i<n; ++i) {
            double time = 1.0 * (target - cars[i][0]) / cars[i][1];
            if (times.isEmpty() || time > times.peekLast()) {
                times.addLast(time);
            }
        }
        return times.size();
    }
}
