package controllers;

import play.libs.WS;
import play.mvc.Controller;

import com.google.gson.Gson;

public class Application extends Controller {

	public static void index(String server, String port) {
    	
		String serverUrl = "http://localhost:9000";
		if (server != null){
			serverUrl = "http://"+server;
			if (port != null){
				serverUrl = serverUrl + ":" + port;
			}
		}

		// print json and parsed result
		String json = WS.url(serverUrl).get().getString();

		Resp parsed = new Gson().fromJson(json, Resp.class);
		int time = parsed.lastCrossed;
		render(json, time);
    }

	public final static class Resp {
		public int lastCrossed;
	}
}