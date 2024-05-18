package ch3;

import java.time.LocalDate;

public class PayData {
    private LocalDate firstBilingDate;

    private LocalDate bilingDate;
    private int payAmount;

    private PayData(){}

    public PayData(LocalDate firstBilingDate,LocalDate bilingDate, int payAmount) {
        this.bilingDate = bilingDate;
        this.payAmount = payAmount;
        this.firstBilingDate = firstBilingDate;
    }

    public LocalDate getFirstBilingDate() {
        return firstBilingDate;
    }

    public LocalDate getBilingDate() {
        return bilingDate;
    }

    public int getPayAmount() {
        return payAmount;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{
        private PayData payData = new PayData();

        public Builder bilingDate(LocalDate bilingDate){
            payData.bilingDate = bilingDate;
            return  this;
        }

        public Builder payAmount(int payAmount){
            payData.payAmount = payAmount;
            return  this;
        }

        public Builder firstBilingDate(LocalDate firstBilingDate){
            payData.firstBilingDate = firstBilingDate;
            return this;
        }

        public PayData build(){
            return payData;
        }
    }

}
