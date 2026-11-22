class SecuritySystem {
    public final void authenticateUser() {
        System.out.println("Standard 2-Factor Authentication");
    }
}

class AdvancedSecuritySystem extends SecuritySystem {
    public void authenticateUser() {
        System.out.println("Advanced Biometric Authentication");
    }
}

public class Cycle6_2 {
    public static void main(String[] args) {
        AdvancedSecuritySystem system = new AdvancedSecuritySystem();
        system.authenticateUser(); 
    }
}
