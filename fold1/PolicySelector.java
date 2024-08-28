public class PolicySelector {
    private Map<String, Policy> policies;

    public PolicySelector() {
        this.policies = new HashMap<>();
    }

    public void registerPolicy(String product, Policy policy) {
        policies.put(product, policy);
    }

    public Policy getPolicy(String product) {
        return policies.get(product);
    }
}
