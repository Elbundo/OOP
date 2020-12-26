import java.net.*;
import java.util.*;
import java.io.*;

public class test
{
    public static void main(String[] args)
    {
        String link = "http://www.google.ru/intl/ru/services/";
        URL url = null;
        try{
            url = new URL(link);
        }
        catch(MalformedURLException e){
            System.err.println("MalformedURLException: " + e.getMessage());
            System.exit(1);
        }
        Socket sock = null;
        try{
            sock = new Socket(url.getHost(), 80);
        }
        catch(UnknownHostException e){
            System.err.println("UnknownHostException: " + e.getMessage());
            System.exit(1);
        }
        catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
            System.exit(1);
        }
        try{
            sock.setSoTimeout(1000);
        }
        catch(SocketException e){
            System.err.println("SocketException: " + e.getMessage());
            System.exit(1);
        }
        
        PrintWriter out = null;
        try{
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(sock.getOutputStream())), true);
        }
        catch(IOException e){
            System.err.println("IOException: " + e.getMessage());
            System.exit(1);
        }
        out.println("GET " + url.getPath() + " HTTP/1.1");
        out.println("Host: " + url.getHost());
        out.println("Connection: close");
        out.println();
        
        BufferedReader in = null;
        try{
            in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        }
        catch(IOException e){
            System.err.println("IOException: " + e.getMessage());
            System.exit(1);
        }

        
        
        String document = "";
        while(true){
            String line = null;
            try{
                line = in.readLine();
            }
            catch(Exception e){
                System.err.println("IOException: " + e.getMessage());
                System.exit(1);
            }
            if(line == null)
                break;
            document += line;
        }
        System.out.println(document);
        int beginIndex = 0;
        int endIndex = 0;
        int index = 0;
        
        while(true){
            String URL_INDICATOR = "a href=\"";
            String END_URL = "\"";
            index = document.indexOf(URL_INDICATOR, index);
            
            if(index == -1)
                break;
            index += URL_INDICATOR.length();
            beginIndex = index;
            endIndex = document.indexOf(END_URL, index);
            index = endIndex;
            
            String newUrl = document.substring(beginIndex, endIndex);
            if(newUrl.indexOf("http") != -1 && newUrl.indexOf("https") == -1){
                System.out.println(newUrl);
            }
        }
        
        try{
            sock.close();
        }
        catch(IOException e){
            System.err.println("IOException: " + e.getMessage());
            System.exit(1);
        }
    }
}