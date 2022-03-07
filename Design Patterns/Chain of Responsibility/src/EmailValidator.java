public class EmailValidator extends Validator {

    private static final String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    @Override
    public void process(User user) {
        if (user.getEmail().matches(EMAIL_REGEX)) {
            System.out.println("Email Validation Complete.");
            System.out.println("Validation Process is successful for the user : " + user.getName());
        } else {
            System.out.println("Email Validation Failed.");
        }
    }
}
