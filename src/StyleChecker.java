import java.io.FileNotFoundException;
import java.util.Scanner;

public class StyleChecker {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);

        String filePath = getFilePath(args, input);

        if (filePath.equalsIgnoreCase("help")) {
            printHelpMessage();
            return;
        }

        if (!filePath.endsWith(".java")) {
            throw new IllegalArgumentException("Error: Input file must be a Java source code "
                    + "file. (i.e ending in .java)");
        }

        Assignment assignment = new Assignment(filePath);
        System.out.println(assignment);

        // Clean up
        input.close();
    }

    private static void printHelpMessage() {
        System.out.println("To check your file, input the absolute path of the file you want to "
                + "style check\n(absolute path: file path starting from / on Mac/Linux "
                + "and C:\\ on Windows)");
    }

    private static String getFilePath(String[] args, Scanner input) {
        if (args.length >= 1) {
            return args[0];
        } 

        System.out.printf("Input the absolute path of the file you want to style check: ");
        return input.nextLine();        
        
    }

}
