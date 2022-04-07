import java.util.Scanner;
class Palindrome {
    private static Scanner scanner = new Scanner(System.in);

    public static void main (String args[]) {
        System.out.print("Entrez un mot ou une phrase : ");
       String input = scanner.nextLine();

       String test = input.toLowerCase();

       String allowedList = "abcdefghijklmnopqrstuvwxyz";
       String temp = "";
        for (int i = 0; i < test.length(); i++) {
            char c = test.charAt(i);
            if (allowedList.indexOf(c) != -1) {
                temp += c;
            }
        }
        test = temp;

        int leftPos = 0;
        int rightPos = test.length() - 1;
        boolean palindrome=true;
        while ((leftPos < rightPos) && palindrome) {
            if (test.charAt(leftPos) != test.charAt(rightPos)) {
                palindrome=false;
            }
            leftPos++;
            rightPos--;
        }

        if (palindrome) {
            System.out.println("C'est un palindrome !");
        } else {
            System.out.println("Non, ce n'est pas un palindrome.");
        }
    }
}