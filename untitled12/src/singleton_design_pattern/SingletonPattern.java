package singleton_design_pattern;

// Singleton using Eager Initialization
class SingletonEagar
{
    // Instance is eagerly initialized when the class is loaded.
    private static SingletonEagar instance = new SingletonEagar(); // Eager initialization of the instance

    private SingletonEagar()
    {
        // Private constructor to prevent instantiation from outside
    }

    // Public method to provide access to the unique instance of the class.
    public static SingletonEagar getInstance()
    {
        return instance;
    }
}

// Singleton using Lazy Initialization (not thread-safe)
class Singleton
{
    private static Singleton instance; // Declaration of instance variable, not initialized

    private Singleton()
    {
        // Private constructor to prevent instantiation from outside
    }

    // Public method to provide access to the unique instance of the class.
    public static Singleton getInstance()
    {
        if(instance == null) // Check if instance is not initialized yet
        {
            instance = new Singleton(); // Initialize the instance if it's null
        }
        return instance;
    }
}

// Singleton using Lazy Initialization with synchronized method (thread-safe)
class SingletonSynchronizedMethod
{
    private static SingletonSynchronizedMethod instance; // Declaration of instance variable, not initialized

    private SingletonSynchronizedMethod()
    {
        // Private constructor to prevent instantiation from outside
    }

    // Public method to provide access to the unique instance of the class.
    public static synchronized SingletonSynchronizedMethod getInstance()
    {
        if(instance == null) // Check if instance is not initialized yet
        {
            instance = new SingletonSynchronizedMethod(); // Initialize the instance if it's null
        }
        return instance;
    }
}

// Singleton using Lazy Initialization with double-checked locking (thread-safe)
class SingletonSynchronized
{
    private static SingletonSynchronized instance; // Declaration of instance variable, not initialized

    private SingletonSynchronized()
    {
        // Private constructor to prevent instantiation from outside
    }

    // Public method to provide access to the unique instance of the class.
    public static SingletonSynchronized getInstance()
    {
        if(instance == null) // First check (non-synchronized)
        {
            synchronized (SingletonSynchronized.class) // Synchronized block to ensure thread safety
            {
                if(instance == null) // Second check (synchronized)
                {
                    instance = new SingletonSynchronized(); // Initialize the instance if it's null
                }
            }
        }
        return instance;
    }
}

public class SingletonPattern
{
    public static void main(String[] args)
    {
        SingletonSynchronized instance = SingletonSynchronized.getInstance();
        System.out.println(instance); // Print the instance's memory address
        SingletonSynchronized instance1 = SingletonSynchronized.getInstance();
        System.out.println(instance1); // Print the instance's memory address (same as above)
    }
}
