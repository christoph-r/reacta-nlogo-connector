package at.ac.ait.reacta.nlogo.connector.actions;

import java.io.IOException;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.nlogo.api.Argument;
import org.nlogo.api.Context;
import org.nlogo.api.DefaultCommand;
import org.nlogo.api.ExtensionException;
import org.nlogo.api.LogoException;
import org.nlogo.api.Syntax;

public class PostGps extends DefaultCommand {

	@Override
	public Syntax getSyntax() {
		return Syntax.commandSyntax(new int[] { Syntax.StringType(),
				Syntax.NumberType(), Syntax.NumberType() });
	}

	public void perform(Argument[] args, Context ctx)
			throws ExtensionException, LogoException {

		String arfId = args[0].getString();
		double lng = args[1].getDoubleValue();
		double lat = args[2].getDoubleValue();

		try {

			DefaultHttpClient client = new DefaultHttpClient();
			HttpGet post = new HttpGet("http://localhost:12003/log/get?arfId="
					+ arfId + "&lat=" + lat + "&lng=" + lng);
			client.execute(post);

			// Consume and close Connection
			post.releaseConnection();

			// CloseableHttpClient client = HttpClientBuilder.create().build();
			// HttpPost post = new HttpPost("http://localhost:12003/log/post");
			// post.setEntity(new StringEntity(arfId + " - " + lng + " - " +
			// lat));
			// client.execute(post);

		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
