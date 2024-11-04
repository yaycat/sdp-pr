// Factory for creating messages based on type and user
public class MessageFactory {
    public static Message createMessage(String type, String user, String content) {
        switch (type) {
            case "user1":
                return new UserMessage("-", content);
            case "user2":
                return new UserMessage("--", content);
            case "user3":
                return new UserMessage("---", content);
            default:
                return new SystemMessage(content);
        }
    }
}
