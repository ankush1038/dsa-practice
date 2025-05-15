import java.util.*;

public class LogProcessor {

    public static List<List<String>> extractErrorLogs(List<List<String>> logs) {
        List<List<String>> filteredLogs = new ArrayList<>();

        // Step 1: Filter ERROR or CRITICAL using simple for loop
        for (int i = 0; i < logs.size(); i++) {
            List<String> log = logs.get(i);
            String status = log.get(2);
            if (status.equals("ERROR") || status.equals("CRITICAL")) {
                filteredLogs.add(log);
            }
        }

        // Step 2: Sort filtered logs using comparator (still stable)
        Collections.sort(filteredLogs, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> log1, List<String> log2) {
                String key1 = getSortableKey(log1.get(0), log1.get(1));
                String key2 = getSortableKey(log2.get(0), log2.get(1));
                return key1.compareTo(key2);
            }
        });

        return filteredLogs;
    }

    // Helper function to convert date and time to sortable format
    private static String getSortableKey(String date, String time) {
        // Convert DD-MM-YYYY to YYYYMMDD
        String[] dateParts = date.split("-");
        String sortableDate = dateParts[2] + dateParts[1] + dateParts[0];
        // Convert HH:MM to HHMM
        String sortableTime = time.replace(":", "");
        return sortableDate + sortableTime;
    }

    // Driver code for testing
    public static void main(String[] args) {
        List<List<String>> logs = new ArrayList<>();
        logs.add(Arrays.asList("01-01-2023", "14:00", "ERROR", "failed"));
        logs.add(Arrays.asList("01-01-2023", "15:00", "INFO", "established"));
        logs.add(Arrays.asList("01-01-2023", "01:30", "ERROR", "failed"));

        List<List<String>> result = extractErrorLogs(logs);

        // Print using simple for loop
        for (int i = 0; i < result.size(); i++) {
            List<String> log = result.get(i);
            System.out.println(log);
        }
    }
}