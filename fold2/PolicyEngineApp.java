public class PolicyEngineApp {
    public static void main(String[] args) {
        // Load policies from configuration file
        ConfigurationLoader configurationLoader = new ConfigurationLoader("policies.json");

        // Simulate user input
        UserInput userInput = new UserInput();
        userInput.put("age", 20);

        // Select and execute policy
        Policy policy = configurationLoader.getPolicy("membership");
        if (policy != null) {
            policy.execute(userInput);
        } else {
            System.out.println("No policy found for the product.");
        }
    }
}
