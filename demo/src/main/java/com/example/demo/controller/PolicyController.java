import com.example.model.UserInput;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {

    @Autowired
    private DroolsConfig droolsConfig;

    @PostMapping("/execute")
    public String executePolicy(@RequestParam String productType, @RequestBody UserInput userInput) {
        KieSession kieSession = droolsConfig.getKieSession(productType);
        kieSession.insert(userInput);
        int firedRules = kieSession.fireAllRules();
        return "Rules executed. Number of rules fired: " + firedRules;
    }
}
