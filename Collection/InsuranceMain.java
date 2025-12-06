package Assignment.Collection;

import java.time.LocalDate;

public class InsuranceMain {
    public static void main(String[] args) {
        InsuranceSystem system = new InsuranceSystem();

        system.addPolicy(new Policy("P001", "Alice", LocalDate.now().plusDays(10), "Health", 5000));
        system.addPolicy(new Policy("P002", "Bob", LocalDate.now().plusDays(40), "Auto", 3000));
        system.addPolicy(new Policy("P003", "Alice", LocalDate.now().plusDays(25), "Home", 7000));
        system.addPolicy(new Policy("P004", "David", LocalDate.now().minusDays(5), "Health", 4500));

        system.displayAllPolicies();

        System.out.println("Policy by Number P001: " + system.getPolicyByNumber("P001"));
        System.out.println("Expiring Soon: " + system.getExpiringSoon());
        System.out.println("Policies for Alice: " + system.getByPolicyholder("Alice"));

        system.removeExpired();
        System.out.println("After removing expired policies:");
        system.displayAllPolicies();
    }
}

