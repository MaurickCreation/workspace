<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="xml.XPath" %>
<%@page import="java.util.*" %>

<% //récupération des paramètres

String idAppellation = request.getParameter("appellation");
String nb = request.getParameter("cuvee");
String idChateau = request.getParameter("chateau");

//recherche de la liste des bouteilles

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<% String titre="Gestiond'une cave / Ajout de bouteilles"; %>
<html>

<head>
<title><%= titre %></title>
<meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
<meta name="generator" content="HAPedit 3.1">
</head>

<body bgcolor="#FFFFFF">
<h1>Ajouter des bouteilles</h1><br />
<form name="form1" method="post" action="ajout.jsp">
      <select name="appellation" size="1">
              <%  List appellation = new ArrayList();
                appellation = XPath.comboAppellation();
                for(int i = 0; i < appellation.size(); i = i+2){
                    out.println("<option value='" + appellation.get(i) + "'>" + appellation.get(i+1) + "</option>");
                }
            %>
      </select>&nbsp;&nbsp;&nbsp;&nbsp;
      <select name="chateau" size="1">
              <%  List chateau = new ArrayList();
                chateau = XPath.comboChateau();
                for(int i = 0; i < chateau.size(); i=i+2){
                    out.println("<option value='" + chateau.get(i) + "'>" + chateau.get(i+1) + "</option>");
                }
            %>
      </select>&nbsp;&nbsp;&nbsp;&nbsp;
     Nb bouteilles &lt; <input type="text" name="cuvee" size="4" maxlength="4" />
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
<a href="javascript:history.back()">Retour</a

</body>
</html>