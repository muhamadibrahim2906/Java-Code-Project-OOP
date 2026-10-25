import java.util.Scanner;

abstract class Vault {

    String username;
    String password;

    public void storeDetails(String user, String pass) {
        username = user;
        password = pass;
    }

    public void displayDetails() {
        System.out.println("\n===== Cyber Security Password Vault =====");
        System.out.println("Username : " + username);
        System.out.println("Password : " + password);
    }

    abstract void validatePassword();
}

class PasswordVault extends Vault {

    void validatePassword() {

        boolean upper = false;
        boolean lower = false;
        boolean digit = false;
        boolean special = false;

        for (int i = 0; i < password.length(); i++) {

            char ch = password.charAt(i);

            if (Character.isUpperCase(ch))
                upper = true;
            else if (Character.isLowerCase(ch))
                lower = true;
            else if (Character.isDigit(ch))
                digit = true;
            else if ("@#$%^&*!".indexOf(ch) != -1)
                special = true;
        }

        System.out.println("\n----- Password Security Report -----");

        if (username.equals(password)) {
            System.out.println("Password should not be the same as Username.");
        }
        else if (password.length() >= 8 && upper && lower && digit && special) {
            System.out.println("Password Status : STRONG");
            System.out.println("Vault Secured Successfully.");
        }
        else {
            System.out.println("Password Status : WEAK");

            if (password.length() < 8)
                System.out.println("- Password must contain at least 8 characters.");

            if (!upper)
                System.out.println("- Add at least one uppercase letter.");

            if (!lower)
                System.out.println("- Add at least one lowercase letter.");

            if (!digit)
                System.out.println("- Add at least one number.");

            if (!special)
                System.out.println("- Add at least one special character (@#$%^&*!).");
        }
    }
}

public class Main6b {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Username: ");
        String user = sc.nextLine();

        System.out.print("Enter Password: ");
        String pass = sc.nextLine();

        PasswordVault vault = new PasswordVault();

        vault.storeDetails(user, pass);
        vault.displayDetails();
        vault.validatePassword();
        sc.close();
    }
}
