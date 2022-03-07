public abstract class Validator {
    protected Validator validator;

    public void setNext(Validator validator) {
        this.validator = validator;
    }

    public abstract void process(User user);
}
