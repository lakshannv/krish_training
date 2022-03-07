public class Test {

    public static void main(String[] args) {
        Dog prototypeDog = new Dog("Siberian Husky", "White", 12, 0.5);

        CloningMachine cloningMachine = new CloningMachine();
        cloningMachine.setPrototype(prototypeDog);

        Dog clonedDog1 = cloningMachine.produceClone();
        clonedDog1.setBreed("German Shepherd");

        Dog clonedDog2 = cloningMachine.produceClone();

        System.out.println(prototypeDog);
        System.out.println(clonedDog1);
        System.out.println(clonedDog2);
    }
}
