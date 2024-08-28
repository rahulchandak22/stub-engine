import org.json.JSONObject;
import org.json.JSONTokener;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class ConfigurationLoader {
    private Map<String, Policy> policies;

    public ConfigurationLoader(String configFile) {
        this.policies = new HashMap<>();
        loadConfiguration(configFile);
    }

    private void loadConfiguration(String configFile) {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(configFile)) {
            if (inputStream == null) {
                throw new RuntimeException("Configuration file not found: " + configFile);
            }
            JSONTokener tokener = new JSONTokener(inputStream);
            JSONObject root = new JSONObject(tokener);

            for (String key : root.keySet()) {
                JSONObject policyJson = root.getJSONObject(key);
                Policy policy = PolicyFactory.createPolicy(policyJson);
                policies.put(key, policy);
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to load configuration", e);
        }
    }

    public Policy getPolicy(String product) {
        return policies.get(product);
    }
}
