package com.saifi369.firebaseauthapp;

import java.util.regex.Pattern;

public class Utils {

    public static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^"
                    + "(?=.*[0-9])"                  //minimum one number
                    + "(?=.*[a-z])"                  //minimum one lower case character
                    + "(?=.*[A-Z])"                  //minimum one UPPER case character
                    + "(?=.*[a-zA-Z])"               //any character
                    + "(?=.*[@#$%^&+=])"             //minimum one special character
                    + "(?=\\S+$)"                    //no white spaces
                    + ".{6,}"                        //minimum length 6 characters
                    + "$");

    public static final Pattern PASSWORD_UPPERCASE_PATTERN =
            Pattern.compile("(?=.*[A-Z])" + ".{0,}");

    public static final Pattern PASSWORD_LOWERCASE_PATTERN =
            Pattern.compile("(?=.*[a-z])" + ".{0,}");

    public static final Pattern PASSWORD_NUMBER_PATTERN =
            Pattern.compile("(?=.*[0-9])" + ".{0,}");

    public static final Pattern PASSWORD_SPECIAL_CHARACTER_PATTERN =
            Pattern.compile("(?=.*[@#$%^&+=])" + ".{0,}");


}
