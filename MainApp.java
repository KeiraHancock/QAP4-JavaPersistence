import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== Menu ===");
            System.out.println("1. Save drug to file");
            System.out.println("2. Read drugs from file");
            System.out.println("3. Save patient to database");
            System.out.println("4. Read patients from database");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Drug ID: ");
                    int did = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Name: ");
                    String dname = scanner.nextLine();
                    System.out.print("Cost: ");
                    double cost = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Dosage: ");
                    String dosage = scanner.nextLine();
                    DrugFileHandler.saveDrugToFile(new Drug(did, dname, cost, dosage));
                    break;
                case 2:
                    DrugFileHandler.readDrugsFromFile();
                    break;
                case 3:
                    System.out.print("Patient ID: ");
                    int pid = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("First Name: ");
                    String fname = scanner.nextLine();
                    System.out.print("Last Name: ");
                    String lname = scanner.nextLine();
                    System.out.print("DOB (YYYY-MM-DD): ");
                    String dob = scanner.nextLine();
                    PatientDatabaseHandler.savePatientToDatabase(new Patient(pid, fname, lname, dob));
                    break;
                case 4:
                    PatientDatabaseHandler.readPatientsFromDatabase();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}

