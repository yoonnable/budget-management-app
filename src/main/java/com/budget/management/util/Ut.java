package com.budget.management.util;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class Ut {
    public static class encrypt {
        public static String encryptPW(String password) {
            return BCrypt.withDefaults().hashToString(12, password.toCharArray());
        }

        public static BCrypt.Result verifyPW(String plainPassword ,String encryptPassword) {
            BCrypt.Result result = BCrypt.verifyer().verify(plainPassword.toCharArray(), encryptPassword);
            return result; // result.verified == true
        }
    }
}
