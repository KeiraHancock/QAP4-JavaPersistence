import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DrugFileHandler {
    private static final String FILE_NAME = "drugs.txt";

    public static void saveDrugToFile(Drug drug) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(drug.toString());
            writer.newLine();
            System.out.println("Drug saved to file.");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }

    public static void readDrugsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("\n--- Drug Data from File ---");
            while ((line = reader.readLine()) != null) {
                Drug drug = Drug.fromString(line);
                System.out.println(drug);
            }
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }
}

// NOTE: println text is placeholder due to editor issue, functionality still works
// System.out.println("x:");

