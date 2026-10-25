class PasswordVault {
    int availableSlots = 2;

    synchronized void storePassword(String name, String password) {
        System.out.println(name + " wants to store a password.");
        System.out.println("Entered Password: " + password);
        while (availableSlots < 1) {
            System.out.println(name + " is waiting for vault space...");
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        availableSlots--;
        System.out.println(name + " stored the password successfully.");
        System.out.println("Password: " + password);
        System.out.println("Available Vault Slots: " + availableSlots);
    }

    synchronized void deletePassword(String name) {
        availableSlots++;
        System.out.println(name + " deleted the password.");
        System.out.println("Available Vault Slots: " + availableSlots);
        notify();
    }
}

class StorePasswordThread extends Thread {
    PasswordVault vault;
    String name;
    String password;

    StorePasswordThread(PasswordVault vault, String name, String password) {
        this.vault = vault;
        this.name = name;
        this.password = password;
    }

    public void run() {
        vault.storePassword(name, password);
    }
}

class DeletePasswordThread extends Thread {
    PasswordVault vault;
    String name;

    DeletePasswordThread(PasswordVault vault, String name) {
        this.vault = vault;
        this.name = name;
    }

    public void run() {
        vault.deletePassword(name);
    }
}

public class Main9 {
    public static void main(String[] args) {
        PasswordVault vault = new PasswordVault();
        System.out.println("Available Vault Slots : " + vault.availableSlots);
        StorePasswordThread t1 =
                new StorePasswordThread(vault, "User 1", "Cyber@123");
        StorePasswordThread t2 =
                new StorePasswordThread(vault, "User 2", "Secure@456");
        DeletePasswordThread t3 =
                new DeletePasswordThread(vault, "User 1");
        t1.start();
        t2.start();
        t3.start();
    }
}
