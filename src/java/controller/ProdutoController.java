/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.CarrinhoProduto;
import model.bean.Categoria;
import model.bean.Produto;
import model.bean.Subcategoria;
import model.bean.Usuario;
import model.dao.CarrinhoProdutoDAO;
import model.dao.CategoriaDAO;
import model.dao.ProdutoDAO;
import model.dao.SubcategoriaDAO;
import model.dao.UsuarioDAO;

/**
 *
 * @author paulo
 */
public class ProdutoController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        SubcategoriaDAO daoSub = new SubcategoriaDAO();
        List<Subcategoria> sub = daoSub.listarTodos();        
        request.setAttribute("subcategoria", sub);    
        
        CategoriaDAO daoCate = new CategoriaDAO();
        List<Categoria> categoria = daoCate.listarTodos();    
        request.setAttribute("categorias", categoria);
       
        ProdutoDAO dao = new ProdutoDAO();
        List<Produto> produto = dao.listarTodos();
        request.setAttribute("produtos", produto);
        
        CarrinhoProdutoDAO car = new CarrinhoProdutoDAO();
        
        int idCarrinho = Integer.parseInt(request.getParameter("idUsuario"));
        List<Produto> carrinho = car.listarProdutosDoCarrinho(idCarrinho);      
        System.out.println("NOME> " + carrinho);
        request.setAttribute("carrinhos", carrinho); 
        
    
        UsuarioDAO u = new UsuarioDAO();
        System.out.println("IDDDD: " + idCarrinho);
        System.out.println("e: " + u.getName(idCarrinho));
        
        
        
        Usuario usuario = u.getName(Usuario.getIdUsuario());
        request.setAttribute("usuario", usuario);
        
        String url = "/WEB-INF/jsp/index.jsp";
        
        RequestDispatcher d = getServletContext().getRequestDispatcher(url);
        d.forward(request, response);
       
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
