package controllers;

import play.libs.WS;
import play.mvc.Controller;

public class Application extends Controller {

	public static void index(String server, String port) {
    	
		String serverUrl = "http://localhost:9000";
		if (server != null){
			serverUrl = "http://"+server;
			if (port != null){
				serverUrl = serverUrl + ":" + port;
			}
		}
		String url = WS.url(serverUrl).get().getString();
		System.out.println(url);
		render(url);
    }

}