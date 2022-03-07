public class CloningMachine {

    private Dog dog;

    public void setPrototype(Dog dog) {
        this.dog = dog;
    }

    public Dog produceClone() {
        if (dog == null) {
            throw new RuntimeException("Set the prototype first");
        } else {
            Dog clonedDog = null;
            try {
                clonedDog = (Dog) dog.clone();
            } catch (CloneNotSupportedException e) {
                System.out.println(e.getMessage());
            }
            return clonedDog;
        }
    }
}
