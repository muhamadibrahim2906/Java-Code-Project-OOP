import java.util.Scanner;

class PasswordVault {
    private String website;
    private String username;
    private String password;

    private static int totalAccounts = 0;

    public PasswordVault() {
        website = "Unknown";
        username = "Unknown";
        password = "123456";
        totalAccounts++;
    }

    public PasswordVault(String website, String username, String password) {
        this.website = website;
        this.username = username;
        this.password = password;
        totalAccounts++;
    }

    public PasswordVault(String website, String password) {
        this.website = website;
        this.password = password;
        this.username = "Not Available";
        totalAccounts++;
    }

    public void display() {
        System.out.println("Website : " + website);
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println();
    }

    public void display(boolean hidePassword) {
        System.out.println("Website : " + website);
        System.out.println("Username: " + username);

        if (hidePassword) {
            System.out.println("Password: ********");
        } else {
            System.out.println("Password: " + password);
        }

        System.out.println();
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getWebsite() {
        return website;
    }

    public static void showTotalAccounts() {
        System.out.println("Total Password Vault Accounts: " + totalAccounts);
    }
}

public class Passwordvault {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== CYBERSECURITY PASSWORD VAULT =====");

        System.out.println("\nEnter details for Vault 2");
        System.out.print("Website: ");
        String website1 = sc.nextLine();

        System.out.print("Username: ");
        String username1 = sc.nextLine();

        System.out.print("Password: ");
        String password1 = sc.nextLine();

        System.out.println("\nEnter details for Vault 3");
        System.out.print("Website: ");
        String website2 = sc.nextLine();

        System.out.print("Password: ");
        String password2 = sc.nextLine();

        PasswordVault vault1 = new PasswordVault();
        PasswordVault vault2 = new PasswordVault(website1, username1, password1);
        PasswordVault vault3 = new PasswordVault(website2, password2);

        System.out.print("\nEnter a new password for Vault 1: ");
        String newPassword = sc.nextLine();
        vault1.setPassword(newPassword);

        System.out.println("\n===== PASSWORD VAULT DETAILS =====\n");

        System.out.println("Vault 1:");
        vault1.display();

        System.out.println("Vault 2:");
        vault2.display(true);

        System.out.println("Vault 3:");
        vault3.display(false);

        PasswordVault.showTotalAccounts();
        sc.close();
    }
}
