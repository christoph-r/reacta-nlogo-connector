package at.ac.ait.reacta.nlogo.connector;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.Test;

public class PostGpsTest {

	@Test
	public void httpTest() {

		String arfId = "aha";
		double lng = 1.2;
		double lat = 3.4;

		DefaultHttpClient client = new DefaultHttpClient();

		try {
			HttpGet post = new HttpGet(
					"http://localhost:12003/log/get?arfId=1232&lat=1.2");
			HttpResponse resp = client.execute(post);

			// Consume and close Connection
			post.releaseConnection();

		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
