package com.limitip.mm.mark_movie.util;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyRegexUtil {

    public static Boolean cheakUserPsd(String str){
        String pattern = "^[A-Za-z0-9]{8,20}$";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        return m.matches();
    }

    public static void main(String args[]) {
        while (true) {
            Scanner cin = new Scanner(System.in);
            String str = cin.next();
            String pattern = "^[A-Za-z0-9]{8,20}$";
            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(str);
            System.out.println(m.matches());
        }

    }


}
