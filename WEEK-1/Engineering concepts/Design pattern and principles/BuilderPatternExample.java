public class BuilderPatternExample {
    static class Computer {
        private final String processor;
        private final int ram;
        private final int storage;
        private final boolean graphicsCard;
        private final boolean bluetooth;

        private Computer(Builder builder) {
            this.processor = builder.processor;
            this.ram = builder.ram;
            this.storage = builder.storage;
            this.graphicsCard = builder.graphicsCard;
            this.bluetooth = builder.bluetooth;
        }

        @Override
        public String toString() {
            return "Computer{" +
                    "processor='" + processor + '\'' +
                    ", ram=" + ram +
                    ", storage=" + storage +
                    ", graphicsCard=" + graphicsCard +
                    ", bluetooth=" + bluetooth +
                    '}';
        }

        static class Builder {
            private String processor;
            private int ram;
            private int storage;
            private boolean graphicsCard;
            private boolean bluetooth;

            public Builder withProcessor(String processor) {
                this.processor = processor;
                return this;
            }

            public Builder withRam(int ram) {
                this.ram = ram;
                return this;
            }

            public Builder withStorage(int storage) {
                this.storage = storage;
                return this;
            }

            public Builder withGraphicsCard(boolean graphicsCard) {
                this.graphicsCard = graphicsCard;
                return this;
            }

            public Builder withBluetooth(boolean bluetooth) {
                this.bluetooth = bluetooth;
                return this;
            }

            public Computer build() {
                return new Computer(this);
            }
        }
    }

    public static void main(String[] args) {
        Computer gamingPc = new Computer.Builder()
                .withProcessor("Intel i9")
                .withRam(32)
                .withStorage(1024)
                .withGraphicsCard(true)
                .withBluetooth(true)
                .build();

        System.out.println(gamingPc);
    }
}