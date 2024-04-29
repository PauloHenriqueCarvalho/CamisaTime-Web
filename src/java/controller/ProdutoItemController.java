/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Base64;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.CarrinhoProduto;
import model.bean.Produto;
import model.bean.Usuario;
import model.dao.CarrinhoProdutoDAO;
import model.dao.ProdutoDAO;

/**
 *
 * @author Senai
 */
public class ProdutoItemController extends HttpServlet {

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

        ProdutoDAO dao = new ProdutoDAO();
        int idProduto = Integer.parseInt(request.getParameter("id"));
        Produto.setIdProdutoStatic(idProduto);
        Produto produto = dao.readById(idProduto);

        // Se a imagem estiver disponível no banco de dados, converta para Base64
        if (produto.getImagemBytes() != null) {
            String imagemBase64 = Base64.getEncoder().encodeToString(produto.getImagemBytes());
            produto.setImagemBase64(imagemBase64);
        }

        Usuario usuario = new Usuario();
        usuario.setIdUsuario(Usuario.getIdUsuarioStatico());
        request.setAttribute("usuario", usuario);
        request.setAttribute("produto", produto);

        String url = "/WEB-INF/jsp/produto.jsp";
        RequestDispatcher d = getServletContext().getRequestDispatcher(url);
        d.forward(request, response);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getServletPath();
        if (url.equals("/adicionar")) {
            int idProduto = Produto.getIdProdutoStatic();
            int idUsuario = Usuario.getIdUsuarioStatico();
            String tamanhoSelecionado = request.getParameter("listGroupRadio");
            CarrinhoProduto c = new CarrinhoProduto();
            c.setProduto(idProduto);
            c.setCarrinho(idUsuario);
            c.setTamanhoSelecionado(tamanhoSelecionado);

            CarrinhoProdutoDAO dao = new CarrinhoProdutoDAO();
            boolean sucesso = dao.adicionarProdutoAoCarrinho(c);

            if (sucesso) {
                response.sendRedirect(request.getContextPath() + "/Produtos?idUsuario=" + idUsuario);
            } else {
                response.sendRedirect(request.getContextPath() + "/Produtos?idUsuario=" + idUsuario);
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/erro");
        }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
