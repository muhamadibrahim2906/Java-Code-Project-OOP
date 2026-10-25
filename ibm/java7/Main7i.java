import java.util.Scanner;

class VaultException extends Exception {
    public VaultException(String message) {
        super(message);
    }
}

class PasswordVault {
    private String masterPassword;
    private String website;
    private String username;
    private String password;

    public PasswordVault(String masterPassword) {
        this.masterPassword = masterPassword;
    }

    public void addPassword(String website, String username, String password)
            throws VaultException {
        if (website.isEmpty() || username.isEmpty() || password.isEmpty()) {
            throw new VaultException("All fields are required!");
        }
        if (password.length() < 6) {
            throw new VaultException("Password must contain at least 6 characters!");
        }
        this.website = website;
        this.username = username;
        this.password = password;
        System.out.println("Password saved successfully!");
    }

    public void viewPassword(String enteredPassword) throws VaultException {
        if (!masterPassword.equals(enteredPassword)) {
            throw new VaultException("Incorrect master password!");
        }
        if (website == null) {
            throw new VaultException("No password is stored in the vault!");
        }
        System.out.println("\n--- Password Details ---");
        System.out.println("Website  : " + website);
        System.out.println("Username : " + username);
        System.out.println("Password : " + password);
    }
}

public class Main7i {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PasswordVault vault = new PasswordVault("admin123");
        System.out.println("===== CYBERSECURITY PASSWORD VAULT =====");
        try {
            System.out.print("Enter website: ");
            String website = sc.nextLine();
            System.out.print("Enter username: ");
            String username = sc.nextLine();
            System.out.print("Enter password: ");
            String password = sc.nextLine();
            vault.addPassword(website, username, password);
            System.out.print("\nEnter master password to view vault: ");
            String masterPassword = sc.nextLine();

            vault.viewPassword(masterPassword);
        } catch (VaultException e) {
            System.out.println("Security Error: " + e.getMessage());
        }
        sc.close();
    }
}
