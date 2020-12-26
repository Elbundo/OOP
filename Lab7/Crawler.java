import java.net.*;
import java.util.*;
import java.io.*;

public class Crawler
{
    public static void main(String[] args)
    {
        int depth = 0;
        String URL = "";
        if(args.length != 2){
            System.out.println("usage: java Crawler <URL> <depth>");
            System.exit(1);
        }else{
            try{
                depth = Integer.parseInt(args[1]);
            }
            catch(NumberFormatException e){
                System.out.println("usage: java Crawler <URL> <depth>");
                System.exit(1);
            }
            URL = args[0];
        }
        
        LinkedList<URLDepthPair> reviewedURLs = new LinkedList<URLDepthPair>();
        LinkedList<URLDepthPair> untrackedURLs = new LinkedList<URLDepthPair>();
        
        URLDepthPair currentDepthPair = new URLDepthPair(URL, 0);
        
        untrackedURLs.add(currentDepthPair);
        
        ArrayList<String> trackedUrls = new ArrayList<String>();
        trackedUrls.add(currentDepthPair.getURL());
        
        while(untrackedURLs.size() != 0){
            URLDepthPair depthPair = untrackedURLs.pop();
            reviewedURLs.add(depthPair);
            //System.out.println("Main while, " + depthPair);
            int myDepth = depthPair.getDepth();
            
            LinkedList<String> urls = new LinkedList<String>();
            urls = Crawler.getAllUrl(depthPair);
            String newUrl = "";
            if(myDepth < depth){
                for(int i = 0; i < urls.size(); i++){
                    newUrl = urls.get(i);
                    if(trackedUrls.contains(newUrl)){
                        continue;
                    }else{
                        URLDepthPair newDepthPair = new URLDepthPair(newUrl, myDepth + 1);
                        untrackedURLs.add(newDepthPair);
                        trackedUrls.add(newUrl);
                        //System.out.println(newDepthPair);
                    }
                }
            }
        }
        
        Iterator<URLDepthPair> i = reviewedURLs.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }
    
    private static LinkedList<String> getAllUrl(URLDepthPair depthPair)
    {
        LinkedList<String> urls = new LinkedList<String>();
        Socket sock = null;
        try{
            sock = new Socket(depthPair.getWebHost(), 80);
        }
        catch(UnknownHostException e){
            System.err.println("UnknownHostException: " + e.getMessage());
            return urls;
        }
        catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
            return urls;
        }
        try{
            sock.setSoTimeout(5000);
        }
        catch(SocketException e){
            System.err.println("SocketException: " + e.getMessage());
            return urls;
        }
        
        PrintWriter out = null;
        try{
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(sock.getOutputStream())), true);
        }
        catch(IOException e){
            System.err.println("IOException: " + e.getMessage());
            return urls;
        }
        out.println("GET " + depthPair.getDocPath() + " HTTP/1.1");
        out.println("Host: " + depthPair.getWebHost());
        out.println("Connection: close");
        out.println();
        
        BufferedReader in = null;
        try{
            in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        }
        catch(IOException e){
            System.err.println("IOException: " + e.getMessage());
            return urls;
        }

        
        
        String document = "";
        while(true){
            //System.out.println("First, " + depthPair);
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
        //System.out.println("First end");
        int beginIndex = 0;
        int endIndex = 0;
        int index = 0;
        
        while(true){
            //System.out.println("Second, " + depthPair);
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
            if(newUrl.indexOf("http:") != -1){
                urls.add(newUrl);
            }
        }
        //System.out.println("Second end");
        try{
            sock.close();
        }
        catch(IOException e){
            System.err.println("IOException: " + e.getMessage());
            return urls;
        }
        return urls;
    }
}