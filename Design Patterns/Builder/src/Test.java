public class Test {
    public static void main(String[] args) {

        Computer.Builder builder1 = new Computer.Builder("Acer", "Nitro 50");
        Computer pc1 = builder1.setCustomRAM("64 GB")
                .setWarranty("5 Years")
                .build();

        Computer.Builder builder2 = new Computer.Builder("Dell", "Alienware");
        Computer pc2 = builder2.setCustomRAM("64 GB")
                .setCustomCPU("Intel Core i9 12900K")
                .setCustomGPU("Nvidia RTX 3080")
                .setWarranty("5 Years")
                .build();

        Computer.Builder builder3 = new Computer.Builder("Dell", "XPS");
        Computer pc3 = builder3.build();

        System.out.println(pc1);
        System.out.println(pc2);
        System.out.println(pc3);
    }
}
