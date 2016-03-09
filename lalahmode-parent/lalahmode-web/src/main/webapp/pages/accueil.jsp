<jsp:include page="header.jsp"/>

<%
if (session.getAttribute("role").equals("")) {
%>
  <div class="fullcolumn">
    <h1>Bienvenue sur LalahMode.com</h1>
    <p> Nous esp&eacute;rons que chacun d'entre vous trouvera son bonheur dans les articles que nous vous proposons fraichemnet arrives des meilleurs ateliersde l'Asie du Sud Est.</p> 
	<p> Vous pouvez consultez librement notre catalogue riche et de qualit&eacute;, ou bien vous connecter / inscrire sur la page r&eacute;serv&eacute;e &agrave; cet effet.</p>
	<p> Toute l'&eacute;quipe de Lalah vous souhaite une agr&eacute;able visite.</p>
	<div>
	   <img src="../common/images/SA400013.JPG" alt="Alternative de l image" width="500"/>
	</div>
  </div>
<%
} else {
	if (session.getAttribute("role").equals("admin")) {
		%>
		  <div class="fullcolumn">
		    <h1>Administration de Lalahmode.com</h1>
			<p>Cette partie du site est r&eacute;serv&eacute;e au personnel de Lalahmode.com</p>
			<p>Vous pouvez consultez l'&eacute;tat de la cave, l'historique des commandes et les fiches clients.</p>
			<p>Vous pouvez aussi mettre &agrave; jour la cave, en ajoutant des appelations, chateaux et bouteilles.</p>
		  </div>
		<%
	} else {
		%>
		  <div class="fullcolumn">
		    <h1>Bienvenue sur Lalahmode.com, <b><%=session.getAttribute("role")%></b></h1>
			<p>Maintenant que vous &ecirc;tes connect&eacute;(e), vous pouvez facilement cr&eacute;er une nouvelle commande,
			ou consulter tous vos achats pass&eacute;s.</p>
			<p>Toute l'&eacute;quipe de Lalah vous souhaite une agr&eacute;able visite.</p>
		  </div>
		<%
	}
}
%>

<jsp:include page="footer.jsp"/>
