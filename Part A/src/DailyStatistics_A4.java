// Task A4 - Daily Statistics - Array [5]
// Student: 225100908 - Amakali
// No built-in max(), min(), sum() used

public class DailyStatistics_A4 {
    private int[] serviceTimes;

    public DailyStatistics_A4(int[] times) {
        this.serviceTimes = times;
    }

    public int totalStudentsServed() {
        return serviceTimes.length;
    }

    public int totalServiceTime() {
        int total = 0;
        for (int i = 0; i < serviceTimes.length; i++) {
            total = total + serviceTimes[i];
        }
        return total;
    }

    public double averageServiceTime() {
        int total = totalServiceTime();
        int count = totalStudentsServed();
        if (count == 0) return 0;
        return (double) total / count;
    }

    public int highestServiceTime() {
        if (serviceTimes.length == 0) return 0;
        int max = serviceTimes[0];
        for (int i = 1; i < serviceTimes.length; i++) {
            if (serviceTimes[i] > max) {
                max = serviceTimes[i];
            }
        }
        return max;
    }

    public int lowestServiceTime() {
        if (serviceTimes.length == 0) return 0;
        int min = serviceTimes[0];
        for (int i = 1; i < serviceTimes.length; i++) {
            if (serviceTimes[i] < min) {
                min = serviceTimes[i];
            }
        }
        return min;
    }

    public int countLongerThan10() {
        int count = 0;
        for (int i = 0; i < serviceTimes.length; i++) {
            if (serviceTimes[i] > 10) {
                count++;
            }
        }
        return count;
    }

    public void displayStats() {
        System.out.println("Total students served: " + totalStudentsServed());
        System.out.println("Total service time: " + totalServiceTime() + " mins");
        System.out.println("Average service time: " + averageServiceTime() + " mins");
        System.out.println("Highest service time: " + highestServiceTime() + " mins");
        System.out.println("Lowest service time: " + lowestServiceTime() + " mins");
        System.out.println("Services >10 mins: " + countLongerThan10());
    }
}
