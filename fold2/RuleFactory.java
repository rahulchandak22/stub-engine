import org.json.JSONObject;

public class RuleFactory {
    public static Rule createRule(JSONObject ruleJson) {
        String type = ruleJson.getString("type");
        switch (type) {
            case "AgeRule":
                return new AgeRule(ruleJson.getInt("minAge"));
            // Add cases for other rule types
            default:
                throw new IllegalArgumentException("Unknown rule type: " + type);
        }
    }
}
