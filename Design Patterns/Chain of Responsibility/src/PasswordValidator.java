public class PasswordValidator extends Validator {

    @Override
    public void process(User user) {
        if (user.getPassword().length < 8) {
            System.out.println("Password Validation Failed. The password must contain at least 8 characters.");
        } else {
            boolean uppcaseFound = false;
            boolean lowercaseFound = false;
            boolean digitFound = false;
            for (char c : user.getPassword()) {
                if (Character.isDigit(c)) {
                    digitFound = true;
                } else if (Character.isLowerCase(c)) {
                    lowercaseFound = true;
                } else if (Character.isUpperCase(c)) {
                    uppcaseFound = true;
                }
                if (digitFound && lowercaseFound && uppcaseFound) {
                    System.out.println("Password Validation Complete.");
                    validator.process(user);
                    return;
                }
            }
            System.out.println("Password Validation Failed. The password must contain a mixture of lowercase & uppercase letters and numbers.");
        }
    }
}
