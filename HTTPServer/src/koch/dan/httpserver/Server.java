package koch.dan.httpserver;

/**
 * Created by Dan on 6/11/2017.
 */

import java.io.*;
import java.net.*;

public class Server
{
    private ServerSocket serverSocket;

    public Server()
    {
        try
        {
            serverSocket = new ServerSocket(80);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
    }

    public void Listen()
    {
        try
        {
            while(true)
            {
                Socket clientSocket = serverSocket.accept();
                (new Thread(new RequestResponder(clientSocket))).start();
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
    }
}
