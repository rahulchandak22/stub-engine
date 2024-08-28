import org.json.JSONObject;
import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class PolicyFactory {
    public static Policy createPolicy(JSONObject policyJson) {
        JSONArray rulesArray = policyJson.getJSONArray("rules");
        List<Rule> rules = new ArrayList<>();
        for (int i = 0; i < rulesArray.length(); i++) {
            JSONObject ruleJson = rulesArray.getJSONObject(i);
            rules.add(RuleFactory.createRule(ruleJson));
        }
        return new AgeVerificationPolicy(rules);  // Adjust to return appropriate policy based on your needs
    }
}
