public class UserInput {
    private Map<String, Object> data;

    public UserInput() {
        this.data = new HashMap<>();
    }

    public void put(String key, Object value) {
        data.put(key, value);
    }

    public Object get(String key) {
        return data.get(key);
    }

    // Additional methods as needed
}
