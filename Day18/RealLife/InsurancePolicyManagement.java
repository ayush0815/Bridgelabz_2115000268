package RealLife;
import java.util.*;

class Policy implements Comparable<Policy> {
    private String policyNumber;
    private String policyHolder;
    private Date expiryDate;
    private String coverageType;
    private double premiumAmount;

    public Policy(String policyNumber, String policyHolder, Date expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyHolder = policyHolder;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() { return policyNumber; }
    public String getCoverageType() { return coverageType; }
    public Date getExpiryDate() { return expiryDate; }

    @Override
    public String toString() {
        return "{Policy#: " + policyNumber + ", Holder: " + policyHolder + ", Expiry: " + expiryDate + 
               ", Type: " + coverageType + ", Premium: " + premiumAmount + "}";
    }

    @Override
    public int compareTo(Policy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Policy policy = (Policy) obj;
        return Objects.equals(policyNumber, policy.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }
}

public class InsurancePolicyManagement {
    private Set<Policy> hashSetPolicies = new HashSet<>();
    private Set<Policy> linkedHashSetPolicies = new LinkedHashSet<>();
    private Set<Policy> treeSetPolicies = new TreeSet<>();

    public void addPolicy(Policy policy) {
        hashSetPolicies.add(policy);
        linkedHashSetPolicies.add(policy);
        treeSetPolicies.add(policy);
    }

    public void displayAllPolicies() {
        System.out.println("All Unique Policies (HashSet): " + hashSetPolicies);
        System.out.println("Insertion Order Policies (LinkedHashSet): " + linkedHashSetPolicies);
        System.out.println("Sorted Policies by Expiry Date (TreeSet): " + treeSetPolicies);
    }

    public void displayExpiringSoon(int days) {
        Date today = new Date();
        System.out.println("Policies Expiring in Next " + days + " Days:");
        for (Policy policy : treeSetPolicies) {
            long diff = (policy.getExpiryDate().getTime() - today.getTime()) / (1000 * 60 * 60 * 24);
            if (diff <= days) {
                System.out.println(policy);
            }
        }
    }

    public void displayByCoverageType(String type) {
        System.out.println("Policies with Coverage Type: " + type);
        for (Policy policy : hashSetPolicies) {
            if (policy.getCoverageType().equalsIgnoreCase(type)) {
                System.out.println(policy);
            }
        }
    }

    public void findDuplicatePolicies() {
        Set<String> seen = new HashSet<>();
        Set<Policy> duplicates = new HashSet<>();

        for (Policy policy : hashSetPolicies) {
            if (!seen.add(policy.getPolicyNumber())) {
                duplicates.add(policy);
            }
        }
        System.out.println("Duplicate Policies: " + duplicates);
    }

    public void comparePerformance() {
        System.out.println("\nPerformance Comparison:");

        long start, end;

        // HashSet Performance
        start = System.nanoTime();
        hashSetPolicies.contains(new Policy("P1", "Test", new Date(), "Health", 500));
        end = System.nanoTime();
        System.out.println("HashSet Search Time: " + (end - start) + " ns");

        start = System.nanoTime();
        hashSetPolicies.remove(new Policy("P1", "Test", new Date(), "Health", 500));
        end = System.nanoTime();
        System.out.println("HashSet Remove Time: " + (end - start) + " ns");

        // LinkedHashSet Performance
        start = System.nanoTime();
        linkedHashSetPolicies.contains(new Policy("P1", "Test", new Date(), "Health", 500));
        end = System.nanoTime();
        System.out.println("LinkedHashSet Search Time: " + (end - start) + " ns");

        start = System.nanoTime();
        linkedHashSetPolicies.remove(new Policy("P1", "Test", new Date(), "Health", 500));
        end = System.nanoTime();
        System.out.println("LinkedHashSet Remove Time: " + (end - start) + " ns");

        // TreeSet Performance
        start = System.nanoTime();
        treeSetPolicies.contains(new Policy("P1", "Test", new Date(), "Health", 500));
        end = System.nanoTime();
        System.out.println("TreeSet Search Time: " + (end - start) + " ns");

        start = System.nanoTime();
        treeSetPolicies.remove(new Policy("P1", "Test", new Date(), "Health", 500));
        end = System.nanoTime();
        System.out.println("TreeSet Remove Time: " + (end - start) + " ns");
    }

    public static void main(String[] args) {
        InsurancePolicyManagement system = new InsurancePolicyManagement();

        system.addPolicy(new Policy("P1", "Alpha", new Date(2025 - 1900, 3, 15), "Health", 1200));
        system.addPolicy(new Policy("P2", "Bravo", new Date(2024 - 1900, 2, 20), "Auto", 900));
        system.addPolicy(new Policy("P3", "Charlie", new Date(2024 - 1900, 2, 25), "Home", 1500));
        system.addPolicy(new Policy("P4", "Delta", new Date(2026 - 1900, 5, 10), "Health", 1100));
        system.addPolicy(new Policy("P1", "Alpha", new Date(2025 - 1900, 3, 15), "Health", 1200)); // Duplicate

        system.displayAllPolicies();
        system.displayExpiringSoon(30);
        system.displayByCoverageType("Health");
        system.findDuplicatePolicies();
        system.comparePerformance();
    }
}
