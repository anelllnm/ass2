package proxy_design_pattern;

// Interface for DatabaseExecuter
interface DatabaseExecuter
{
    public void executeDatabase(String query) throws Exception;
}

// Implementation of DatabaseExecuter
class DatabaseExecuterImpl implements DatabaseExecuter
{
    @Override
    public void executeDatabase(String query) throws Exception
    {
        System.out.println("Going to execute Query: " + query);
    }
}

// Proxy class for DatabaseExecuter
class DatabaseExecuterProxy implements DatabaseExecuter
{
    boolean ifAdmin;
    DatabaseExecuterImpl dbExecuter;

    // Constructor with authentication check
    public DatabaseExecuterProxy(String name, String passwd)
    {
        if(name.equals("Admin") && passwd.equals("Admin@123"))
        {
            ifAdmin = true;
        }
        dbExecuter = new DatabaseExecuterImpl();
    }

    @Override
    public void executeDatabase(String query) throws Exception
    {
        if(ifAdmin)
        {
            dbExecuter.executeDatabase(query);
        }
        else
        {
            if(query.equals("DELETE"))
            {
                throw new Exception("DELETE not allowed for non-admin user");
            }
            else
            {
                dbExecuter.executeDatabase(query);
            }
        }
    }
}

public class ProxyPattern
{
    public static void main(String[] args) throws Exception
    {
        DatabaseExecuter nonAdminExecuter = new DatabaseExecuterProxy("NonAdmin", "Admin@123");
        nonAdminExecuter.executeDatabase("DELEE"); // Spelling mistake in the query

        DatabaseExecuter nonAdminExecuterDELETE = new DatabaseExecuterProxy("NonAdmin", "Admin@123");
        nonAdminExecuterDELETE.executeDatabase("DELETE"); // DELETE not allowed for non-admin user

        DatabaseExecuter adminExecuter = new DatabaseExecuterProxy("Admin", "Admin@123");
        adminExecuter.executeDatabase("DELETE"); // Admin user can execute DELETE
    }
}
