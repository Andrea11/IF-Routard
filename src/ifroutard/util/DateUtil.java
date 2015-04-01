/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifroutard.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author aaccardo
 */
public class DateUtil {

    public static Date toTime(String str) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM HH:mm");

        try {
            java.util.Date date = formatter.parse(str);
            return date;

        } catch (ParseException e) {
            return null;
        }
    }

public static Date toDate(String str) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        try {
            java.util.Date date = formatter.parse(str);
            return date;

        } catch (ParseException e) {
            return null;
        }
    }

    public static String displayDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(date);

    }

    public static String displayTime(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM HH:mm");
        return dateFormat.format(date);

    }

}
