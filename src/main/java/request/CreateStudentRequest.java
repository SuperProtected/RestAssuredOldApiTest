package request;

public class CreateStudentRequest {

    public String name = "W" + System.currentTimeMillis();
    public String email = String.format("W.com@gmail.com", System.currentTimeMillis());
    public String office = "W";
    public String mentor = "W";
    public String signed_up = "2023-11-02T07:44:47.152Z";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getMentor() {
        return mentor;
    }

    public void setMentor(String mentor) {
        this.mentor = mentor;
    }

    public String getSigned_up() {
        return signed_up;
    }

    public void setSigned_up(String signed_up) {
        this.signed_up = signed_up;
    }
}
