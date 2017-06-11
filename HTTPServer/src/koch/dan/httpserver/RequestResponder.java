package koch.dan.httpserver;

/**
 * Created by Dan on 6/11/2017.
 */

import java.io.*;
import java.net.*;

public class RequestResponder implements Runnable
{
    private Socket _clientSocket;

    public RequestResponder(Socket clientSocket)
    {
        _clientSocket = clientSocket;
    }

    @Override
    public void run()
    {
        try
        {
            Respond();
            _clientSocket.close();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
    }

    private void Respond() throws IOException
    {
        BufferedReader requestReader = new BufferedReader(new InputStreamReader(_clientSocket.getInputStream()));
        DataOutputStream responseStream = new DataOutputStream(_clientSocket.getOutputStream());
        char[] buffer = new char[1024];

        requestReader.read(buffer);
        byte[][] response = ParseRequest(buffer);

        for (byte[] aResponse : response)
        {
            responseStream.write(aResponse);
        }
    }

    private byte[][] ParseRequest(char[] request)
    {


        return new byte[1][1];
    }
}
