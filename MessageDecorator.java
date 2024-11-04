import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Decorator to add a timestamp to messages
public class MessageDecorator implements Message {
    private final Message originalMessage;

    public MessageDecorator(Message message) {
        this.originalMessage = message;
    }

    @Override
    public String getContent() {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        return "[" + timestamp + "] " + originalMessage.getContent();
    }
}
