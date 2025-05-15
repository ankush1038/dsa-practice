import java.util.*;

public class AnalyticsStoreMain {

    enum ActionEnum {
        feature1Button,
        feature2Button,
        feature3Button
    }

    static class AnalyticsStore {
        public void storeActions(Queue<ActionEnum> q) {
            List<ActionEnum> list = new ArrayList<>(q);
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        }
    }

    static class Analytics {
        private final AnalyticsStore analyticsStore;
        private final int K;
        private Queue<ActionEnum> buffer;
        private int totalLogged;
        private Map<ActionEnum, Integer> frequencyMap;

        public Analytics(AnalyticsStore analyticsStore, int K) {
            this.analyticsStore = analyticsStore;
            this.K = K;
            this.buffer = new LinkedList<>();
            this.totalLogged = 0;
            this.frequencyMap = new HashMap<>();
        }

        public void registerAction(ActionEnum action) {
            buffer.add(action);
            totalLogged++;

            Integer count = frequencyMap.get(action);
            if (count == null) {
                frequencyMap.put(action, 1);
            } else {
                frequencyMap.put(action, count + 1);
            }

            if (buffer.size() == K) {
                analyticsStore.storeActions(buffer);
                buffer = new LinkedList<>();
            }
        }

        public int getNumberOfActionRegisteredButNotSentToAnalyticsStore() {
            return buffer.size();
        }

        public int getTotalNumberOfLoggedActions() {
            return totalLogged;
        }

        public List<ActionEnum> getMostFrequentlyUsedActions() {
            List<ActionEnum> mostUsed = new ArrayList<>();
            int maxFreq = 0;

            List<ActionEnum> keys = new ArrayList<>(frequencyMap.keySet());
            for (int i = 0; i < keys.size(); i++) {
                ActionEnum key = keys.get(i);
                int freq = frequencyMap.get(key);

                if (freq > maxFreq) {
                    mostUsed.clear();
                    mostUsed.add(key);
                    maxFreq = freq;
                } else if (freq == maxFreq) {
                    mostUsed.add(key);
                }
            }

            Collections.sort(mostUsed, new Comparator<ActionEnum>() {
                public int compare(ActionEnum a1, ActionEnum a2) {
                    return a1.name().compareTo(a2.name());
                }
            });

            return mostUsed;
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int totalRequests = sc.nextInt();
        int K = sc.nextInt();
        sc.nextLine();

        AnalyticsStore store = new AnalyticsStore();
        Analytics analytics = new Analytics(store, K);

        for (int i = 0; i < totalRequests; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");

            if (parts[0].equals("registerAction")) {
                ActionEnum action = ActionEnum.valueOf(parts[1]);
                analytics.registerAction(action);
            } else if (parts[0].equals("getTotalNumberOfLoggedActions")) {
                System.out.println(analytics.getTotalNumberOfLoggedActions());
            } else if (parts[0].equals("getNumberOfActionRegisteredButNotSentToAnalyticsStore")) {
                System.out.println(analytics.getNumberOfActionRegisteredButNotSentToAnalyticsStore());
            } else if (parts[0].equals("getMostFrequentlyUsedActions")) {
                List<ActionEnum> result = analytics.getMostFrequentlyUsedActions();
                for (int j = 0; j < result.size(); j++) {
                    System.out.print(result.get(j).name() + " ");
                }
                System.out.println();
            }
        }
    }
}