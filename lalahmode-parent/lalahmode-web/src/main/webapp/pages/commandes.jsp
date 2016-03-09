<%@page import="service.ServiceCommande"%>
<%@page import="donnees.Commande"%>
<%@page import="java.util.*"%>
<jsp:include page="header.jsp"/>

  <div class="fullcolumn">
    <h1>Mes commandes</h1>
	<%
	ServiceCommande sc = new ServiceCommande();
	List liste = sc.getListCommande((String)session.getAttribute("role"));
	if (liste.size()==0) {
		out.print("<p>A ce jour, vous n'avez h&eacute;las pass&eacute; aucune commande chez nous.</p>");
		out.print("<p>Pourquoi ne pas aller consulter notre catalogue ?</p>");
	} else {
		for (int i=0;i<liste.size();i++) {
                    Commande tempC = (Commande)liste.get(i);
			out.print("<p>&nbsp;&nbsp;&nbsp;-&nbsp;commande <a href=\"commande.jsp?ref="+tempC.getId()+"\">r&eacute;f. "+tempC.getId()+"</a> du "+tempC.getDateCommande());
			if (!tempC.getDateValidation().equals("00/00/0000")) {
				out.println(", valid&eacute;e le "+tempC.getDateValidation()+"</p>");
			} else {
				out.println(", non valid&eacute;e"+"</p>");
			}
		}
	}
	%>
  </div>

<jsp:include page="footer.jsp"/>