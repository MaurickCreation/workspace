<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="xml.XPath" %>
<%@page import="donnees.*" %>
<%@page import="java.util.*" %>
<jsp:include page="header.jsp"/>

<% //récupération des paramètres

String idAppellation = request.getParameter("appellation");

String idDep = request.getParameter("dep");
String idChateau = request.getParameter("chateau");

//recherche de la liste des bouteilles

%>
         <div class="fullcolumn">
    <h1>Notre catalogue de grands crus</h1>
	<p><img width="400" heigth="350" src="images/SA400013.JPG" /></p>

        <form name="form1" method="post" action="commande.jsp">
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
            <input type="submit" value="Rechercher" name="valid" />
        </form><br />

        <form name="form2" method="post" action="">
           <div class="outer">
			<div class="innera">
            <table cols="1" border="1" cellpadding="1" cellspacing="1">
               <thead>
                <tr>
                    <td>Appellation</td>
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
                <td>Appellation</td>
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