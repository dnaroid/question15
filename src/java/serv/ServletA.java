package serv;

import serv.game.GameSession;
import serv.game.Player;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Vasil Talkachou
 */
@WebServlet(name = "Game21", urlPatterns = {"/"})
public class ServletA extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        HttpSession session = request.getSession();
        Player player = GameSession.getPlayer("player", session);
        Player server = GameSession.getPlayer("server", session);

        if (request.getParameter("take") != null) {
            player.getCard();
            server.getCard();
        }

        if (request.getParameter("pass") != null) {
            server.getCard();
        }

        if (request.getParameter("restart") != null) {
            player.restart();
            server.restart();
        }

        request.setAttribute("serverScore", server.getPoints());
        request.setAttribute("playerScore", player.getPoints());

        if (server.isLost() || player.isWin()) {
            request.setAttribute("res", "Вы победили!");
            request.getRequestDispatcher("/result.jsp").forward(request, response);
        } else if (player.isLost() || server.isWin()) {
            request.setAttribute("res", "Вы проиграли!");
            request.getRequestDispatcher("/result.jsp").forward(request, response);
        }

        request.getRequestDispatcher("/game.jsp").forward(request, response);
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
