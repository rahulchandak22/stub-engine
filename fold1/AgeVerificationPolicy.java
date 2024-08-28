public class AgeVerificationPolicy implements Policy {
    private List<Rule> rules;

    public AgeVerificationPolicy(List<Rule> rules) {
        this.rules = rules;
    }

    @Override
    public void execute(UserInput userInput) {
        for (Rule rule : rules) {
            if (!rule.apply(userInput)) {
                System.out.println("Rule failed.");
                return;
            }
        }
        System.out.println("All rules passed.");
    }
}
