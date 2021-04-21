public class App {
    public static void main(String[] args) throws Exception {
        String A = "alabalabala";
        String B = "alabala";

        System.out.println(
                String.format("A contains B (includes overlapping characters) %s times", countOccurences(A, B)));
    }

    private static int countOccurences(String A, String B) {
        // Validate input and check if A contains B at least once.
        if (A.isBlank() || B.isBlank() || !A.contains(B)) {
            return 0;
        }

        int response = 0;
        int counter = 0;

        // Loop as many times as string B can be shifted to the right without
        // going out of string A.
        for (int i = 0; i <= A.length() - B.length(); i++) {
            // Loop to check if string B matches sub-string from A char by char.
            for (int j = 0; j < B.length(); j++) {
                if (A.charAt(i + j) == B.charAt(j)) {
                    counter++;
                }
            }
            // Check if all chars from B matched.
            if (counter == B.length()) {
                response++;
            }
            // Reset counter to start counting for another occurance.
            counter = 0;
        }

        return response;
    }
}
