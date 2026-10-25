class PasswordVault {
    private String website = "Gmail";
    private String username = "student123";
    private String password = "Secure@123";
    private final Object vaultLock = new Object();
    private final Object backupLock = new Object();

    public void storePassword() {
        synchronized (vaultLock) {
            synchronized (backupLock) {
                System.out.println("\n[STORE THREAD]");
                System.out.println("Accessing secure vault...");
                System.out.println("Encrypting password...");
                System.out.println("Password stored successfully!");
            }
        }
    }

    public void accessPassword() {
        synchronized (vaultLock) {
            synchronized (backupLock) {
                System.out.println("\n[ACCESS THREAD]");
                System.out.println("Authenticating vault...");
                System.out.println("Access granted!");
                System.out.println("Website  : " + website);
                System.out.println("Username : " + username);
                System.out.println("Password : " + password);
            }
        }
    }
}

class StoreThread extends Thread {
    private final PasswordVault vault;

    StoreThread(PasswordVault vault) {
        this.vault = vault;
    }

    @Override
    public void run() {
        vault.storePassword();
    }
}

class AccessThread extends Thread {
    private final PasswordVault vault;

    AccessThread(PasswordVault vault) {
        this.vault = vault;
    }

    @Override
    public void run() {
        vault.accessPassword();
    }
}

public class Main10i {
    public static void main(String[] args) {
        PasswordVault vault = new PasswordVault();
        StoreThread t1 = new StoreThread(vault);
        AccessThread t2 = new AccessThread(vault);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
            Thread.currentThread().interrupt();
        }

        System.out.println("\n================================");
        System.out.println("   PASSWORD VAULT COMPLETED");
        System.out.println("   Deadlock Prevented");
        System.out.println("================================");
    }
}
