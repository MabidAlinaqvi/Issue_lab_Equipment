package com.example.android.ee_lab_project.Model;

/**
 * Created by NO I.D on 11/9/2017.
 */

public class comp_listdataProvider {
private String com_name;
private String com_type;
private String com_stat;
private String com_quant;

public comp_listdataProvider(String com_name, String com_type, String com_stat, String com_quant) {
        this.com_name = com_name;
        this.com_type = com_type;
        this.com_stat = com_stat;
        this.com_quant = com_quant;
        }

public String getCom_name() {
        return com_name;
        }

public void setCom_name(String com_name) {
        this.com_name = com_name;
        }

public String getCom_type() {
        return com_type;
        }

public void setCom_type(String com_type) {
        this.com_type = com_type;
        }

public String getCom_stat() {
        return com_stat;
        }

public void setCom_stat(String com_stat) {
        this.com_stat = com_stat;
        }

public String getCom_quant() {
        return com_quant;
        }

public void setCom_quant(String com_quant) {
        this.com_quant = com_quant;
        }
        }
