package com.example.android.ee_lab_project.Model;

/**
 * Created by NO I.D on 11/9/2017.
 */

public class issue_data_provider {
private String user;
private String message;
private String status;
    public issue_data_provider(String user, String message, String status) {
        this.user = user;
        this.message = message;
        this.status=status;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
