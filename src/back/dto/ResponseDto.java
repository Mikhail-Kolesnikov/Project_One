package back.dto;

public class ResponseDto <T> {

    private int responseCode;
    // 200 -OK
    // 400 - user error
    // 404 - not found
    // ...

    private T responseBody;

    private String responseMessage;
    // запись прошла успешно
    // таких данных в коллекции нет


    public ResponseDto(int responseCode, T responseBody, String responseMessage) {
        this.responseCode = responseCode;
        this.responseBody = responseBody;
        this.responseMessage = responseMessage;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public T getResponseBody() {
        return responseBody;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    @Override
    public String toString() {
        return "ResponseDto{" +
                "responseCode=" + responseCode +
                ", responseBody=" + responseBody +
                ", responseMessage='" + responseMessage + '\'' +
                '}';
    }
}
