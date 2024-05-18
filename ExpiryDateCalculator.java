package ch3;

import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;

public class ExpiryDateCalculator {

    public LocalDate calculateExpiryDate(PayData payData) {
        int addedMonths = payData.getPayAmount()==100_000?12: payData.getPayAmount()/ 10_000;
        if (payData.getFirstBilingDate() != null) {
          return expiryDateUsingFirstBilingDate(payData,addedMonths);
        } else {
            return payData.getBilingDate().plusMonths(addedMonths);
        }
    }


    private LocalDate expiryDateUsingFirstBilingDate(PayData payData,int addedMonths) {
        LocalDate candidateExp = payData.getBilingDate().plusMonths(addedMonths);
        final int dayOfFirstbilling = payData.getFirstBilingDate().getDayOfMonth();
        if (isSameDayOfMonth(dayOfFirstbilling,candidateExp)) {
            final int dayLenOfCandiMon = lastDayOfMonth(candidateExp);
            if (dayLenOfCandiMon < payData.getFirstBilingDate().getDayOfMonth()) {
                return candidateExp.withDayOfMonth(dayLenOfCandiMon);
            }
            return candidateExp.withDayOfMonth(dayOfFirstbilling);
        }else {
            return candidateExp;
        }
    }

    private boolean isSameDayOfMonth(int date1, LocalDate date2) {
        return date1!=date2.getDayOfMonth()?true:false;
    }
    private  int lastDayOfMonth(LocalDate date) {
        return YearMonth.from(date).lengthOfMonth();
    }
}
