import java.util.Scanner;

// Stores credentials so the subclasses can use them.
class Vault {
    protected String username;
    protected String password;

    // Save the supplied username and password.
    public void storeCredentials(String user, String pass) {
        username = user;
        password = pass;
    }
}

// Displays the credentials saved in Vault.
class PasswordManager extends Vault {
    public void displayCredentials() {
        System.out.println("\n=== Stored Credentials ===");
        System.out.println("Username : " + username);
        System.out.println("Password : " + password);
    }
}

// Checks that the password meets the required strength criteria.
class SecurityChecker extends Vault {
    public void checkPasswordStrength() {
        // A strong password has at least eight characters, including
        // uppercase and lowercase letters, a digit, and a listed symbol.
        if (password.length() >= 8
                && password.matches(".*[A-Z].*")
                && password.matches(".*[a-z].*")
                && password.matches(".*[0-9].*")
                && password.matches(".*[@#$%^&+=!].*")) {
            System.out.println("Password Strength : Strong");
        } else {
            System.out.println("Password Strength : Weak");
        }
    }
}

// Reads credentials, displays them, and reports password strength.
public class Main4ai {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String user;
        do {
            System.out.print("Enter Username: ");
            user = sc.nextLine();
            if (user.trim().isEmpty()) {
                System.out.println("Username cannot be empty.");
            }
        } while (user.trim().isEmpty());

        String pass;
        do {
            System.out.print("Enter Password: ");
            pass = sc.nextLine();
            if (pass.trim().isEmpty()) {
                System.out.println("Password cannot be empty.");
            }
        } while (pass.trim().isEmpty());

        PasswordManager pm = new PasswordManager();
        pm.storeCredentials(user, pass);
        pm.displayCredentials();

        // The checker stores its own copy of the credentials for evaluation.
        SecurityChecker checker = new SecurityChecker();
        checker.storeCredentials(user, pass);
        checker.checkPasswordStrength();
        sc.close();
    }
}
