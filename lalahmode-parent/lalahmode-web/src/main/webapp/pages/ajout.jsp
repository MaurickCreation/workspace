<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="donnees.*" %>
<%@page import="donnees.Article"%>
<%@page import="service.ServiceArticle"%>
<jsp:include page="header.jsp"/>

<% //récupération des paramètres

String code = request.getParameter("code");

String libelle = request.getParameter("libelle");

//recherche de la liste des bouteilles

%>

<% String titre="Gestiond''un catalogue / Ajout de nouvel article"; %>

  <div class="fullcolumn">
<h1>Ajouter des produits</h1><br />
<form name="form1" method="post" action="ajout.jsp">
  Article : <select name="code" size="1">
            <option valid="vide"></option>
            <%  ServiceArticle serviceArticle = ServiceArticle.getInstance();
           
                List<Article> articles = serviceArticle.listerArticles();
 
                for(Article tempA : articles){
                
                    out.println("<option value=" + tempA.getCodeArt() + "'>" + tempA.getLibelle() + "</option>");
                    
                    
                }
            %>
     Nb Articles &lt; <input type="text" name="cuvee" size="4" maxlength="4" />
     &nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="Rechercher" name="valid" /><br />
</form><br />


<form name="form2" method="post" action="ajout.jsp">
<table cols="1" border="1" cellpadding="1" cellspacing="1">
       <tr>
           <td>Appellation</td>
           <td>Chateau</td>
           <td>Département</td>
           <td>Type de bouteilles</td>
           <td>Nombre disponible</td>
           <td>Quantité à ajouter</td>
       </tr>
       <tr>
           <td>Médoc</td>
           <td>Chateau toto</td>
           <td>33</td>
           <td>Supérieur</td>
           <td>500</td>
           <td><input type="text" name="qtt1" size="3" maxlength="3" /></td>
       </tr>
       <tr>
           <td>Médoc</td>
           <td>Chateau tata</td>
           <td>33</td>
           <td>Cubi</td>
           <td>2000</td>
           <td><input type="text" name="qtt2" size="3" maxlength="3" /></td>
       </tr>
</table>
<input type="submit" value="Valider" name="valid" /><br /><br />
</form>
<a href="javascript:history.back()">Retour</a>
</div>
<jsp:include page="footer.jsp"/>