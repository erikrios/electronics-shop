import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    /**
     * Complete the getMoneySpent function below.
     */
    static int getMoney(int[] keyboards, int[] drives, int b) {
        int moneySpend;
        List<Integer> possibilityTotalSpends = new ArrayList<>();

        int keyboardType = keyboards.length;
        int drivesType = drives.length;

        for (int i = 0; i < keyboardType; i++) {
            for (int j = 0; j < drivesType; j++) {
                int total = keyboards[i] + drives[j];
                if (total <= b) {
                    possibilityTotalSpends.add(total);
                }
            }
        }

        if (possibilityTotalSpends.isEmpty()) {
            moneySpend = -1;
        } else {
            moneySpend = 0;
            for (Integer possibilityTotalSpend : possibilityTotalSpends) {
                if (moneySpend < possibilityTotalSpend) {
                    moneySpend = possibilityTotalSpend;
                }
            }
        }

        return moneySpend;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String[] bnm = scanner.nextLine().split(" ");
        scanner.skip("(\\r\\n|[\\n\\r\\u2028\\u2029\\u0085])*");

        int b = Integer.parseInt(bnm[0]);

        int n = Integer.parseInt(bnm[1]);

        int m = Integer.parseInt(bnm[2]);

        int[] keyboards = new int[n];

        String[] keyboardsItems = scanner.nextLine().split(" ");
        scanner.skip("(\\r\\n|[\\n\\r\\u2028\\u2029\\u0085])*");

        for (int keyboardsItr = 0; keyboardsItr < n; keyboardsItr++) {
            int keyboardsItem = Integer.parseInt(keyboardsItems[keyboardsItr]);
            keyboards[keyboardsItr] = keyboardsItem;
        }

        int[] drives = new int[m];

        String[] drivesItems = scanner.nextLine().split(" ");
        scanner.skip("(\\r\\n|[\\n\\r\\u2028\\u2029\\u0085])*");

        for (int drivesItr = 0; drivesItr < m; drivesItr++) {
            int drivesItem = Integer.parseInt(drivesItems[drivesItr]);
            drives[drivesItr] = drivesItem;
        }

        /*
         * The maximum amount of money she can spend on a keyboard and USB drive, or -1 if she can't purchase both items
         */

        int moneySpent = getMoney(keyboards, drives, b);

        bufferedWriter.write(String.valueOf(moneySpent));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
