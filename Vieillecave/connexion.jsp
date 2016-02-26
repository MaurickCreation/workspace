<jsp:include page="header.jsp"/>

  <div class="fullcolumn"> 
  <%
  if (request.getParameter("erreur").equals("1")) out.println("<br/><div class=\"erreur\">Erreur lors de l'enregistrement du fichier.</div><br/>");
  if (request.getParameter("erreur").equals("2")) out.println("<br/><div class=\"erreur\">Erreur lors de l'ajout.</div><br/>");
  if (request.getParameter("erreur").equals("3")) out.println("<br/><div class=\"erreur\">Login ou mot de passe incorrect.</div><br/>");
  if (request.getParameter("erreur").equals("4")) out.println("<br/><div class=\"erreur\">Ce login est d&eacute;j&agrave; utilis&eacute;. Veuillez en choisir un autre.</div><br/>");
  %>
  <br/>
    <table width="78%"  border="0" align="center" cellspacing="0">
      <tr>
        <td width="46%" valign="top"><table width="100%"  border="0" cellspacing="0" class="cadre">
          <form action="connexion2.jsp" method="get" name="connexion">
            <tr valign="middle" bgcolor="#556B2F">
              <td colspan="2"><div align="center"><strong>Connexion</strong></div></td>
            </tr>
            <tr>
              <td width="48%"><div align="right">login : </div></td>
              <td width="52%"><div align="left">
                  <input name="c_login" type="text" />
              </div></td>
            </tr>
            <tr>
              <td><div align="right">mot de passe : </div></td>
              <td><div align="left">
                  <input name="c_mdp" type="password" />
              </div></td>
            </tr>
            <tr>
              <td><div align="right"></div></td>
              <td><div align="left">
                <input type="submit" value="connexion" name="action" onClick="control(this.form)"/>
              </div></td>
            </tr>
          </form>
        </table></td>
        <td width="6%"><div align="center">&nbsp;</div></td>
        <td width="48%" valign="top"><table width="100%" border="0" cellspacing="0"  class="cadre">
          <form action="connexion2.jsp" method="post" name="inscription">
            <tr valign="middle" bgcolor="#556B2F">
              <td colspan="2"><div align="center"><strong>Inscription</strong></div></td>
            </tr>
            <tr>
              <td width="39%"><div align="right">login : </div></td>
              <td width="61%"><div align="left">
                  <input name="i_login" type="text" />
              </div></td>
            </tr>
            <tr>
              <td><div align="right">mot de passe : </div></td>
              <td><div align="left">
                  <input name="i_mdp" type="password" />
              </div></td>
            </tr>
            <tr>
              <td><div align="right">nom : </div></td>
              <td><div align="left">
                  <input name="i_nom" type="text" />
              </div></td>
            </tr>
            <tr>
              <td><div align="right">pr&eacute;nom : </div></td>
              <td><div align="left">
                  <input name="i_prenom" type="text" />
              </div></td>
            </tr>
            <tr>
              <td><div align="right">adresse : </div></td>
              <td><div align="left">
                  <input name="i_adresse" type="text" />
              </div></td>
            </tr>
            <tr>
              <td><div align="right">t&eacute;l&eacute;phone : </div></td>
              <td><div align="left">
                  <input name="i_tel" type="text" />
              </div></td>
            </tr>
            <tr>
              <td><div align="right"></div></td>
              <td><div align="left">
                <input type="submit" value="inscription" name="action" onClick="control(this.form)"/>
              </div></td>
            </tr>
          </form>
        </table></td>
      </tr>
    </table>
    <p>&nbsp;</p>
  </div>

<jsp:include page="footer.jsp"/>