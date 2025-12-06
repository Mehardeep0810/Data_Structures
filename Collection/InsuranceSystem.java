package Assignment.Collection;

import java.time.LocalDate;
import java.util.*;

public class InsuranceSystem {
    private Map<String, Policy> hashMapPolicies = new HashMap<>();
    private Map<String, Policy> linkedHashMapPolicies = new LinkedHashMap<>();
    private Map<LocalDate, Policy> treeMapPolicies = new TreeMap<>();

    // Add policy to all maps
    public void addPolicy(Policy policy) {
        hashMapPolicies.put(policy.getPolicyNumber(), policy);
        linkedHashMapPolicies.put(policy.getPolicyNumber(), policy);
        treeMapPolicies.put(policy.getExpiryDate(), policy);
    }

    // Retrieve by policy number
    public Policy getPolicyByNumber(String number) {
        return hashMapPolicies.get(number);
    }

    // List policies expiring within 30 days
    public List<Policy> getExpiringSoon() {
        LocalDate today = LocalDate.now();
        LocalDate threshold = today.plusDays(30);
        List<Policy> result = new ArrayList<>();
        for (Policy p : treeMapPolicies.values()) {
            if (!p.getExpiryDate().isAfter(threshold)) {
                result.add(p);
            }
        }
        return result;
    }

    // List policies for a specific policyholder
    public List<Policy> getByPolicyholder(String name) {
        List<Policy> result = new ArrayList<>();
        for (Policy p : hashMapPolicies.values()) {
            if (p.getPolicyholderName().equalsIgnoreCase(name)) {
                result.add(p);
            }
        }
        return result;
    }

    // Remove expired policies
    public void removeExpired() {
        LocalDate today = LocalDate.now();
        hashMapPolicies.values().removeIf(p -> p.getExpiryDate().isBefore(today));
        linkedHashMapPolicies.values().removeIf(p -> p.getExpiryDate().isBefore(today));
        treeMapPolicies.values().removeIf(p -> p.getExpiryDate().isBefore(today));
    }

    // Display all policies
    public void displayAllPolicies() {
        System.out.println("HashMap Policies: " + hashMapPolicies.values());
        System.out.println("LinkedHashMap Policies: " + linkedHashMapPolicies.values());
        System.out.println("TreeMap Policies (sorted by expiry): " + treeMapPolicies.values());
    }
}
