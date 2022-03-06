import java.util.Scanner;

public class MissingNumberFinder {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the (space seperated) numbers in the series :");
        String inputText = s.nextLine();
        if (validateInput(inputText)){
            String[] stringArray = inputText.trim().split(" ");
            int[] inputArray = getIntArray(stringArray);
            sort(inputArray);
            printArray(inputArray);
            findMissingNumber(inputArray);
        } else {
            System.out.println("Input number series is invalid. Please only input numbers and separate them by one space delimiter.");
        }
    }

    public static boolean validateInput(String inputText) {
        return inputText.matches("^(-?\\d+ ?)+$");
    }

    public static int[] getIntArray(String[] stringArray) {
        int[] inputArray = new int[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            inputArray[i] = Integer.parseInt(stringArray[i]);
        }
        return inputArray;
    }

    public static void printArray(int[] inputArray) {
        System.out.print("Finding missing number from -> ");
        for (int i : inputArray) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void sort(int[] inputArray) {
        int maxIndex = inputArray.length - 1;
        for (int i = 0; i < maxIndex; i++) {
            for (int j = 0; j < maxIndex - i; j++) {
                if (inputArray[j] > inputArray[j + 1]) {
                    int temp = inputArray[j];
                    inputArray[j] = inputArray[j + 1];
                    inputArray[j + 1] = temp;
                }
            }
        }
    }

    public static void findMissingNumber(int[] inputArray) {
        int maxIndex = inputArray.length - 1;
        Integer missingNumber = null;
        for (int i = 0; i < maxIndex; i++) {
            int diff = inputArray[i + 1] - inputArray[i];
            if (diff != 1) {
                if (diff == 2) {
                    if (missingNumber == null) {
                        missingNumber = inputArray[i] + 1;
                    } else {
                        System.out.println("Series contains more than one missing number.");
                        return;
                    }
                } else if (diff == 0) {
                    System.out.println("Invalid Number Series. There are duplicate numbers in the series.");
                    return;
                } else {
                    System.out.println("Series contains more than one missing number.");
                    return;
                }
            }
        }
        int start = inputArray[0];
        int end = inputArray[maxIndex];
        if (missingNumber == null) {
            System.out.println("There's no number missing from " + start + " to " + end + ". Possible missing number is either " + (start - 1) + " or " + (end + 1) + ".");
        } else {
            System.out.println("Missing number from " + start + " to " + end + " is : " + missingNumber);
        }
    }
}
