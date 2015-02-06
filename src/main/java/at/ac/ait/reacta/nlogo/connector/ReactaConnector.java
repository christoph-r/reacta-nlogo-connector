package at.ac.ait.reacta.nlogo.connector;

import org.nlogo.api.DefaultClassManager;
import org.nlogo.api.ExtensionException;
import org.nlogo.api.PrimitiveManager;

import at.ac.ait.reacta.nlogo.connector.actions.PostGps;
import at.ac.ait.reacta.nlogo.connector.actions.ReadAFeedbacks;

/**
 * Main entry point for the reacta nlogo connection
 */
public class ReactaConnector extends DefaultClassManager {

	public void load(PrimitiveManager primitiveManager)
			throws ExtensionException {
		primitiveManager.addPrimitive("read-a-fb", new ReadAFeedbacks());
		primitiveManager.addPrimitive("write-gps", new PostGps());
	}
}
