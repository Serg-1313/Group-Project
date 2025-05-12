package am.aua.utils;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class TerminalHelper {
    /** askQuestionWithOptions is method for asking question with options in terminal
     * @param scanner {Scanner} is the input method
     * @param question {String} is the message that should be asked
     * @param options {String[]} is the list of messages which can be as answers
     * @return {int} which is the option for answer
     */
    public static int askQuestionWithOptions(Scanner scanner, String question, String[] options, boolean isAnswerRequired) throws InputMismatchException {
        int answer;
        System.out.println(question);
        PrintHelper.printOptions(options);

        answer = scanner.nextInt();
        while (answer < 1 || answer > options.length) {
            System.err.println("Please provide a valid option between 1 and " + options.length);
            PrintHelper.printOptions(options);

            answer = scanner.nextInt();
        }

        return isAnswerRequired ? Integer.parseInt(options[answer-1]) : answer;
    }

    /** askQuestionWithoutOption is method for asking question without option in terminal
     * @param scanner {Scanner} is the input method
     * @param question {String} is the message that should be asked
     * @return {int} which is the option for answer
     */
    public static String askQuestionWithoutOption(Scanner scanner, String question)  {
        String answer;
        System.out.println(question);
        answer = scanner.next();

        while (answer.isEmpty()) {
            System.err.println("Please provide a valid player name!");
            answer = scanner.next();
        }

        return answer;
    }

    /** askUntilAnswerIsCorrect is method for catching the error
     * @param scanner {Scanner} is the input method
     * @param question {String} is the message that should be asked
     * @param options {String[]} is the list of messages which can be as answers
     * @return {int} which is the option for answer
     */
    public static int askUntilAnswerIsCorrect(Scanner scanner, String question, String[] options, boolean isAnswerRequired) {
        int numTries = 0;
        while (numTries < 10) {
            try {
                numTries++;
                return askQuestionWithOptions(scanner, question, options, isAnswerRequired);
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.err.println("Please provide a valid input as a number!");
            }
        }

        System.err.println("Bye idiot!");
        System.exit(0);
        return 0;
    }

    public static boolean askConfirmationQuestion(Scanner scanner, String question) {
        String answer;
        System.out.println(question);
        answer = scanner.next();

        while (!(Objects.equals(answer, "Y") || Objects.equals(answer, "N"))) {
            System.err.println("Please provide a valid answer!");
            answer = scanner.next();
        }

        return answer.equals("Y");
    }
}
