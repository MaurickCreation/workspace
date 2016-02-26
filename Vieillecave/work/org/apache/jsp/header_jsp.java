package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class header_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<?xml version=\"1.0\" encoding=\"iso-8859-1\"?>\n");
      out.write("<!DOCTYPE html \n");
      out.write("     PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\"\n");
      out.write("     \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");
      out.write("<head>\n");
      out.write("<title>LalahMode</title>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\" />\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("\n");
      out.write("var browserName=navigator.appName; \n");
      out.write("if (browserName==\"Microsoft Internet Explorer\")\n");
      out.write("{ \n");
      out.write("document.write('<link rel=\"stylesheet\" href=\"styles/stylesheet.css\" type=\"text/css\">')\n");
      out.write("}\n");
      out.write("else {\n");
      out.write("document.write('<link rel=\"stylesheet\" href=\"styles/stylesheet_ns.css\" type=\"text/css\">')\n");
      out.write("}\n");
      out.write("\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("<SCRIPT language=\"JavaScript\">\n");
      out.write("function control(form){\n");
      out.write("    var ok = true;\n");
      out.write("        for(i=0;i<form.elements.length;i++){\n");
      out.write("            if(form.elements[i].value==\"\") {\n");
      out.write("            \tok = false;\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("        if (ok) {\n");
      out.write("        \tform.submit();\n");
      out.write("        } else {\n");
      out.write("        \talert(\"Vous devez remplir tous les champs.\");\n");
      out.write("        }\n");
      out.write("    }\n");
      out.write("</SCRIPT>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<div class=\"wrapper\">\n");
      out.write("  <div class=\"logobkg\"><img src=\"images/logo_new.png\" alt=\"logo\"/></div>\n");
      out.write("  <div class=\"navbar\">\n");
      out.write("    <div class=\"buttons\">\n");
      out.write("    ");

    if (session.getAttribute("role").equals("")) {
    	out.println("<a href=\"accueil.jsp\">Accueil</a>");
    	out.println("<a href=\"catalogue.jsp\">Catalogue</a>");
    	out.println("<a href=\"connexion.jsp?erreur=\">Connexion / Inscription</a>");
    } else {
    	if (session.getAttribute("role").equals("admin")) {
    		out.println("<a href=\"accueil.jsp\">Administration</a>");
    		out.println("<a href=\"etat_cave.jsp\">Etat de la cave</a>");
    		out.println("<a href=\"saisie.jsp\">Ajouter des bouteilles</a>");
    		out.println("<a href=\"index.jsp\" style=\"float:right\">Deconnexion</a>");
    	} else {
    		out.println("<a href=\"accueil.jsp\">Accueil</a>");
    		out.println("<a href=\"catalogue.jsp\">Catalogue</a>");
    		out.println("<a href=\"commandes.jsp\">Mes commandes</a>");
    		out.println("<a href=\"index.jsp\" style=\"float:right\">Deconnexion</a>");
    	}
    }
    
      out.write("\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("<!--<div class=\"subnav\"></div>-->");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
