package mwkn.ucn.dk.earthquakefeed;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class Connection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection);

    }

    public InputStream getInputStream() throws IOException {
        InputStream stream = null;
        HttpsURLConnection connection = null;
        String urlString = getString(R.string.quake_feed);
        try {
            URL url = new URL(urlString);
            connection = (HttpsURLConnection) url.openConnection();
            // Timeout for reading InputStream arbitrarily set to 3000ms.
            connection.setReadTimeout(3000);
            // Timeout for connection.connect() arbitrarily set to 3000ms.
            connection.setConnectTimeout(3000);
            // For this use case, set HTTP method to GET.
            connection.setRequestMethod("GET");
            // Already true by default but setting just in case; needs to be true since this request
            // is carrying an input (response) body.
            connection.setDoInput(true);
            // Open communications link (network traffic occurs here).
            connection.connect();
            // Retrieve the response body as an InputStream.
            int responsecode = connection.getResponseCode();
            if (responsecode == connection.HTTP_OK) {
                stream = connection.getInputStream();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return stream;
    }
}
