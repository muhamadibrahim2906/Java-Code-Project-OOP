import java.util.Scanner;

class Vault {
    protected String username;
    protected String password;

    public void storeCredentials(String user, String pass) {
        username = user;
        password = pass;
    }
}

class PasswordVault extends Vault {
    public void displayCredentials() {
        System.out.println("\n=== Password Vault ===");
        System.out.println("Username : " + username);
        System.out.println("Password : " + password);
    }

    public void checkPasswordStrength() {
        if (password.length() >= 8) {
            System.out.println("Password Strength: Strong");
        } else {
            System.out.println("Password Strength: Weak");
        }
    }
}

public class Main4bi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PasswordVault vault = new PasswordVault();

        System.out.print("Enter Username: ");
        String user = sc.nextLine();
        System.out.print("Enter Password: ");
        String pass = sc.nextLine();

        vault.storeCredentials(user, pass);
        vault.displayCredentials();
        vault.checkPasswordStrength();

        sc.close();
    }
}
