import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        StudentsDAO store = new ArrayListStudentsDAO();
        servletContextEvent.getServletContext().setAttribute("store", store);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
