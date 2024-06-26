/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Usuario;
import model.dao.UsuarioDAO;

/**
 *
 * @author paulo
 */
public class LoginController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String nextPage = "/WEB-INF/jsp/login.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getServletPath();
        String nextPage = "/WEB-INF/jsp/login.jsp"; // Definindo a página padrão

        if (url.equals("/logar")) {
            Usuario user = new Usuario();
            UsuarioDAO valida = new UsuarioDAO();

            user.setEmail(request.getParameter("email"));
            user.setSenha(request.getParameter("senha"));

            try {
                Usuario userAutenticado = valida.validaUser(user);

                if (userAutenticado != null && !userAutenticado.getNome().isEmpty()) {
                    int idUsuario = valida.getId(request.getParameter("email"));
                    
                    response.sendRedirect(request.getContextPath() + "/Produtos?idUsuario=" + idUsuario);
                    return;
                } else {
                    request.setAttribute("errorMessage", "Usuário ou senha inválidos");
                }
            } catch (Exception e) {
                request.setAttribute("errorMessage", "Erro ao autenticar usuário");
            }
        }
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(Usuario.getIdUsuarioStatico());
        request.setAttribute("usuario", usuario);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
        dispatcher.forward(request, response);
    }

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
