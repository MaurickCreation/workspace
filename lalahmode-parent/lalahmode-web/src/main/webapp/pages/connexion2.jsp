<%@page import="com.mcreation.lalahmode.donnees.Utilisateur"%>
<%@page import="com.mcreation.lalahmode.service.ServiceUtilisateur"%>
<jsp:include page="header.jsp"/>

<% 
ServiceUtilisateur serviceUtilisateur = ServiceUtilisateur.getInstance();

if (request.getParameter("action").equals("connexion")) {
	String login = request.getParameter("c_login");
	String mdp = request.getParameter("c_mdp");
	if (login.equals("admin") && mdp.equals("admin")) {
		session.setAttribute("role","admin");
		%><jsp:forward page="accueil.jsp"/><%
	} else {
		if (serviceUtilisateur.authentification(login,mdp)) {
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
		

		   if (serviceUtilisateur.isLoginDispo(login)) {
				try {
					serviceUtilisateur.creerUtilisateur(login, mdp, nom, prenom, tel, adresse);
					System.out.println("je peux cree"+login);
				}
				catch (Exception e) {
						System.out.println("err "+e);
						e.printStackTrace();
						%><jsp:forward page="connexion.jsp?erreur=1"/><%
					}
			session.setAttribute("role",login);%><jsp:forward page="accueil.jsp"/><%
				
				
		} else {
			session.setAttribute("role","");
			%><jsp:forward page="connexion.jsp?erreur=4"/><%
		}
	}
	else {session.setAttribute("role","");%><jsp:forward page="accueil.jsp"/><%}
}
%>
<jsp:include page="footer.jsp"/>