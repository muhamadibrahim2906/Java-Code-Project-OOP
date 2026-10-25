class PasswordVault {
    String website;
    String username;
    String password;

    PasswordVault() {
        website = "Unknown";
        username = "Unknown";
        password = "123456";
    }

    PasswordVault(String website, String username, String password) {
        this.website = website;
        this.username = username;
        this.password = password;
    }

    PasswordVault(String website, String password) {
        this.website = website;
        this.password = password;
        this.username = "Not Available";
    }

    void display() {
        System.out.println("Website : " + website);
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println();
    }
}

public class Main1 {
    public static void main(String[] args) {
        PasswordVault vault1 = new PasswordVault();
        PasswordVault vault2 = new PasswordVault("Gmail", "john@gmail.com", "Pass@123");
        PasswordVault vault3 = new PasswordVault("Facebook", "FB@456");

        System.out.println("===== CYBERSECURITY PASSWORD VAULT =====");
        vault1.display();
        vault2.display();
        vault3.display();
    }
}
