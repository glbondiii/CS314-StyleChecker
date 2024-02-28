import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.LinkedList;

public class Assignment {
    private String assignmentName;
    private LinkedList<String> fileLines;    
     
    public Assignment(String filePath) throws FileNotFoundException {
        assignmentName = filePath;
        fileLines = new LinkedList<>();
        File file = new File(filePath);
        Scanner fileScanner = new Scanner(file);

        while (fileScanner.hasNext()) {
            String fileLine = fileScanner.nextLine();
            fileLines.add(fileLine);
        }

        fileScanner.close();
    }

    public String getLine(int lineNum) {
        if (lineNum <= 0 || lineNum > fileLines.size()) {
            throw new IllegalArgumentException("Error: requested line number is out of range");
        }

        return fileLines.get(lineNum - 1);
    }

    public String toString() {
        StringBuilder assignmentString = new StringBuilder();

        assignmentString.append(assignmentName);
        assignmentString.append("\n"); 

        for (String line: fileLines) {
            assignmentString.append(line); 
            assignmentString.append("\n"); 
        }

        return assignmentString.toString();
    }
}
