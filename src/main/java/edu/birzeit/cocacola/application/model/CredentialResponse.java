package edu.birzeit.cocacola.application.model;

public class CredentialResponse {
    private String note;
    private User user;

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
