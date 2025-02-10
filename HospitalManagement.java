import java.util.ArrayList;
import java.util.Scanner;

class Patient {
    int id;
    String name;
    int age;
    String disease;

    Patient(int id, String name, int age, String disease) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.disease = disease;
    }

    void displayInfo() {
        System.out.println("ID: " + id + " | Name: " + name + " | Age: " + age + " | Disease: " + disease);
    }
}

public class HospitalManagement {
    static ArrayList<Patient> patients = new ArrayList<>();
    static int idCounter = 1;
    
    public static void addPatient(Scanner scanner) {
        System.out.print("Enter Patient Name: ");
        String name = scanner.next();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        System.out.print("Enter Disease: ");
        String disease = scanner.next();

        patients.add(new Patient(idCounter++, name, age, disease));
        System.out.println("Patient added successfully!");
    }

    public static void displayPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients found.");
            return;
        }
        for (Patient p : patients) {
            p.displayInfo();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        
        do {
            System.out.println("\n1. Add Patient\n2. Display Patients\n3. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1: addPatient(scanner); break;
                case 2: displayPatients(); break;
                case 3: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice!");
            }
        } while (choice != 3);
        
        scanner.close();
    }
}
