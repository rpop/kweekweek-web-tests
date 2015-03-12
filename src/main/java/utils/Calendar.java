package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by vlad.tamas on 3/5/2015.
 */
public class Calendar {
    private static Date currentDate;
    private static SimpleDateFormat dft = new SimpleDateFormat("dd/MM/yyyy");

    public static String getCurrentDate() {
        currentDate = new Date();
        return dft.format(currentDate);
    }
}