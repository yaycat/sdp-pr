// Factory for creating messages based on type and user
public class MessageFactory {
    public static Message createMessage(String type, String user, String content) {
        switch (type) {
            case "Nurda":
                return new UserMessage("Nurda: ", content);
            case "Alimzh":
                return new UserMessage("Alimzh: ", content);
            case "Kadyr":
                return new UserMessage("Kadyr: ", content);
            default:
                return new SystemMessage(content);
        }
    }
}
