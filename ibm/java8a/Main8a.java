class PasswordVault extends Thread {
    private String password;

    PasswordVault(String password) {
        this.password = password;
    }

    public void run() {
        System.out.println("Password entered: " + password);

        if (password.length() >= 8) {
            System.out.println("Password accepted.");
            System.out.println("Password stored securely.");
        } else {
            System.out.println("Password rejected.");
        }
    }
}

public class Main8a {
    public static void main(String[] args) {
        System.out.println("=== Cybersecurity Password Vault ===");

        String password = "Cyber@123";

        PasswordVault vault = new PasswordVault(password);

        Thread t = new Thread(vault);

        t.start();

        System.out.println("Main class is running.");
    }
}
