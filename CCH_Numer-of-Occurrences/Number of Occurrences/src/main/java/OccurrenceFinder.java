import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class OccurrenceFinder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter input string :");
        String inputText = scanner.nextLine();
        scanner.close();
        findOccurrences(inputText);
    }

    public static void findOccurrences(String inputText) {

        char[] chars = inputText.toUpperCase().toCharArray();

        ArrayList<Character> charList = new ArrayList();
        HashSet<Character> charSet = new HashSet();
        for (char c : chars) {
            if (Character.isAlphabetic(c)) {
                charSet.add(c);
                charList.add(c);
            }
        }

        char[] sampleChars = new char[charList.size()];
        int i = 0;
        for (char c : charList) {
            sampleChars[i++] = c;
        }

        char[] distinctChars = new char[charSet.size()];
        i = 0;
        for (char c : charSet) {
            distinctChars[i++] = c;
        }

        sort(distinctChars);
        printCharCounts(sampleChars, distinctChars);
    }

    public static void sort(char[] inputArray) {

        int maxIndex = inputArray.length - 1;
        for (int i = 0; i < maxIndex; i++) {
            for (int j = 0; j < maxIndex - i; j++) {
                if (inputArray[j] > inputArray[j + 1]) {
                    char temp = inputArray[j];
                    inputArray[j] = inputArray[j + 1];
                    inputArray[j + 1] = temp;
                }
            }
        }
    }

    public static void printCharCounts(char[] sampleChars, char[] distinctChars) {

        for (char distinctChar : distinctChars) {
            int count = 0;
            for (char c : sampleChars) {
                if (distinctChar == c) {
                    count++;
                }
            }
            System.out.println(distinctChar + " - " + count);
        }
    }
}
