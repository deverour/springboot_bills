package deverour.domain;

import java.util.Arrays;

public class RequestData {

    private String[] titles;
    private String paystartyear;
    private String paystartmonth;
    private String payendyear;
    private String payendmonth;
    private String fentanstartyear;
    private String fentanstartmonth;
    private String fentanendyear;
    private String fentanendmonth;
    private String fengongsi;
    private String kehu;
    private String jiesuanmoshi;

    public String[] getTitles() {
        return titles;
    }

    public void setTitles(String[] titles) {
        this.titles = titles;
    }

    public String getPaystartyear() {
        return paystartyear;
    }

    public void setPaystartyear(String paystartyear) {
        this.paystartyear = paystartyear;
    }

    public String getPaystartmonth() {
        return paystartmonth;
    }

    public void setPaystartmonth(String paystartmonth) {
        this.paystartmonth = paystartmonth;
    }

    public String getPayendyear() {
        return payendyear;
    }

    public void setPayendyear(String payendyear) {
        this.payendyear = payendyear;
    }

    public String getPayendmonth() {
        return payendmonth;
    }

    public void setPayendmonth(String payendmonth) {
        this.payendmonth = payendmonth;
    }

    public String getFentanstartyear() {
        return fentanstartyear;
    }

    public void setFentanstartyear(String fentanstartyear) {
        this.fentanstartyear = fentanstartyear;
    }

    public String getFentanstartmonth() {
        return fentanstartmonth;
    }

    public void setFentanstartmonth(String fentanstartmonth) {
        this.fentanstartmonth = fentanstartmonth;
    }

    public String getFentanendyear() {
        return fentanendyear;
    }

    public void setFentanendyear(String fentanendyear) {
        this.fentanendyear = fentanendyear;
    }

    public String getFentanendmonth() {
        return fentanendmonth;
    }

    public void setFentanendmonth(String fentanendmonth) {
        this.fentanendmonth = fentanendmonth;
    }

    public String getFengongsi() {
        return fengongsi;
    }

    public void setFengongsi(String fengongsi) {
        this.fengongsi = fengongsi;
    }

    public String getKehu() {
        return kehu;
    }

    public void setKehu(String kehu) {
        this.kehu = kehu;
    }

    public String getJiesuanmoshi() {
        return jiesuanmoshi;
    }

    public void setJiesuanmoshi(String jiesuanmoshi) {
        this.jiesuanmoshi = jiesuanmoshi;
    }

    @Override
    public String toString() {
        return "RequestData{" +
                "titles=" + Arrays.toString(titles) +
                ", paystartyear='" + paystartyear + '\'' +
                ", paystartmonth='" + paystartmonth + '\'' +
                ", payendyear='" + payendyear + '\'' +
                ", payendmonth='" + payendmonth + '\'' +
                ", fentanstartyear='" + fentanstartyear + '\'' +
                ", fentanstartmonth='" + fentanstartmonth + '\'' +
                ", fentanendyear='" + fentanendyear + '\'' +
                ", fentanendmonth='" + fentanendmonth + '\'' +
                ", fengongsi='" + fengongsi + '\'' +
                ", kehu='" + kehu + '\'' +
                ", jiesuanmoshi='" + jiesuanmoshi + '\'' +
                '}';
    }
}