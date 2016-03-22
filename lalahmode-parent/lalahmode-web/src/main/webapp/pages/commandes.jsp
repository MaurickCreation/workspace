<%@page import="service.ServiceCommandeEntete"%>
<%@page import="donnees.CommandeEntete"%>
<%@page import="java.util.*"%>
<jsp:include page="header.jsp"/>

  <div class="fullcolumn">
    <h1>Mes commandes</h1>
	<%
	ServiceCommandeEntete sc = ServiceCommandeEntete.getInstance();
	List<CommandeEntete> listeCommandes = sc.listerCommandes();
	if (listeCommandes.size()==0) {
		out.print("<p>A ce jour, vous n'avez h&eacute;las pass&eacute; aucune commande chez nous.</p>");
		out.print("<p>Pourquoi ne pas aller consulter notre catalogue ?</p>");
	} else {
		for (CommandeEntete tempC : listeCommandes ) {
             
			out.print("<p>&nbsp;&nbsp;&nbsp;-&nbsp;commande <a href=\"commande.jsp?ref="+tempC.getNumCommande()+"\">r&eacute;f. "+tempC.getNumClient()+"</a> du "+tempC.getDateCommande());
			if (!"00000000".equals(tempC.getDateValidation()) ||  tempC.getDateValidation() == null) {
				out.println(", valid&eacute;e le "+tempC.getDateValidation()+"</p>");
			} else {
				out.println(", non valid&eacute;e"+"</p>");
			}
		}
	}
	%>
  </div>

<jsp:include page="footer.jsp"/>