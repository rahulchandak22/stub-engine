public class PolicyEngineApp {
    public static void main(String[] args) {
        // Define rules
        Rule ageRule = new AgeRule(18);

        // Define policies
        Policy agePolicy = new AgeVerificationPolicy(Collections.singletonList(ageRule));

        // Register policies
        PolicySelector policySelector = new PolicySelector();
        policySelector.registerPolicy("membership", agePolicy);

        // Simulate user input
        UserInput userInput = new UserInput();
        userInput.put("age", 20);

        // Select and execute policy
        Policy policy = policySelector.getPolicy("membership");
        if (policy != null) {
            policy.execute(userInput);
        } else {
            System.out.println("No policy found for the product.");
        }
    }
}
