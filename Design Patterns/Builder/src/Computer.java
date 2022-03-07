public class Computer {

    private final String brand;
    private final String model;
    private final String customCPU;
    private final String customGPU;
    private final String customRAM;
    private final String warranty;

    public static class Builder {

        private final String brand;
        private final String model;
        private String customCPU;
        private String customGPU;
        private String customRAM;
        private String warranty;

        public Builder(String brand, String model) {
            this.brand = brand;
            this.model = model;
        }

        public Builder setCustomCPU(String customCPU) {
            this.customCPU = customCPU;
            return this;
        }

        public Builder setCustomGPU(String customGPU) {
            this.customGPU = customGPU;
            return this;
        }

        public Builder setCustomRAM(String customRAM) {
            this.customRAM = customRAM;
            return this;
        }

        public Builder setWarranty(String warranty) {
            this.warranty = warranty;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }

    private Computer(Builder builder) {
        this.brand = builder.brand;
        this.model = builder.model;
        this.customCPU = builder.customCPU;
        this.customGPU = builder.customGPU;
        this.customRAM = builder.customRAM;
        this.warranty = builder.warranty;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getCustomCPU() {
        return customCPU;
    }

    public String getCustomGPU() {
        return customGPU;
    }

    public String getCustomRAM() {
        return customRAM;
    }

    public String getWarranty() {
        return warranty;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", customCPU='" + customCPU + '\'' +
                ", customGPU='" + customGPU + '\'' +
                ", customRAM='" + customRAM + '\'' +
                ", warranty='" + warranty + '\'' +
                '}';
    }
}
