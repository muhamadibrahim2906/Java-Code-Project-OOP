import java.util.Scanner;

class Vault {
    protected String username;
    protected String password;

    public void storeCredentials(String user, String pass) {
        username = user;
        password = pass;
    }

    public void displayInfo() {
        System.out.println("Vault Information");
    }
}

class PasswordManager extends Vault {
    @Override
    public void displayInfo() {
        System.out.println("\n=== Password Manager ===");
        System.out.println("Username : " + username);
        System.out.println("Password : " + password);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Username: ");
        String user = sc.nextLine();

        System.out.print("Enter Password: ");
        String pass = sc.nextLine();

        PasswordManager pm = new PasswordManager();
        pm.storeCredentials(user, pass);
        pm.displayInfo();

        SecurityChecker checker = new SecurityChecker();
        checker.storeCredentials(user, pass);
        checker.displayInfo();
        checker.checkPasswordStrength();

        sc.close();
    }
}

class SecurityChecker extends Vault {
    @Override
    public void displayInfo() {
        System.out.println("\n=== Security Checker ===");
    }

    public void checkPasswordStrength() {
        if (password == null) {
            System.out.println("Password Strength : Weak");
            return;
        }

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
