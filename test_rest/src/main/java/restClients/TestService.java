package restClients;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class TestService {
    public static void main(String[] args) throws ClientProtocolException,IOException {
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet("https://api.hh.ru/vacancies?text=java");
        HttpResponse response = client.execute(request);
        BufferedReader rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent()));
        String line = "";
        List <String> ls= new ArrayList<>();
        while ((line = rd.readLine()) != null) {
            ls.add(line);
            //System.out.println(line);
            System.out.println(ls);
        }
    }
}