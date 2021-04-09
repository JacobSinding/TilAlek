import com.example.demoTirs.Bruger;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
//import javax.xml.ws.spi.http.HttpContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "TilfoejEmne", value = "/TilfoejEmne")
public class TilfoejEmne extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/Oversigt.jsp").forward(request, response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String emne = request.getParameter("emne");

        HttpSession session = request.getSession();

        ServletContext context = request.getServletContext();

        List<String> emneListeContext = (List<String>) context.getAttribute("emneListeContext");

        if (emneListeContext == null) {

            emneListeContext = new ArrayList<>();

        }


        emneListeContext.add(emne);

        int contextSize = emneListeContext.size();


//

        List<String> emneListe = (List<String>) session.getAttribute("emneListe");

        if (emneListe == null) {    // der her sker kun første gang vi forbi

            emneListe = new ArrayList<>();

        }

        boolean ans = emneListe.contains(emne);

        if (ans) {
            emneListeContext.remove(emne);
            System.out.println("error");
        } else {
            emneListe.add(emne);
        }

        Bruger bruger = (Bruger) session.getAttribute("bruger");
        bruger.setBrugerHuskeliste(emneListe);


        int emneListeSize = emneListe.size();

        context.setAttribute("emneListeContext", emneListeContext);
        context.setAttribute("contextSize", contextSize);

        session.setAttribute("emneListe", emneListe);
        session.setAttribute("emneListeSize", emneListeSize);

        request.getRequestDispatcher("/WEB-INF/Bruger.jsp").forward(request, response);


    }
}
