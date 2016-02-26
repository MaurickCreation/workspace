<?xml version="1.0" encoding="iso-8859-1"?>
<!DOCTYPE html 
     PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
     "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>LalahMode</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />

<script type="text/javascript">

var browserName=navigator.appName; 
if (browserName=="Microsoft Internet Explorer")
{ 
document.write('<link rel="stylesheet" href="styles/stylesheet.css" type="text/css">')
}
else {
document.write('<link rel="stylesheet" href="styles/stylesheet_ns.css" type="text/css">')
}

</script>

<SCRIPT language="JavaScript">
function control(form){
    var ok = true;
        for(i=0;i<form.elements.length;i++){
            if(form.elements[i].value=="") {
            	ok = false;
            }
        }
        if (ok) {
        	form.submit();
        } else {
        	alert("Vous devez remplir tous les champs.");
        }
    }
</SCRIPT>

</head>
<body>
<div class="wrapper">
  <div class="logobkg"><img src="images/logo_new.png" alt="logo"/></div>
  <div class="navbar">
    <div class="buttons">
    <%
    if (session.getAttribute("role").equals("")) {
    	out.println("<a href=\"accueil.jsp\">Accueil</a>");
    	out.println("<a href=\"catalogue.jsp\">Catalogue</a>");
    	out.println("<a href=\"connexion.jsp?erreur=\">Connexion / Inscription</a>");
    } else {
    	if (session.getAttribute("role").equals("admin")) {
    		out.println("<a href=\"accueil.jsp\">Administration</a>");
    		out.println("<a href=\"etat_cave.jsp\">Etat de la cave</a>");
    		out.println("<a href=\"saisie.jsp\">Ajouter des bouteilles</a>");
    		out.println("<a href=\"index.jsp\" style=\"float:right\">Deconnexion</a>");
    	} else {
    		out.println("<a href=\"accueil.jsp\">Accueil</a>");
    		out.println("<a href=\"catalogue.jsp\">Catalogue</a>");
    		out.println("<a href=\"commandes.jsp\">Mes commandes</a>");
    		out.println("<a href=\"index.jsp\" style=\"float:right\">Deconnexion</a>");
    	}
    }
    %>
    </div>
  </div>
<!--<div class="subnav"></div>-->