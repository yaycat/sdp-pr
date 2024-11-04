import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChatModel {
    private static ChatModel instance;
    private final List<String> messages;
    private final Map<String, String> users;
    private final List<UserObserver> observers; // List of observers to notify

    private String loggedInUser;

    private ChatModel() {
        messages = new ArrayList<>();
        users = new HashMap<>();
        observers = new ArrayList<>();
        users.put("user1", "password1");
        users.put("user2", "password2");
        users.put("user3", "password3");
    }

    public static ChatModel getInstance() {
        if (instance == null) {
            instance = new ChatModel();
        }
        return instance;
    }

    public boolean login(String username, String password) {
        if (users.containsKey(username) && users.get(username).equals(password)) {
            loggedInUser = username;
            notifyObservers();
            return true;
        }
        return false;
    }

    public void logout() {
        loggedInUser = null;
        notifyObservers();
    }

    public void addMessage(Message message) {
        Message decoratedMessage = new MessageDecorator(message); // Decorate message with timestamp
        messages.add(decoratedMessage.getContent());
        notifyObservers();
    }

    public List<String> getMessages() {
        return messages;
    }

    public void addObserver(UserObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers() {
        for (UserObserver observer : observers) {
            observer.update(messages);
        }
    }
}
