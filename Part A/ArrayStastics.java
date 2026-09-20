public class ArrayStatistics {
    public static void displayStatistics(int[] serviceTimes) {
        int totalStudents = serviceTimes.length;

        int totalTime = 0;

        for (int i=0; i<serviceTimes.length; i++) {
            totalTime = totalTime + serviceTimes[i];
        }

        double averageTime = (double) totalTime / totalStudents;

        int highest = serviceTimes[0];
        for (int i=1; i<serviceTimes.length; i++) {
            if (serviceTimes[i] > highest) {
                highest = serviceTimes[i];
            }
        }
        int lowest = serviceTimes[0];
        for (int i=1; i<serviceTimes.length; i++) {
            if (serviceTimes[i] < lowest) {
                lowest = serviceTimes[i];
            }
        }
        int longerThan10 = 0;
        for (int i=0; i<serviceTimes.length; i++) {
            if (serviceTimes[i] > 10) {
                longerThan10++;
            }
        }
        system.out.println("========== DAILY SERVICE STATISTICS ==========");
        system.out.println("Total number of students served: " + totalStudents);
        system.out.println("Total service time: " + totalTime + " minutes");
        system.out.println("Average service time: " + averageTime + " minutes");
        system.out.println("Longest service time: " + highest + " minutes");
        system.out.println("Shortest service time: " + lowest + " minutes");
        system.out.println("Number of students with service time longer than 10 minutes: " + longerThan10);
