package main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;

@WebServlet(urlPatterns = { "*.hrd" })
public class FrontController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(FrontController.class);

	@Override
	public void init() throws ServletException {
		RequestControllerMapping.init();

	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = request.getServletPath();
		String method = request.getMethod();

		RequestKeyValue key = new RequestKeyValue(url, method);
		Controller controller = RequestControllerMapping.getController(key);
		logger.info("::::::::::{}--{}::::::::::", key, controller.getClass());
		if (controller != null)
			controller.handle(request, response);
	}
}
