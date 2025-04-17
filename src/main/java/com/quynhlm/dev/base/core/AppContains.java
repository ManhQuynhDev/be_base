package com.quynhlm.dev.base.core;

public class AppContains {
    public static class UserAccountRegex {
        public static final String USERNAME = "^[a-zA-Z0-9._-]{3,}$";
        public static final String PHONE_NUMBER = "([\\+84|84|0]+(3|5|7|8|9|1[2|6|8|9]))+([0-9]{8})";
        public static final String DOB = "^(19|20)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|1\\d|2[0-8])$|^(19|20)([02468][048]|[13579][26])-02-29$";
        public static final String EMAIL = "^[a-zA-Z]+[a-zA-Z0-9._]*@[a-zA-Z]+(\\.[a-zA-Z]{2,})+$";
        public static final String STRONG_PASSWORD = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!*()]).{8,}$";
    }
}
