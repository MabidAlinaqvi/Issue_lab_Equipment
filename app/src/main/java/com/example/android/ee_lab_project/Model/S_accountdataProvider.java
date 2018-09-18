package com.example.android.ee_lab_project.Model;

/**
 * Created by NO I.D on 11/9/2017.
 */

public class S_accountdataProvider {
private String comp_name;
private String issue_date;
private String due_date;
    public S_accountdataProvider(String comp_name, String issue_date, String due_date) {
        this.comp_name = comp_name;
        this.issue_date = issue_date;
        this.due_date = due_date;
    }

    public String getComp_name() {
        return comp_name;
    }

    public void setComp_name(String comp_name) {
        this.comp_name = comp_name;
    }

    public String getIssue_date() {
        return issue_date;
    }

    public void setIssue_date(String issue_date) {
        this.issue_date = issue_date;
    }

    public String getDue_date() {
        return due_date;
    }

    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }



}
