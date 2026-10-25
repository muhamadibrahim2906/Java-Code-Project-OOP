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
        username = "Not Available";
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
        System.out.println("Password: " + (hidePassword ? "********" : password));
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

public class Main {
    public static void main(String[] args) {
        PasswordVault vault1 = new PasswordVault();
        PasswordVault vault2 = new PasswordVault("Gmail", "john@gmail.com", "Pass@123");
        PasswordVault vault3 = new PasswordVault("Facebook", "FB@456");

        System.out.println("===== CYBERSECURITY PASSWORD VAULT =====\n");
        vault1.display();
        vault2.display(true);
        vault3.display(false);

        vault1.setPassword("NewPass@789");
        System.out.println("After Updating Password:");
        vault1.display();

        PasswordVault.showTotalAccounts();
    }
}
