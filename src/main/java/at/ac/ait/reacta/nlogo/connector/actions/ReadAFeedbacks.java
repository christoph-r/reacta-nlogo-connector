package at.ac.ait.reacta.nlogo.connector.actions;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.nlogo.api.Argument;
import org.nlogo.api.Context;
import org.nlogo.api.DefaultReporter;
import org.nlogo.api.ExtensionException;
import org.nlogo.api.LogoException;
import org.nlogo.api.LogoListBuilder;
import org.nlogo.api.Syntax;

import at.ac.ait.reacta.nlogo.connector.actions.dto.AFeedbacks;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ReadAFeedbacks extends DefaultReporter {

	@Override
	public Syntax getSyntax() {
		return Syntax.reporterSyntax(new int[] {}, Syntax.ListType());
	}

	public Object report(Argument[] args, Context ctx)
			throws ExtensionException, LogoException {

		LogoListBuilder list = new LogoListBuilder();

		try {
			DefaultHttpClient client = new DefaultHttpClient();
			HttpPost post = new HttpPost("http://localhost:12003/log/post");
			HttpResponse resp = client.execute(post);

			if (resp.getEntity() != null) {
				String theString = IOUtils.toString(resp.getEntity()
						.getContent());

				Gson gson = new GsonBuilder().create();
				AFeedbacks r = gson.fromJson(theString, AFeedbacks.class);

				list.addAll(r.getIds());
			}

			// Consume and close Connection
			post.releaseConnection();

		} catch (Exception e) {

		}

		return list.toLogoList();
	}
}
