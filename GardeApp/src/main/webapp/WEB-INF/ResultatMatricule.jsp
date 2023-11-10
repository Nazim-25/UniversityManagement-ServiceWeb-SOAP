<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ page  import="UnivServices.OperationEtudiantStub"%>
     <%@ page  import="UnivServices.OperationEtudiantStub.Faculté"%>
     <%@ page  import="UnivServices.OperationEtudiantStub.Etudiant"%>
     <%@ page  import="java.util.List"%>
     
<!DOCTYPE html>
<html style="font-size: 16px;" lang="fr"><head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8">
    <meta name="keywords" content="INTUITIVE">
    <meta name="description" content="">
    <title>Résultat</title>
    <link rel="stylesheet" href="nicepage.css" media="screen">
	<link rel="stylesheet" href="Résultat.css" media="screen">
	<link rel="stylesheet" href="button.css" media="screen">
    <script class="u-script" type="text/javascript" src="jquery.js" defer=""></script>
    <script class="u-script" type="text/javascript" src="nicepage.js" defer=""></script>
    <meta name="generator" content="Nicepage 4.20.1, nicepage.com">
    <link id="u-theme-google-font" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,500,500i,600,600i,700,700i,800,800i">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    
    <script type="application/ld+json">{
		"@context": "http://schema.org",
		"@type": "Organization",
		"name": ""
}</script>
    <meta name="theme-color" content="#478ac9">
    <meta property="og:title" content="Résultat">
    <meta property="og:type" content="website">
  </head>

   
  <body class="u-body u-xl-mode" data-lang="fr"><header class="u-clearfix u-custom-color-1 u-header u-header" id="sec-dea1"><div class="u-clearfix u-sheet u-sheet-1">
        <img class="u-expanded-height u-image u-image-circle u-image-contain u-preserve-proportions u-image-1" src="images/Untitled400400px1.png" alt="" data-image-width="400" data-image-height="400">
        <a href="IndexPage" class="u-border-none u-btn u-button-style u-none u-text-custom-color-3 u-btn-1">.</a>
      </div></header>
    <section class="u-align-center u-clearfix u-image u-shading u-section-1" src="" id="sec-96eb" data-image-width="1920" data-image-height="1080">
     						
      <div class="u-table u-table-responsive u-table-1">
        					<% 
					            if( session.getAttribute("EmptyList")!= null ){
		                 			out.println("<div class='container'>");
		                 	        out.println(" <div  class='alert alert-danger my-2 text-center' role='alert' >");
					                out.println( session.getAttribute("EmptyList") );
						            out.println("</div>");
								    out.println("</div>");
					            } %>
        <table class="u-table-entity">
          <colgroup>
            <col width="25%">
            <col width="25%">
            <col width="25%">
            <col width="25%">
          </colgroup>
          <thead class="u-palette-4-base u-table-header u-table-header-1">
            <tr style="height: 46px;">
              <th class="u-border-1 u-border-palette-4-base u-table-cell">Matricule</th>
              <th class="u-border-1 u-border-palette-4-base u-table-cell">Nom</th>
              <th class="u-border-1 u-border-palette-4-base u-table-cell">Prénom</th>
              <th class="u-border-1 u-border-palette-4-base u-table-cell">Faculté</th>
            </tr>
          </thead>
          <tbody class="u-table-body">
			<%
					if(session.getAttribute("Etudiant1")!= null){
					Etudiant etu1 = (Etudiant)session.getAttribute("Etudiant1"); 
						 out.println("<tr style='height: 69px;'>");
						 out.println(" <td class='u-border-1 u-border-grey-30 u-first-column u-grey-5 u-table-cell u-table-cell-5'>"); out.println(etu1.getMatricule());  out.println("</td>");
						 out.println("<td class='u-border-1 u-border-grey-30 u-table-cell'>"); out.println(etu1.getNom());  out.println("</td>");
						 out.println(" <td class='u-border-1 u-border-grey-30 u-table-cell'>"); out.println(etu1.getPrenom());  out.println("</td>");
						 out.println( "<td class='u-border-1 u-border-grey-30 u-table-cell'>"); out.println(etu1.getFaculté().getNomFaculté());  out.println("</td>");
						 out.println(" </tr>");
						
					}
			%>
          </tbody>
        </table>
      </div>
    </section>
    
    
    <footer class="u-align-center u-clearfix u-footer u-grey-80 u-footer" id="sec-3f85"><div class="u-clearfix u-sheet u-sheet-1">
        <p class="u-small-text u-text u-text-variant u-text-1">Droit reservées au binome Mahcene &amp; Mahroug</p>
      </div></footer>
    <section class="u-backlink u-clearfix u-grey-80">
      <a class="u-link" href="https://nicepage.com/html-templates" target="_blank">
        <span>HTML Template</span>
      </a>
      <p class="u-text">
        <span>created with</span>
      </p>
      <a class="u-link" href="https://nicepage.com/html-website-builder" target="_blank">
        <span>HTML Website Builder</span>
      </a>. 
    </section>
    
    <%session.removeAttribute("Etudiant1");%>
    <%session.removeAttribute("EmptyList");%>
</body></html>