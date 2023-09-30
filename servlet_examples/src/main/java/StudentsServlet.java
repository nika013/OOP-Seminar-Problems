import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class StudentsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        PrintWriter out = httpServletResponse.getWriter();
        httpServletResponse.setContentType("text/html");
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<link rel=\"icon\" href=\"https://upload.wikimedia.org/wikipedia/commons/thumb/a/a7/React-icon.svg/1024px-React-icon.svg.png\">");
        out.println("<title> Students </title>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("</head>");
        out.println("<body>");
        out.println("<table>");
        out.println("<tr>");
        out.println("<th> first name </th");
        out.println("<th> last name </th");
        out.println("<th> age </th");
        out.println("</tr>");

        out.println("</td>");

        List<Student> studentList = getStore(httpServletRequest).getAll();

        for (Student student : studentList) {
            out.println("<tr>");
            out.println("<td>" + student.getFirstName() + "</td>");
            out.println("<td>" + student.getLastName() + "</td>");
            out.println("<td>" + student.getEnrollmentYear() + "</td>");
            out.println("</tr>");
        }
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
        out.close();

    }
    private StudentsDAO getStore(HttpServletRequest request) {
        return (StudentsDAO) request.getServletContext().getAttribute("store");
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        StudentsDAO studentsDAO = getStore(httpServletRequest);
        String firstName = httpServletRequest.getParameter("first-name");
        String lastName = httpServletRequest.getParameter("last-name");
        String age = httpServletRequest.getParameter("age");
        studentsDAO.add(new Student(firstName, lastName, Integer.parseInt(age)));
        httpServletResponse.sendRedirect("/students");
    }
}
