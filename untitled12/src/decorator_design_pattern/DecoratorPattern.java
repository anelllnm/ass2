package decorator_design_pattern;

// Interface representing a dress
interface Dress {
    public void assemble(); // Method to assemble the dress
}

// Concrete class representing a basic dress
class BasicDress implements Dress {
    @Override
    public void assemble() {
        System.out.println("Basic Dress Features");
    }
}

// Abstract decorator class for dresses
class DressDecorator implements Dress {
    protected Dress dress; // Reference to the dress being decorated

    public DressDecorator(Dress c) {
        this.dress = c;
    }

    @Override
    public void assemble() {
        this.dress.assemble(); // Delegates the assemble operation to the decorated dress
    }
}

// Concrete decorator class for adding casual features to a dress
class CasualDress extends DressDecorator {
    public CasualDress(Dress c) {
        super(c);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Adding Casual Dress Features");
    }
}

// Concrete decorator class for adding sporty features to a dress
class SportyDress extends DressDecorator {
    public SportyDress(Dress c) {
        super(c);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Adding Sporty Dress Features");
    }
}

// Concrete decorator class for adding fancy features to a dress
class FancyDress extends DressDecorator {
    public FancyDress(Dress c) {
        super(c);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Adding Fancy Dress Features");
    }
}

public class DecoratorPattern {
    public static void main(String[] args) {
        // Creating different dress combinations
        Dress sportyDress = new SportyDress(new BasicDress());
        sportyDress.assemble();
        System.out.println();

        Dress fancyDress = new FancyDress(new BasicDress());
        fancyDress.assemble();
        System.out.println();

        Dress casualDress = new CasualDress(new BasicDress());
        casualDress.assemble();
        System.out.println();

        Dress sportyFancyDress = new SportyDress(new FancyDress(new BasicDress()));
        sportyFancyDress.assemble();
        System.out.println();

        Dress casualFancyDress = new CasualDress(new FancyDress(new BasicDress()));
        casualFancyDress.assemble();
    }
}
