<%@page import="donnees.Client"%>
<%@page import="xml.XPath"%>
<jsp:include page="header.jsp"/>

<% 
if (request.getParameter("action").equals("connexion")) {
	String login = request.getParameter("c_login");
	String mdp = request.getParameter("c_mdp");
	if (login.equals("admin") && mdp.equals("admin")) {
		session.setAttribute("role","admin");
		%><jsp:forward page="accueil.jsp"/><%
	} else {
		if (XPath.authentification(login,mdp)) {
			session.setAttribute("role",login);
			%><jsp:forward page="accueil.jsp"/><%
		} else {
			session.setAttribute("role","");
			%><jsp:forward page="connexion.jsp?erreur=3"/><%
		}
	}
}
else {
	if (request.getParameter("action").equals("inscription")) {
		String login = request.getParameter("i_login");
		String mdp = request.getParameter("i_mdp");
		String prenom = request.getParameter("i_prenom");
		String nom = request.getParameter("i_nom");
		String adresse = request.getParameter("i_adresse");
		String tel = request.getParameter("i_tel");
		if (XPath.loginDispo(login)) {
			Client c = new Client(login,mdp,nom,prenom,adresse,tel);
				if(c.creer()){
				    if(c.enregistrer()){
						session.setAttribute("role",login);
						%><jsp:forward page="accueil.jsp"/><%}
				    else {%><jsp:forward page="connexion.jsp?erreur=1"/><%}
				} 
				else {%><jsp:forward page="connexion.jsp?erreur=2"/><%}
		} else {
			session.setAttribute("role","");
			%><jsp:forward page="connexion.jsp?erreur=4"/><%
		}
	}
	else {session.setAttribute("role","");%><jsp:forward page="accueil.jsp"/><%}
}
%>
<jsp:include page="footer.jsp"/>