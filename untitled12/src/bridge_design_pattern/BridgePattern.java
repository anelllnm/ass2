package bridge_design_pattern;

// Abstraction - Represents a TV
abstract class TV {
    Remote remote;

    // Constructor to set the remote type
    TV(Remote r) {
        this.remote = r;
    }

    // Abstract methods to be implemented by concrete TV types
    abstract void on();
    abstract void off();
}

// Concrete TV class - Sony
class Sony extends TV {
    Remote remoteType;

    Sony(Remote r) {
        super(r);
        this.remoteType = r;
    }

    @Override
    public void on() {
        System.out.print("Sony TV ON: ");
        remoteType.on(); // Delegates the 'on' operation to the specific remote type
    }

    @Override
    public void off() {
        System.out.print("Sony TV OFF: ");
        remoteType.off(); // Delegates the 'off' operation to the specific remote type
    }
}

// Concrete TV class - Philips
class Philips extends TV {
    Remote remoteType;

    Philips(Remote r) {
        super(r);
        this.remoteType = r;
    }

    @Override
    public void on() {
        System.out.print("Philips TV ON: ");
        remoteType.on(); // Delegates the 'on' operation to the specific remote type
    }

    @Override
    public void off() {
        System.out.print("Philips TV OFF: ");
        remoteType.off(); // Delegates the 'off' operation to the specific remote type
    }
}

// Interface for remote control
interface Remote {
    void on();  // Turn on the TV
    void off(); // Turn off the TV
}

// Concrete implementation of old remote
class OldRemote implements Remote {
    @Override
    public void on() {
        System.out.println("ON with Old Remote");
    }

    @Override
    public void off() {
        System.out.println("OFF with Old Remote");
    }
}

// Concrete implementation of new remote
class NewRemote implements Remote {
    @Override
    public void on() {
        System.out.println("ON with New Remote");
    }

    @Override
    public void off() {
        System.out.println("OFF with New Remote");
    }
}

public class BridgePattern {
    public static void main(String[] args) {
        // Creating instances of different TVs with different remotes
        TV sonyOldRemote = new Sony(new OldRemote());
        sonyOldRemote.on();
        sonyOldRemote.off();
        System.out.println();

        TV sonyNewRemote = new Sony(new NewRemote());
        sonyNewRemote.on();
        sonyNewRemote.off();
        System.out.println();

        TV philipsOldRemote = new Philips(new OldRemote());
        philipsOldRemote.on();
        philipsOldRemote.off();
        System.out.println();

        TV philipsNewRemote = new Philips(new NewRemote());
        philipsNewRemote.on();
        philipsNewRemote.off();
    }
}
