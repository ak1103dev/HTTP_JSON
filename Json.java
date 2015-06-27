package ml.research27.testjson;

import com.google.gson.*;

import java.util.Iterator;

/**
 * Created by AK1103 on 26-Jun-15.
 */

public class Json {
    public static void main(String[] args) throws Exception {
        HttpURLConnectionHost http = new HttpURLConnectionHost();

        String post="", get;

        System.out.println("Testing 1 - Send Http GET request");
        get = http.sendGet("http://tutor.newkru-cloud.com/getEpisode/M422P1");

        System.out.println("\nTesting 2 - Send Http POST request");
        try {
            post = http.sendPost("http://tutor.newkru-cloud.com/login", "username=60&password=3457");
        }
        catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("\nJSON POST\n");
        JsonObject json = (JsonObject)new JsonParser().parse(post);
        System.out.println("username:" + json.get("username"));

        System.out.println("\nJSON GET\n");
        JsonObject json2 = (JsonObject)new JsonParser().parse(get);
        System.out.println("id:" + json2.get("id"));
        JsonArray jsonArray = json2.getAsJsonArray("videoList");
        for(int i=0; i<jsonArray.size(); i++){
            System.out.println(i + " : "+jsonArray.get(i));
        }
        Iterator i = jsonArray.iterator();
        // take each value from the json array separately
        while (i.hasNext()) {
            JsonObject innerObj = (JsonObject) i.next();
            System.out.println("id "+ innerObj.get("id") + " infoURL " + innerObj.get("infoURL"));
        }


    }
}
