package koch.dan.httpserver;

public class Program
{

    public static void main(String[] args)
    {
        Server mainServer = new Server();
        mainServer.Listen();
    }

}
