public class AgeRule implements Rule {
    private int minAge;

    public AgeRule(int minAge) {
        this.minAge = minAge;
    }

    @Override
    public boolean apply(UserInput userInput) {
        Integer age = (Integer) userInput.get("age");
        return age != null && age >= minAge;
    }
}
