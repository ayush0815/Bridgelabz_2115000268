package RealLife;
import java.util.*;
public class VotingSystem {
    private Map<String, Integer> votes = new HashMap<>();
    private LinkedHashMap<String, Integer> voteOrder = new LinkedHashMap<>();
    private TreeMap<String, Integer> sortedResults = new TreeMap<>();

    public void castVote(String candidate) {
        votes.put(candidate, votes.getOrDefault(candidate, 0) + 1);
        voteOrder.put(candidate, votes.get(candidate));
        sortedResults.put(candidate, votes.get(candidate));
    }

    public void displayResults() {
        System.out.println("Results (Sorted by Candidate): " + sortedResults);
        System.out.println("Results (Order of Voting): " + voteOrder);
    }

    public static void main(String[] args) {
        VotingSystem system = new VotingSystem();
        system.castVote("Ayush");
        system.castVote("Vaibhav");
        system.castVote("Aditya");
        
        system.displayResults();
    }
}
