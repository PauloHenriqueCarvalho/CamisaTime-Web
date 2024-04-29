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
public class CadastroUsuarioController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String nextPage = "/WEB-INF/jsp/cadastrar.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
        dispatcher.forward(request, response);

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
        String url = request.getServletPath();

        if (url.equals("/cadastrar")) {
            String nextPage = "/WEB-INF/jsp/index.jsp";

            Usuario u = new Usuario();
            UsuarioDAO dao = new UsuarioDAO();
            String errorMessage = "Cadastro não realizado corretamente";

            String cpf = request.getParameter("cpf");
            if (cpf != null && !cpf.trim().isEmpty() && cpf.matches("\\d{11}")) {
                u.setCpf(cpf);
            } else {
                request.setAttribute("errorMessage", errorMessage);
                nextPage = "/WEB-INF/jsp/cadastrar.jsp";
            }

            String email = request.getParameter("idEmail");
            if (email != null && !email.trim().isEmpty() && email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
                u.setEmail(email);
            } else {
                request.setAttribute("errorMessage", errorMessage);
                nextPage = "/WEB-INF/jsp/cadastrar.jsp";
            }

            String senha = request.getParameter("senha");
            if (senha != null && !senha.trim().isEmpty() && senha.length() >= 6) {
                u.setSenha(senha);
            } else {
                request.setAttribute("errorMessage", errorMessage);
                nextPage = "/WEB-INF/jsp/cadastrar.jsp";
            }

            String telefone = request.getParameter("telefone");
            if (telefone != null && !telefone.trim().isEmpty()) {
                telefone = telefone.replaceAll("[^0-9]", "");
                if (telefone.length() >= 10) {
                    u.setTelefone(telefone);
                } else {
                    request.setAttribute("errorMessage", errorMessage);
                    nextPage = "/WEB-INF/jsp/cadastrar.jsp";
                }
            } else {
                request.setAttribute("errorMessage", errorMessage);
                nextPage = "/WEB-INF/jsp/cadastrar.jsp";
            }

            String nome = request.getParameter("nome");
            if (!nome.trim().isEmpty()) {
                u.setNome(nome);
            } else {
                request.setAttribute("errorMessage", errorMessage);
                nextPage = "/WEB-INF/jsp/cadastrar.jsp";
            }

            try {
                // Verifica se todos os campos foram preenchidos corretamente antes de tentar criar o usuário
                if (u.getCpf() != null && u.getEmail() != null && u.getSenha() != null && u.getTelefone() != null && u.getNome() != null) {
                    
                    int idUsuario = dao.create(u);
                    // Adiciona uma mensagem de sucesso
                    request.setAttribute("successMessage", "Cadastro realizado com sucesso!");
                    nextPage = "/Produtos?idUsuario=" + idUsuario ;
                } else {
                    request.setAttribute("errorMessage", errorMessage);
                    nextPage = "/WEB-INF/jsp/cadastrar.jsp";
                }
            } catch (Exception e) {
                request.setAttribute("errorMessage", errorMessage);
                nextPage = "/WEB-INF/jsp/cadastrar.jsp";
            }

            RequestDispatcher d = getServletContext().getRequestDispatcher(nextPage);
            d.forward(request, response);
        }
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
