package adapter_design_pattern;

// Interface for WebDriver
interface WebDriver
{
    public void getElement(); // Method to get element
    public void selectElement(); // Method to select element
}

// ChromeDriver implements the WebDriver interface
class ChromeDriver implements WebDriver
{
    @Override
    public void getElement()
    {
        System.out.println("Get element from ChromeDriver");
    }

    @Override
    public void selectElement()
    {
        System.out.println("Select element from ChromeDriver");
    }
}

// IEDriver class without implementing the WebDriver interface
class IEDriver
{
    public void findElement()
    {
        System.out.println("Find element from IEDriver");
    }

    public void clickElement()
    {
        System.out.println("Click element from IEDriver");
    }
}

// WebDriverAdapter implements the WebDriver interface and adapts IEDriver
class WebDriverAdapter implements WebDriver
{
    IEDriver ieDriver;

    // Constructor that takes an IEDriver object
    public WebDriverAdapter(IEDriver ieDriver)
    {
        this.ieDriver = ieDriver;
    }

    @Override
    public void getElement()
    {
        ieDriver.findElement(); // Calls IEDriver's findElement method
    }

    @Override
    public void selectElement()
    {
        ieDriver.clickElement(); // Calls IEDriver's clickElement method
    }
}

public class AdapterPattern
{
    public static void main(String[] args)
    {
        // Using ChromeDriver
        ChromeDriver a = new ChromeDriver();
        a.getElement();
        a.selectElement();

        // Using IEDriver directly
        IEDriver e = new IEDriver();
        e.findElement();
        e.clickElement();

        // Using WebDriverAdapter to adapt IEDriver to WebDriver interface
        WebDriver wID = new WebDriverAdapter(e);
        wID.getElement(); // Calls IEDriver's findElement method
        wID.selectElement(); // Calls IEDriver's clickElement method
    }
}
