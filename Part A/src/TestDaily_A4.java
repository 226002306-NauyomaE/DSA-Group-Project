public class TestDaily_A4 {
    public static void main(String[] args) {
        // Simulated day: service times for 6 students
        int[] times = {15, 10, 5, 20, 8, 12}; // 225100908=15, John=10, Maria=5 etc.
        DailyStatistics_A4 stats = new DailyStatistics_A4(times);
        stats.displayStats();
    }
}
