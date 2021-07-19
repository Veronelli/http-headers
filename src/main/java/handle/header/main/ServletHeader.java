/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handle.header.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet("/ServletHeader")
public class ServletHeader extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        
        String method = req.getMethod();
        String URL = req.getRequestURI();
        Enumeration headerEnum = req.getHeaderNames();
        
        System.out.println("Hello");
        
        out.print("<html>");
        out.print("<header>");
        out.print("<title>Handle Header</title>");
        out.print("</header>");
        
        out.print("<body>");
        out.print("<h1> Method: "+ method + "</h1>");
        out.print("<h2>URL requested: " + URL+ "</h2>");
        out.print("<h2>Header</h2>");
        
        out.print("<ul>");
        
        while(headerEnum.hasMoreElements()){
            String header = (String) headerEnum.nextElement();
            out.print("<li>" + header +": "+ req.getHeader(header)+"</li>");
            
        }

        out.print("</ul>");
        
        out.print("</body>");
        
        out.close();
    }
    
}
