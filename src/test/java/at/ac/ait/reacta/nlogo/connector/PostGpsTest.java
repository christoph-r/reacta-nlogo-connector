package at.ac.ait.reacta.nlogo.connector;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.Ignore;
import org.junit.Test;

public class PostGpsTest {

	@Ignore
	@Test
	public void httpGetTest() {

		String arfId = "aha";
		double lng = 1.2;
		double lat = 3.4;

		try {
			DefaultHttpClient client = new DefaultHttpClient();
			HttpGet post = new HttpGet("http://localhost:12003/log/get?arfId=" + arfId + "&lat=" + lat + "&lng=" + lng);
			client.execute(post);
			// Consume and close Connection
			post.releaseConnection();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Ignore
	@Test
	public void httpPostTest() {

		try {
			DefaultHttpClient client = new DefaultHttpClient();
			HttpPost post = new HttpPost("http://localhost:12010/rf/getAll");
			post.setHeader("Content-type", "application/json");
			post.setEntity(new StringEntity("[1,2,3]"));

			HttpResponse resp = client.execute(post);

			if (resp.getEntity() != null) {
				String theString = IOUtils.toString(resp.getEntity().getContent());
				System.out.println(theString);
			}

			// Consume and close Connection
			post.releaseConnection();

		} catch (Exception e) {

		}
	}
}
