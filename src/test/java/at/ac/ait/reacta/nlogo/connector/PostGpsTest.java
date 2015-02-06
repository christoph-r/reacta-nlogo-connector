package at.ac.ait.reacta.nlogo.connector;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.Ignore;
import org.junit.Test;

public class PostGpsTest {

	@Test
	@Ignore
	public void httpTest() {

		String arfId = "aha";
		double lng = 1.2;
		double lat = 3.4;

		try {
			DefaultHttpClient client = new DefaultHttpClient();
			HttpGet post = new HttpGet("http://localhost:12003/log/get?arfId="
					+ arfId + "&lat=" + lat + "&lng=" + lng);
			client.execute(post);
			// Consume and close Connection
			post.releaseConnection();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
