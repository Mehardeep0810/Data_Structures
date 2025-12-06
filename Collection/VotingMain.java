package Assignment.Collection;

public class VotingMain {
    public static void main(String[] args) {
        ElectionSystem voting = new ElectionSystem();

        voting.castVote("Alice");
        voting.castVote("Bob");
        voting.castVote("Alice");
        voting.castVote("Charlie");

        voting.displayResults();
    }
}

