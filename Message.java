// Message interface for different types of messages
public interface Message {
    String getContent();
}

// Concrete UserMessage with a prefix to indicate the sender
class UserMessage implements Message {
    private final String prefix;
    private final String content;

    public UserMessage(String prefix, String content) {
        this.prefix = prefix;
        this.content = content;
    }

    @Override
    public String getContent() {
        return prefix + " " + content;
    }
}

// Concrete SystemMessage to display system-related notifications
class SystemMessage implements Message {
    private final String content;

    public SystemMessage(String content) {
        this.content = content;
    }

    @Override
    public String getContent() {
        return "* " + content;
    }
}
