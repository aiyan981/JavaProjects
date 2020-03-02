package com.example.user.mcalc;

public class MortgageModel {
    private double ppl;
    private int amort;
    private double ari;

    public MortgageModel(String p, String a, String i) {
        this.ppl = Double.parseDouble(p); //principle
        this.amort = Integer.parseInt(a); //amortization in years
        this.ari = Double.parseDouble(i); //annual interest rate in percent, e.g. 5.5
    }

    public String computePayment() {
        double r = this.ari/1200; //monthly interest rate
        int n = this.amort * 12;  //amortization months

        //the monthly payment calculation
        double mMP = (r * this.ppl) / (1 - Math.pow((1+r),-n));
        String payment = String.format("$%.2f", mMP);
        payment = payment.substring(0,2) + "," + payment.substring(2);
        return payment;
    }

    public static void main(String[] args) {
        MortgageModel myModel = new MortgageModel("700000", "25", "2.75");
        System.out.println(myModel.computePayment());

        myModel = new MortgageModel("300000", "20", "4.50");
        System.out.println(myModel.computePayment());
    }
}
