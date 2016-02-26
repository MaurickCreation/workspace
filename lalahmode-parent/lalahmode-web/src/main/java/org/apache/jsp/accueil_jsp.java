package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class accueil_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write('\n');
      out.write('\n');

if (session.getAttribute("role").equals("")) {

      out.write("\n");
      out.write("  <div class=\"fullcolumn\">\n");
      out.write("    <h1>Bienvenue sur LalahMode.com</h1>\n");
      out.write("    <p> Nous esp&eacute;rons que chacun d'entre vous trouvera son bonheur dans les articles que nous vous proposons fraichemnet arrives des meilleurs ateliersde l'Asie du Sud Est.</p> \n");
      out.write("\t<p> Vous pouvez consultez librement notre catalogue riche et de qualit&eacute;, ou bien vous connecter / inscrire sur la page r&eacute;serv&eacute;e &agrave; cet effet.</p>\n");
      out.write("\t<p> Toute l'&eacute;quipe de Lalah vous souhaite une agr&eacute;able visite.</p>\n");
      out.write("  </div>\n");

} else {
	if (session.getAttribute("role").equals("admin")) {
		
      out.write("\n");
      out.write("\t\t  <div class=\"fullcolumn\">\n");
      out.write("\t\t    <h1>Administration de Lalahmode.com</h1>\n");
      out.write("\t\t\t<p>Cette partie du site est r&eacute;serv&eacute;e au personnel de Lalahmode.com</p>\n");
      out.write("\t\t\t<p>Vous pouvez consultez l'&eacute;tat de la cave, l'historique des commandes et les fiches clients.</p>\n");
      out.write("\t\t\t<p>Vous pouvez aussi mettre &agrave; jour la cave, en ajoutant des appelations, chateaux et bouteilles.</p>\n");
      out.write("\t\t  </div>\n");
      out.write("\t\t");

	} else {
		
      out.write("\n");
      out.write("\t\t  <div class=\"fullcolumn\">\n");
      out.write("\t\t    <h1>Bienvenue sur Lalahmode.com, <b>");
      out.print(session.getAttribute("role"));
      out.write("</b></h1>\n");
      out.write("\t\t\t<p>Maintenant que vous &ecirc;tes connect&eacute;(e), vous pouvez facilement cr&eacute;er une nouvelle commande,\n");
      out.write("\t\t\tou consulter tous vos achats pass&eacute;s.</p>\n");
      out.write("\t\t\t<p>Toute l'&eacute;quipe de Lalah vous souhaite une agr&eacute;able visite.</p>\n");
      out.write("\t\t  </div>\n");
      out.write("\t\t");

	}
}

      out.write('\n');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write('\n');
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
