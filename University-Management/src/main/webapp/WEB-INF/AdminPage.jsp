<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html style="font-size: 16px;" lang="fr"><head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8">
    <meta name="keywords" content="INTUITIVE">
    <meta name="description" content="">
    <title>Page 1</title>
 <link rel="stylesheet" href="<%request.getContextPath() ;%>nicepage.css" media="screen">
	<link rel="stylesheet" href="<% request.getContextPath() ;%>AdminPage.css" media="screen">
	<link rel="stylesheet" href="button.css" media="screen">
    <script class="u-script" type="text/javascript" src="<%request.getContextPath() ; %>jquery.js" defer=""></script>
    <script class="u-script" type="text/javascript" src="<% request.getContextPath() ;%>nicepage.js" defer=""></script>
    <meta name="generator" content="Nicepage 4.20.1, nicepage.com">
    <link id="u-theme-google-font" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,500,500i,600,600i,700,700i,800,800i">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    
    <script type="application/ld+json">{
		"@context": "http://schema.org",
		"@type": "Organization",
		"name": ""
}</script>
    <meta name="theme-color" content="#478ac9">
    <meta property="og:title" content="Page 1">
    <meta property="og:type" content="website">
  </head>
  <body class="u-body u-xl-mode" data-lang="fr"><header class="u-clearfix u-custom-color-1 u-header u-header" id="sec-dea1"><div class="u-clearfix u-sheet u-sheet-1">
        <img class="u-expanded-height u-image u-image-circle u-image-contain u-preserve-proportions u-image-1" src="images/Untitled400400px1.png" alt="" data-image-width="400" data-image-height="400">
       <a href="IndexPage" class="u-border-none u-btn u-button-style u-none u-text-custom-color-3 u-btn-1">.</a>
      </div></header>
     
    <section class="u-align-center u-clearfix u-image u-shading u-section-1" src="" id="sec-96eb" data-image-width="1920" data-image-height="1080">
                    <% 
					            if( session.getAttribute("EtudiantAjouter")!= null ){
		                 			out.println("<div class='container'>");
		                 			out.println(" <div  class='alert alert-success my-2 text-center' role='alert' >");
					                out.println( session.getAttribute("EtudiantAjouter") );
						            out.println("</div>");
								    out.println("</div>");
					            } %>
	 <a href="Logout" class="u-btn u-btn-round u-button-style u-hover-palette-1-light-1 u-palette-1-base  u-btn-6">Se deconnecter</a>					            
      <a href="Inscription" class="u-btn u-button-style u-palette-4-base u-btn-1" target="_blank">Inscrire un etudiant</a>
      <a href="Matricule" class="u-btn u-button-style u-palette-2-base u-btn-2" target="_blank">Rechercher etudiant par matricule</a>
      <a href="Nom-prenom" class="u-btn u-button-style u-palette-2-base u-btn-3" target="_blank">Rechercher etudiant par nom et prenom</a>
      <a href="Nom" class="u-btn u-button-style u-palette-2-base u-btn-4" target="_blank">Rechercher etudiant par nom</a>
      <a href="AfficherComptes" class="u-btn u-button-style u-hover-palette-1-dark-1 u-palette-1-base u-btn-5">AFFICHER LISTES COMPTES</a>
    </section>
    
    
    <footer class="u-align-center u-clearfix u-footer u-grey-80 u-footer" id="sec-3f85"><div class="u-clearfix u-sheet u-sheet-1">
        <p class="u-small-text u-text u-text-variant u-text-1">Droit reservées au binome Mahcene &amp; Mahroug</p>
      </div></footer>
    <section class="u-backlink u-clearfix u-grey-80">
      
        <span>Website Templates</span>
      
    </section>
    <% session.removeAttribute("EtudiantAjouter");%>
</body></html>