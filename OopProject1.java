import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

class Employee {
    private String firstName;
    private String lastName;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}

class CredentialService {
    public String determineDepartment(int choice) {
        switch (choice) {
            case 1:
                return "Technical";
            case 2:
                return "Admin";
            case 3:
                return "HumanResource";
            case 4:
                return "Legal";
            default:
                return "Unknown";
        }
    }

    public String generateEmailAddress(Employee employee, String department) {
        String email = employee.getFirstName().toLowerCase() + employee.getLastName().toLowerCase() +
                "@" + department.toLowerCase() + ".company.com";
        return email;
    }

    public String generatePassword() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@#$%&";
        StringBuilder password = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(characters.length());
            password.append(characters.charAt(index));
        }

        return password.toString();
    }

    public void showCredentials(Employee employee, String email, String password) {
        System.out.println("Dear " + employee.getFirstName() + ", your generated credentials are as follows");
        System.out.println("Email ---> " + email);
        System.out.println("Password ---> " + password);
    }
}

public class OopProject1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the department from the following: \n1. Technical \n2. Admin \n3. Human Resource \n4. Legal");

        int choice = 0;
        try {
          choice = sc.nextInt();
        }catch(InputMismatchException e) {
          System.out.println("Please enter a number.");
          System.exit(0);
        }

        sc.nextLine(); 

        System.out.print("Enter the first name: ");
        String firstName = sc.nextLine();

        System.out.print("Enter the last name: ");
        String lastName = sc.nextLine();

        Employee employee = new Employee(firstName, lastName);
        CredentialService credentialService = new CredentialService();

        String department = credentialService.determineDepartment(choice);
        String email = credentialService.generateEmailAddress(employee, department);
        String password = credentialService.generatePassword();

        credentialService.showCredentials(employee, email, password);
    }
}