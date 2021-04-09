import com.example.demoTirs.Bruger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "FjernEmne", value = "/FjernEmne")


public class FjernEmne extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/Oversigt.jsp").forward(request, response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();


        String emne = request.getParameter("emne");

        HttpSession session = request.getSession();

        ServletContext context = request.getServletContext();

        List<String> emneListeContext = (List<String>) context.getAttribute("emneListeContext");

        if (emneListeContext == null) {

            emneListeContext = new ArrayList<>();

        }

        emneListeContext.remove(emne);
        int contextSize = emneListeContext.size();


//

        List<String> emneListe = (List<String>) session.getAttribute("emneListe");

        if (emneListe == null) {    // der her sker kun første gang vi forbi

            emneListe = new ArrayList<>();

        }

        emneListe.remove(emne);


        int emneListeSize = emneListe.size();

        Bruger bruger = (Bruger) session.getAttribute("bruger");
        bruger.setBrugerHuskeliste(emneListe);


        context.setAttribute("emneListeContext", emneListeContext);
        context.setAttribute("contextSize", contextSize);

        session.setAttribute("emneListe", emneListe);
        session.setAttribute("emneListeSize", emneListeSize);

        request.getRequestDispatcher("/WEB-INF/Bruger.jsp").forward(request, response);


    }
}


