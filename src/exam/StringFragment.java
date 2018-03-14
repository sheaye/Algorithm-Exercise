package exam;

import java.util.Scanner;

public class StringFragment {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();

            if (str != null && str.length() > 0) {
                int count = 1;
                char cur, old = str.charAt(0);
                for (int i = 1; i < str.length(); i++) {
                    cur = str.charAt(i);
                    if (cur != old) {
                        count++;
                        old = cur;
                    }
                }
                System.out.printf("%.2f", str.length() * 1f / count);
            } else {
                System.out.println(0);
            }
        }
    }

}
