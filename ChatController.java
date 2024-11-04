import java.util.Scanner;

public class ChatController {
    private final ChatModel model;
    private final ChatView view;
    private final LoginStrategy loginStrategy;

    public ChatController() {
        model = ChatModel.getInstance();
        view = new ChatView();
        loginStrategy = new StandardLogin(model);
    }

    public void login() {
        view.clearScreen(); // Clear screen for a fresh session
        view.showLoginPrompt();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        if (loginStrategy.login(username, password)) {
            view.showLoginSuccess(username);
            model.addObserver(new User(username)); // Add observer for logged-in user
            chatSession(username);
        } else {
            view.showLoginFailure();
        }
    }

    private void chatSession(String username) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            view.showMessages(model.getMessages()); // Display only chat history
            view.showMessagePrompt();
            String messageContent = scanner.nextLine();

            if (messageContent.equalsIgnoreCase("logout")) {
                model.logout();
                view.showLogoutSuccess();
                view.clearScreen(); // Clear screen after logout to simulate fresh start
                break;
            } else {
                Message message = MessageFactory.createMessage(username, username, messageContent);
                model.addMessage(message);
            }
        }
    }

    public static void main(String[] args) {
        ChatController controller = new ChatController();
        while (true) {
            controller.login();
        }
    }
}
