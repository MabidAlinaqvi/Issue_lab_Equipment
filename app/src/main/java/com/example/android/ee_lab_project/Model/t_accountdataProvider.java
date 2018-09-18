package com.example.android.ee_lab_project.Model;

/**
 * Created by NO I.D on 11/9/2017.
 */

public class t_accountdataProvider {
private String s_name;
private String comp_name;
private String issue_date;
private String due_date;
    public t_accountdataProvider(String s_name, String comp_name, String issue_date, String due_date) {
        this.comp_name = comp_name;
        this.issue_date = issue_date;
        this.due_date = due_date;
        this.s_name = s_name;
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

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }
}
