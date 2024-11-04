import java.util.List;

public class ChatView {

    public void showLoginPrompt() {
        System.out.println("Enter username and password to log in.");
    }

    public void showMessagePrompt() {
        System.out.println("Enter a message (or type 'logout' to exit):");
    }

    // Display only the chat history when a user logs in
    public void showMessages(List<String> messages) {
        System.out.println("\nChat History:");
        for (String msg : messages) {
            System.out.println(msg);
        }
        System.out.println();
    }

    // Display a message indicating successful logout
    public void showLogoutSuccess() {
        System.out.println("You have successfully logged out.");
    }

    public void showLoginSuccess(String username) {
        System.out.println("Welcome, " + username + "!");
    }

    public void showLoginFailure() {
        System.out.println("Invalid credentials. Please try again.");
    }

    // Method to clear the screen by adding blank lines
    public void clearScreen() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}
