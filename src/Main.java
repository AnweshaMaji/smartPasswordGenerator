import java.util.Scanner;

class User {
    String name;
    String pan;
    String dob;

    User(String name, String pan, String dob) {
        this.name = name;
        this.pan = pan;
        this.dob = dob;
    }
}

class PasswordGenerator {

    // Method to generate password
    public static String generatePassword(User user) {

        // Extract useful parts
        String namePart = user.name.substring(0, 2).toUpperCase();

        String panPart = user.pan.substring(5, 9);

        String dobPart = user.dob.replace("/", "");

        String special = "@#";

        // Final Password
        String password = namePart + panPart + special + dobPart;
        return password;
    }
    // Method to check password strength
    public static String checkStrength(String password) {

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char ch : password.toCharArray()) {

            if (Character.isUpperCase(ch))
                hasUpper = true;

            else if (Character.isLowerCase(ch))
                hasLower = true;

            else if (Character.isDigit(ch))
                hasDigit = true;

            else
                hasSpecial = true;
        }

        int length = password.length();

        if (length >= 12 && hasUpper && hasLower && hasDigit && hasSpecial) {
            return "Strong";
        }

        else if (length >= 8 && hasDigit && hasSpecial) {
            return "Medium";
        }
        else {
            return "Weak";
        }
    }
}

class SmartPasswordGenerator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of users: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) {

            System.out.println("\n--- User " + i + " ---");

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter PAN Number: ");
            String pan = sc.nextLine();

            System.out.print("Enter DOB (DD/MM/YYYY): ");
            String dob = sc.nextLine();

            User user = new User(name, pan, dob);

            String password = PasswordGenerator.generatePassword(user);

            System.out.println("Generated Password: " + password);

            String strength = PasswordGenerator.checkStrength(password);

            System.out.println("Password Strength: " + strength);
        }

        sc.close();
    }
}