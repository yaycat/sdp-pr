// Strategy interface for different login methods
interface LoginStrategy {
    boolean login(String username, String password);
}

// Concrete StandardLogin strategy for regular login
class StandardLogin implements LoginStrategy {
    private final ChatModel model;

    public StandardLogin(ChatModel model) {
        this.model = model;
    }

    @Override
    public boolean login(String username, String password) {
        return model.login(username, password);
    }
}
