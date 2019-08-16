/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quantum.servlet;

import com.google.gson.Gson;
import com.quantum.dao.ArchivoDAO;
import com.quantum.modelos.Selectequivalencias;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author RIO CASMA
 */
@WebServlet(name = "Equivalencias", urlPatterns = {"/Equivalencias"})
public class Equivalencias extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet equivalencias</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet equivalencias at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        List<Selectequivalencias> Lstselectequivalencia;
        response.setContentType("text/plain");
        ArchivoDAO daoarchivo;
        try {
            String inputarray = request.getParameter("json");
            Gson gson = new Gson();
            daoarchivo = new ArchivoDAO();

            Selectequivalencias[] seleccionados = gson.fromJson(inputarray,
                    Selectequivalencias[].class);
           /* 
            for (Selectequivalencias select : seleccionados) {
                System.out.println(footballPlayer.getId() +" - "+ footballPlayer.getCampo());
            }*/
            daoarchivo.procesar();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        /* Object obj = JSONValue.parse(data);
        JSONArray array = (JSONArray) obj;
        System.out.println(array);
         */ PrintWriter out = response.getWriter();
        out.print("Hello");
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
