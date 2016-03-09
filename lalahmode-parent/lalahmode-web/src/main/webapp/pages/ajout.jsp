<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="xml.XPath" %>
<%@page import="java.util.*" %>
<%@page import="donnees.*" %>
<jsp:include page="header.jsp"/>

<% //récupération des paramètres

String idAppellation = request.getParameter("appellation");
String nb = request.getParameter("cuvee");
String idChateau = request.getParameter("chateau");

//recherche de la liste des bouteilles

%>

<% String titre="Gestiond'une cave / Ajout de bouteilles"; %>

  <div class="fullcolumn">
<h1>Ajouter des bouteilles</h1><br />
<form name="form1" method="post" action="ajout.jsp">
 Appellation : <select name="appellation" size="1">
            <option valid="vide"></option>
      <%  XPath serv = new XPath();
            //Appellation ap = new Appellation();
                List appellation = (new Appellation()).getListAppellation();
                //appellation = XPath.comboAppellation();
                for(int i = 0; i < appellation.size(); i++){
                    Appellation tempA = (Appellation)appellation.get(i);
                    out.println("<option value='a" + tempA.getId() + "'>" + tempA.getNomAppellation() + "</option>");
                    
                    List chateau = (new Chateau()).getListChateau(tempA.getId());
                    for(int j = 0; j < chateau.size(); j++){
                        Chateau tempC = (Chateau)chateau.get(j);
                        out.println("<option value='c" + tempC.getId() + "'>&nbsp;&nbsp;&nbsp;" + tempC.getNomChateau() + "</option>");
                    }
                }
            %>
      </select>&nbsp;&nbsp;&nbsp;&nbsp;
            Département : <select name="dep" size="1">
                <%  List dep = (new Chateau()).getListDepartement();
                for(int i = 0; i < dep.size(); i++){
                    out.println("<option value='" + dep.get(i) + "'>" + dep.get(i) + "</option>");
                }
            %>
            </select><br />
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
<a href="javascript:history.back()">Retour</a>
</div>
<jsp:include page="footer.jsp"/>