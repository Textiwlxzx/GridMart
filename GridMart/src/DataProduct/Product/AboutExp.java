
package DataProduct.Product;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class AboutExp {
    
    public static int calDayLeftExp(String name, Date expDate) {
        Date currentDate = new Date();
        long diffInMillis = expDate.getTime() - currentDate.getTime();
        long diffInDays = TimeUnit.MILLISECONDS.toDays(diffInMillis);
        
        if (diffInDays > 0) {
            return (int) diffInDays;
        } else {
            return 0;
        }
    }
   
    public static int calDayLeftExp(String name, String expStr) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date exp = sdf.parse(expStr);
            return calDayLeftExp(name, exp);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public static boolean checkDayToNotify(ExpirationDate product) {
        int daysLeft = product.getDaysUntilExp();
        if (daysLeft <= 5 && daysLeft >= 0) {
            return true;
        }
        return false;
    }
}
