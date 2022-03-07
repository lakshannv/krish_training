public class Test {
    public static void main(String[] args) {

        User user = new User("Lakshan");
        user.setMobile("0772351295");
        user.setPassword("GnsYY23vv33fh".toCharArray());
        user.setEmail("lakshannv@gmail.com");

        //Instantiating Handlers
        MobileValidator mobileValidator = new MobileValidator();
        PasswordValidator passwordValidator = new PasswordValidator();
        EmailValidator emailValidator = new EmailValidator();

        //Making the chain of responsibility
        mobileValidator.setNext(passwordValidator);
        passwordValidator.setNext(emailValidator);

        //Starting the chain of responsibility
        mobileValidator.process(user);
    }
}
