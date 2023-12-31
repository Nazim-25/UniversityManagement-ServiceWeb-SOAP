<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html style="font-size: 16px;" lang="fr"><head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8">
    <meta name="keywords" content="INTUITIVE">
    <meta name="description" content="">
    <title>Inscription</title>
    <link rel="stylesheet" href="nicepage.css" media="screen">
	<link rel="stylesheet" href="Inscription.css" media="screen">
    <link rel="stylesheet" href="button.css" media="screen">
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
    <meta property="og:title" content="Inscription">
    <meta property="og:type" content="website">
  </head>
  <body class="u-body u-xl-mode" data-lang="fr"><header class="u-clearfix u-custom-color-1 u-header u-header" id="sec-dea1"><div class="u-clearfix u-sheet u-sheet-1">
        <img class="u-expanded-height u-image u-image-circle u-image-contain u-preserve-proportions u-image-1" src="images/Untitled400400px1.png" alt="" data-image-width="400" data-image-height="400">
       <a href="IndexPage" class="u-border-none u-btn u-button-style u-none u-text-custom-color-3 u-btn-1">.</a>
      </div></header>
    <section class="u-align-center u-clearfix u-image u-shading u-section-1" id="carousel_4b50" data-image-width="1620" data-image-height="1080">
      <div class="u-clearfix u-sheet u-sheet-1">
        <div class="u-clearfix u-gutter-0 u-layout-wrap u-layout-wrap-1">
          <div class="u-layout">
            <div class="u-layout-row">
              <div class="u-align-left u-container-style u-layout-cell u-palette-5-dark-3 u-shape-rectangle u-size-60 u-layout-cell-1">
                <div class="u-container-layout u-container-layout-1">
                  <div class="u-align-left u-form u-form-1">
                    <form action="InscriptionsG" method="POST" class="u-clearfix u-form-spacing-12 u-form-vertical u-inner-form" style="padding: 0px;" source="email" name="form">
                      <div class="u-form-group u-form-name u-label-top">
                      <div class="u-table u-table-responsive u-table-1">
	        					<% 
					            if( session.getAttribute("MatriculeExiste")!= null ){
		                 			out.println("<div class='container'>");
		                 	        out.println(" <div  class='alert alert-danger my-2 text-center' role='alert' >");
					                out.println( session.getAttribute("MatriculeExiste") );
						            out.println("</div>");
								    out.println("</div>");
					            } %>
                        <label for="name-5a14" class="u-label">Nom</label>
                        <input type="text" id="name-5a14" name="nom" class="u-border-5 u-border-grey-75 u-border-no-left u-border-no-right u-border-no-top u-input u-input-rectangle u-text-palette-4-base u-input-1" required="">
                      </div>
                      <div class="u-form-email u-form-group u-label-top">
                        <label for="email-5a14" class="u-label">Prenom</label>
                        <input type="text" id="email-5a14" name="prenom" class="u-border-5 u-border-grey-75 u-border-no-left u-border-no-right u-border-no-top u-input u-input-rectangle u-text-palette-4-base u-input-2" required="">
                      </div>
                      <div class="u-form-group u-form-select u-label-top u-form-group-3">
                        <label for="select-f84f" class="u-label">Sexe</label>
                        <div class="u-form-select-wrapper">
                          <select id="select-f84f" name="sexe" class="u-border-5 u-border-grey-75 u-border-no-left u-border-no-right u-border-no-top u-input u-input-rectangle u-text-palette-4-base u-input-3">
                            <option value="homme">Homme</option>
                            <option value="femme">Femme</option>
                          </select>
                          <svg class="u-caret u-caret-svg u-text-palette-4-base" version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" width="16px" height="16px" viewBox="0 0 16 16" style="fill:currentColor;" xml:space="preserve"><polygon class="st0" points="8,12 2,4 14,4 "></polygon></svg>
                        </div>
                      </div>
                      <div class="u-form-group u-label-top u-form-group-4">
                        <label for="text-24f2" class="u-label">Matricule</label>
                        <input type="text" placeholder="" id="text-24f2" name="matricule" class="u-border-5 u-border-grey-75 u-border-no-left u-border-no-right u-border-no-top u-input u-input-rectangle u-text-palette-4-base u-input-4" maxlength="12">
                      </div>
                      <div class="u-form-date u-form-group u-label-top u-form-group-5">
                        <label for="date-e4e4" class="u-label">Date de naissance</label>
                        <input type="date" placeholder="MM/JJ/AAAA" id="date-e4e4" name="dateN" class="u-border-5 u-border-grey-75 u-border-no-left u-border-no-right u-border-no-top u-input u-input-rectangle u-text-palette-4-base u-input-5" required="">
                      </div>
                      <div class="u-form-group u-label-top u-form-group-6">
                        <label for="text-769e" class="u-label u-label-6">Prenom Pere</label>
                        <input type="text" placeholder="" id="text-769e" name="prenomP" class="u-border-5 u-border-grey-75 u-border-no-left u-border-no-right u-border-no-top u-input u-input-rectangle u-text-palette-4-base u-input-6">
                      </div>
                      <div class="u-form-group u-label-top u-form-group-7">
                        <label for="text-06ec" class="u-label">Nom Mere</label>
                        <input type="text" placeholder="" id="text-06ec" name="nomM" class="u-border-5 u-border-grey-75 u-border-no-left u-border-no-right u-border-no-top u-input u-input-rectangle u-text-palette-4-base u-input-7">
                      </div>
                      <div class="u-form-group u-label-top u-form-group-8">
                        <label for="text-7a0d" class="u-label">Prenom Mere</label>
                        <input type="text" placeholder="" id="text-7a0d" name="prenomM" class="u-border-5 u-border-grey-75 u-border-no-left u-border-no-right u-border-no-top u-input u-input-rectangle u-text-palette-4-base u-input-8">
                      </div>
                      <div class="u-form-group u-form-select u-label-top u-form-group-9">
                        <label for="select-72ac" class="u-label">Formation</label>
                        <div class="u-form-select-wrapper">
                          <select id="select-72ac" name="formation" class="u-border-5 u-border-grey-75 u-border-no-left u-border-no-right u-border-no-top u-input u-input-rectangle u-text-palette-4-base u-input-9">
                            <option value="1">Informatique</option>
                            <option value="2">Sciences Eco</option>
                          </select>
                          <svg class="u-caret u-caret-svg u-text-palette-4-base" version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" width="16px" height="16px" viewBox="0 0 16 16" style="fill:currentColor;" xml:space="preserve"><polygon class="st0" points="8,12 2,4 14,4 "></polygon></svg>
                        </div>
                      </div>
                      <div class="u-form-group u-form-select u-label-top u-form-group-10">
                        <label for="select-be6e" class="u-label">Faculté</label>
                        <div class="u-form-select-wrapper">
                          <select id="select-be6e" name="faculté" class="u-border-5 u-border-grey-75 u-border-no-left u-border-no-right u-border-no-top u-input u-input-rectangle u-text-palette-4-base u-input-10">
                            <option value="1">Nouvelles technologies</option>
                            <option value="2">bibliothéconomie</option>
                           
                          </select>
                          <svg class="u-caret u-caret-svg u-text-palette-4-base" version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" width="16px" height="16px" viewBox="0 0 16 16" style="fill:currentColor;" xml:space="preserve"><polygon class="st0" points="8,12 2,4 14,4 "></polygon></svg>
                        </div>
                      </div>
                      <div class="u-form-group u-form-select u-label-top u-form-group-11">
                        <label for="select-0125" class="u-label">Departement</label>
                        <div class="u-form-select-wrapper">
                          <select id="select-0125" name="deparatement" class="u-border-5 u-border-grey-75 u-border-no-left u-border-no-right u-border-no-top u-input u-input-rectangle u-text-palette-4-base u-input-11">
                            <option value="1">TLSI</option>
                            <option value="2">MI</option>
                             <option value="3">IFA</option>
                          </select>
                          <svg class="u-caret u-caret-svg u-text-palette-4-base" version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" width="16px" height="16px" viewBox="0 0 16 16" style="fill:currentColor;" xml:space="preserve"><polygon class="st0" points="8,12 2,4 14,4 "></polygon></svg>
                        </div>
                      </div>
                      <div class="u-form-group u-form-select u-label-top u-form-group-12">
                        <label for="select-8ac5" class="u-label u-label-12">Specialité</label>
                        <div class="u-form-select-wrapper">
                          <select id="select-8ac5" name="specialité" class="u-border-5 u-border-grey-75 u-border-no-left u-border-no-right u-border-no-top u-input u-input-rectangle u-text-palette-4-base u-input-12">
                            <option value="1">GL</option>
                            <option value="2">RSD</option>
                            <option value="3">STIC</option>
                            <option value="4">SITW</option>
                          </select>
                          <svg class="u-caret u-caret-svg u-text-palette-4-base" version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" width="16px" height="16px" viewBox="0 0 16 16" style="fill:currentColor;" xml:space="preserve"><polygon class="st0" points="8,12 2,4 14,4 "></polygon></svg>
                        </div>
                      </div>
                      <div class="u-form-group u-form-select u-label-top u-form-group-13">
                        <label for="select-ba3d" class="u-label">Niveau</label>
                        <div class="u-form-select-wrapper">
                          <select id="select-ba3d" name="niveau" class="u-border-5 u-border-grey-75 u-border-no-left u-border-no-right u-border-no-top u-input u-input-rectangle u-text-palette-4-base u-input-13">
                            <option value="1">L1</option>
                            <option value="2">L2</option>
                            <option value="3">L3</option>
                            <option value="4">M1</option>
                            <option value="5">M2</option>
                          </select>
                          <svg class="u-caret u-caret-svg u-text-palette-4-base" version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" width="16px" height="16px" viewBox="0 0 16 16" style="fill:currentColor;" xml:space="preserve"><polygon class="st0" points="8,12 2,4 14,4 "></polygon></svg>
                        </div>
                      </div>
                      <div class="u-form-group u-form-select u-label-top u-form-group-14">
                        <label for="select-7d00" class="u-label">Université</label>
                        <div class="u-form-select-wrapper">
                          <select id="select-7d00" name="university" class="u-border-5 u-border-grey-75 u-border-no-left u-border-no-right u-border-no-top u-input u-input-rectangle u-text-palette-4-base u-input-14">
                            <option value="1">Abdelhamid Mehri</option>
                           
                          </select>
                          <svg class="u-caret u-caret-svg u-text-palette-4-base" version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" width="16px" height="16px" viewBox="0 0 16 16" style="fill:currentColor;" xml:space="preserve"><polygon class="st0" points="8,12 2,4 14,4 "></polygon></svg>
                        </div>
                      </div>
                      <div class="u-form-date u-form-group u-label-top u-form-group-15">
                        <label for="date-0616" class="u-label">Date derniere inscription</label>
                        <input type="date" placeholder="MM/JJ/AAAA" id="date-0616" name="dateins" class="u-border-5 u-border-grey-75 u-border-no-left u-border-no-right u-border-no-top u-input u-input-rectangle u-text-palette-4-base u-input-15" required="">
                      </div>
                      <div class="u-align-right u-form-group u-form-submit u-label-top">
                        
                        <button  type="submit" value="submit" class="u-btn u-btn-submit u-button-style">Inscrire</button>
                      </div>
                      <div class="u-form-send-message u-form-send-success"> Thank you! Your message has been sent. </div>
                      <div class="u-form-send-error u-form-send-message"> Unable to send your message. Please fix errors then try again. </div>
                      <input type="hidden" value="" name="recaptchaResponse">
                      <input type="hidden" name="formServices" value="">
                    </form>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      
    </section>
    
    
    <footer class="u-align-center u-clearfix u-footer u-grey-80 u-footer" id="sec-3f85"><div class="u-clearfix u-sheet u-sheet-1">
        <p class="u-small-text u-text u-text-variant u-text-1">Droit reservées au binome Mahcene &amp; Mahroug</p>
      </div></footer>
    <section class="u-backlink u-clearfix u-grey-80">
      <a class="u-link" href="https://nicepage.com/website-templates" target="_blank">
        <span>Website Templates</span>
      </a>
      <p class="u-text">
        <span>created with</span>
      </p>
      <a class="u-link" href="" target="_blank">
        <span>Website Builder Software</span>
      </a>. 
    </section>
  <%session.removeAttribute("MatriculeExiste"); %>
</body></html>