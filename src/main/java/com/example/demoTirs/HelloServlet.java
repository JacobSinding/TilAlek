package com.example.demoTirs;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "du ramte min servlet via min get" + "</h1>");
        out.println("</body></html>");


        out.write("<a href=\"hello-servlet\">Hello Servlet</a>\n");

        out.write("</body>\n");
        out.write("</html>");

    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        HttpSession session = request.getSession();

        ServletContext context = request.getServletContext();

        String pass1 = request.getParameter("password");
        String pass2 = request.getParameter("password2");
        String inputNavn = request.getParameter("navn");

//              PrintWriter out = response.getWriter();

        if (pass1.equals(pass2)) {


            List<Bruger> brugerList = (List<Bruger>) context.getAttribute("brugerliste");

            if (brugerList == null) {

                brugerList = new ArrayList<>();

            }

            Bruger bruger = new Bruger(inputNavn, pass1);

            brugerList.add(bruger);

            context.setAttribute("brugerliste", brugerList);
            session.setAttribute("bruger", bruger);

            String sessionid = session.getId();


            session.setAttribute("brugernavn", inputNavn);
            session.setAttribute("sessionid", sessionid);

            request.setAttribute("brugernavn", inputNavn);
            request.getRequestDispatcher("/WEB-INF/Bruger.jsp").forward(request, response);


        } else {


            String besked = "dine passwords er ikke ens prøv igen";

            request.setAttribute("msg", besked);

            request.getRequestDispatcher("index.jsp").forward(request, response);

        }


    }


    public void destroy() {
    }
}