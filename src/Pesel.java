import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Piotrek on 2017-03-26.
 */
public class Pesel {
    static boolean isPeselValid(String userPesel) {

        if (userPesel.length() != 11) {
            return false;
        }

        int[] numbers = new int[11];

        int i = 0;
        try {
            for (String c : userPesel.split("")) {
                numbers[i] = Integer.parseInt(c);
                i++;
            }
        }
        catch (NumberFormatException e){
            return false;
        }

        int[] test = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3};
        int validate = 0;

        for (i=0;i<test.length;i++){
            validate += test[i]*numbers[i];
        }

        validate = validate%10;
        validate = 10 - validate;
        int month = numbers[2]%2 * 10 + numbers[3];

        return (((validate % 10) == numbers[10]) && month < 13);
    }


    static String getBirthDate(String userPesel) {

        int[] numbers = new int[11];

        int i = 0;
        for (String c : userPesel.split("")) {
            numbers[i] = Integer.parseInt(c);
            i++;
        }

        int year = 1900 + numbers[0] * 10 + numbers[1];
        if (numbers[2] >= 2 && numbers[2] < 8){
            year += numbers[2]/2 * 100;
        }
        if (numbers[2] >= 8){
            year -= 100;
        }

        int month = (numbers[2]%2) * 10 + numbers[3] - 1;
        int day = numbers[4] * 10 + numbers[5];
        Calendar c = Calendar.getInstance();
        c.set(year, month, day, 0, 0);
        SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy");

        return format1.format(c.getTime());
    }
    static String getSex (String userPesel) {

        int sexNumber = Integer.parseInt(userPesel.substring(9,10));

        return (sexNumber%2 == 0) ? "kobieta" : "meżczyzna";
    }
}
