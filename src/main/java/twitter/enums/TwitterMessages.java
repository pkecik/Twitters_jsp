package twitter.enums;

public enum TwitterMessages {

    TWITT_ADDED("new twitt was added");

    private String value;

    public String getValue() {
        return value;
    }

    TwitterMessages(String value) {
        this.value = value;
    }
}
