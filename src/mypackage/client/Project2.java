package mypackage.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Project2 implements EntryPoint
{
	VerticalPanel mainPanel = new VerticalPanel();
	String baseURL = "http://localhost:3000";
	public void onModuleLoad()
	{
		String url = baseURL + "/students/index.json";
		getRequest(url,"getStudents");
	}
	public void getRequest(String url, final String getType) {
		final RequestBuilder rb = new
			RequestBuilder(RequestBuilder.GET,url);
		try {
			rb.sendRequest(null, new RequestCallback()
			{
				public void onError(final Request request,
					final Throwable exception)
				{
					Window.alert(exception.getMessage());
				}
				public void onResponseReceived(final Request request,
					final Response response)
				{
					if (getType.equals("getStudents")) {
						Window.alert(response.getText());
					}
				}
			});
		}
		catch (final Exception e) {
			Window.alert(e.getMessage());
		}
	}

}
