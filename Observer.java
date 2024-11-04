import java.util.List;

// Observer interface for notifying users of new messages
interface UserObserver {
    void update(List<String> messages);
}

// Concrete User implementing the Observer interface
class User implements UserObserver {
    private final String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(List<String> messages) {
        System.out.println("\n" + name + "'s Chat View Updated:");
        for (String msg : messages) {
            System.out.println(msg);
        }
        System.out.println();
    }
}
