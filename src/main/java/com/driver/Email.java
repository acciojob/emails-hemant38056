package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }


    public static boolean isValid(String input){
        int integerCount = 0;
        int upperCaseCount = 0;
        int lowerCaseCount = 0;
        int specialCaseCount = 0;

        if(input.length() < 8){
            return false;
        }
        for(int i = 0; i < input.length(); i++){
            char temp = input.charAt(i);
            if(temp >= '0' && temp <= '9'){
                integerCount++;
            }
            else if(temp >= 'a' && temp <= 'z'){
                lowerCaseCount++;
            }
            else if(temp >= 'A' && temp <= 'Z'){
                upperCaseCount++;
            }
            else{
                specialCaseCount++;
            }
        }
        if(integerCount == 0 || upperCaseCount == 0 || lowerCaseCount == 0 || specialCaseCount == 0){
            return false;
        }
        return true;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character

        boolean isNewValid = isValid(newPassword);
        if(this.password.equals(oldPassword) && isNewValid) {
            this.password = newPassword;
        }
    }
}
