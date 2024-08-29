package request;

public class SignUpRequest {
    public String username = "QQQQQQQQ"; //+ System.currentTimeMillis();
    public String password = "80808080";
    public String confirm_password = "80808080";

    public String getConfirm_password() {
        return confirm_password;
    }

    public void setConfirm_password(String confirm_password) {
        this.confirm_password = confirm_password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
