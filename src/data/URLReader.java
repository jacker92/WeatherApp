package data;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class URLReader {

    private URL url;

    public URLReader(URL url) {
        this.url = url;
    }

    public String getContent() {
        String content = "";
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String s = "";
            while ((s = br.readLine()) != null) {
                content += s + "\n";
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return content;
    }
}
