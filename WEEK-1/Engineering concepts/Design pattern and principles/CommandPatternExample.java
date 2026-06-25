import java.util.ArrayList;
import java.util.List;

public class CommandPatternExample {
    interface Command {
        void execute();
    }

    static class Light {
        public void turnOn() {
            System.out.println("Light is ON");
        }
        public void turnOff() {
            System.out.println("Light is OFF");
        }
    }

    static class TurnOnCommand implements Command {
        private final Light light;
        public TurnOnCommand(Light light) {
            this.light = light;
        }
        public void execute() {
            light.turnOn();
        }
    }

    static class TurnOffCommand implements Command {
        private final Light light;
        public TurnOffCommand(Light light) {
            this.light = light;
        }
        public void execute() {
            light.turnOff();
        }
    }

    static class RemoteControl {
        private final List<Command> history = new ArrayList<>();

        public void submit(Command command) {
            command.execute();
            history.add(command);
        }
    }

    public static void main(String[] args) {
        Light light = new Light();
        RemoteControl remote = new RemoteControl();

        remote.submit(new TurnOnCommand(light));
        remote.submit(new TurnOffCommand(light));
    }
}