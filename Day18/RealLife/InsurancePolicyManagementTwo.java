package RealLife;
import java.util.*;
class Policy {
    String policyHolder;
    Date expiryDate;

    public Policy(String policyHolder, Date expiryDate) {
        this.policyHolder = policyHolder;
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "{Holder" + policyHolder + ", Expiry" + expiryDate + "}";
    }
}

public class InsurancePolicyManagement {
    private Map<String, Policy> policyMap = new HashMap<>();
    private Map<String, Policy> insertionOrderPolicies = new LinkedHashMap<>();
    private TreeMap<Date, String> expirySortedPolicies = new TreeMap<>();

    public void addPolicy(String policyNumber, String policyHolder, Date expiryDate) {
        Policy policy = new Policy(policyHolder, expiryDate);
        policyMap.put(policyNumber, policy);
        insertionOrderPolicies.put(policyNumber, policy);
        expirySortedPolicies.put(expiryDate, policyNumber);
    }

    public Policy getPolicyByNumber(String policyNumber) {
        return policyMap.get(policyNumber);
    }

    public List<Policy> getExpiringPolicies(int days) {
        List<Policy> result = new ArrayList<>();
        Date today = new Date();
        for (Map.Entry<Date, String> entry : expirySortedPolicies.entrySet()) {
            if ((entry.getKey().getTime() - today.getTime()) / (1000 * 60 * 60 * 24) <= days) {
                result.add(policyMap.get(entry.getValue()));
            }
        }
        return result;
    }

    public List<Policy> getPoliciesByHolder(String holder) {
        List<Policy> result = new ArrayList<>();
        for (Policy policy : policyMap.values()) {
            if (policy.policyHolder.equals(holder)) {
                result.add(policy);
            }
        }
        return result;
    }

    public void removeExpiredPolicies() {
        Date today = new Date();
        expirySortedPolicies.headMap(today).clear();
    }

    public static void main(String[] args) {
        InsurancePolicyManagement system = new InsurancePolicyManagement();
        system.addPolicy("P1", "ABC", new Date(2025 - 1900, 3, 15)); 
        system.addPolicy("P2", "XYZ", new Date(2024 - 1900, 2, 20)); 

        System.out.println("Expiring in next 30 days" + system.getExpiringPolicies(30));
    }
}
