package api.payload;

public class FireFlinkPayload {
	private String emailId;
    private String password;
    private String lastSessionData;

    // Getters and setters

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastSessionData() {
        return lastSessionData;
    }

    public void setLastSessionData(String lastSessionData) {
        this.lastSessionData = lastSessionData;
    }
}
