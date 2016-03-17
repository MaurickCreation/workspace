<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="donnees.*" %>
<%@page import="java.util.*" %>
<%@page import="donnees.Article"%>
<%@page import="service.ServiceArticle"%>
<jsp:include page="header.jsp"/>

<% //récupération des paramètres

String code = request.getParameter("code");

String libelle = request.getParameter("libelle");

//recherche de la liste des bouteilles

%>
         <div class="fullcolumn">
    <h1>Notre catalogue de fringues idéales</h1>
	<p><img width="400" heigth="350" src="../common/images/SA400013.JPG" /></p>

        <form name="form1" method="post" action="commande.jsp">
            Article : <select name="code" size="1">
            <option valid="vide"></option>
            <%  ServiceArticle serviceArticle = ServiceArticle.getInstance();
           
                List<Article> articles = serviceArticle.listerArticles();
 
                for(Article tempA : articles){
                
                    out.println("<option value=" + tempA.getCodeArt() + "'>" + tempA.getLibelle() + "</option>");
                    
                    
                }
            %>
           
            <input type="submit" value="Rechercher" name="valid" />
        </form><br />

        <form name="form2" method="post" action="">
           <div class="outer">
			<div class="innera">
            <table cols="1" border="1" cellpadding="1" cellspacing="1">
               <thead>
                <tr>
                    <td>Article</td>
                    <td>Chateau</td>
                    <td>Département</td>
                    <td>Type de bouteilles</td>
                    <td>Nombre disponible</td>
                    <td>Quantité voulue</td>
                </tr>
                </thead>
                <tbody>
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
          
                </tbody>
            </table>
            </div>
            </div>
            <br />
            <input type="submit" value="Choisir" name="valid" />
        </form><br /><br />

        <table cols="1" border="1" cellpadding="1" cellspacing="1">
            <tr>
                <td>Article</td>
                <td>Chateau</td>
                <td>Type de bouteilles</td>
                <td>Quantité voulue</td>
            </tr>
            <tr>
                <td>Médoc</td>
                <td>Chateau toto</td>
                <td>Supérieur</td>
                <td>100</td>
            </tr>
        </table><br /><br />

        <a href="javascript:history.back()">Retour</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="enregistrer.html">Enregistrer</a>
    </div><br />

<jsp:include page="footer.jsp"/>