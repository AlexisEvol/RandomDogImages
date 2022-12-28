package POJOs;

public class ImageObject {
    private String message;
    private String status;

    public ImageObject(String message, String status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }
}
