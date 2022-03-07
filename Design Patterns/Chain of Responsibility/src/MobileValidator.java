public class MobileValidator extends Validator {

    @Override
    public void process(User user) {
        String mob = user.getMobile();
        if (mob.matches("(\\+?(94)|0)\\d{9}")) {
            System.out.println("Mobile Validation Complete.");
            validator.process(user);
        } else {
            System.out.println("Mobile Validation Failed. " +
                    "Make sure the mobile number follows " +
                    "one of the following Sri Lankan formats:");
            System.out.println("[ 0XX XXXXXXX ] or [ +94 XXXXXXXXX ] or [ 94 XXXXXXXXX ]");
        }
    }
}
