<!DOCTYPE html>
<html style="font-size: 16px;" lang="fr"><head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8">
    <meta name="keywords" content="INTUITIVE">
    <meta name="description" content="">
    <title>CreerCompte</title>
    <link rel="stylesheet" href="nicepage.css" media="screen">
<link rel="stylesheet" href="AjouterCompte.css" media="screen">
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
    <meta property="og:title" content="CreerCompte">
    <meta property="og:type" content="website">
  </head>
  <body class="u-body u-xl-mode" data-lang="fr"><header class="u-clearfix u-custom-color-1 u-header u-header" id="sec-dea1"><div class="u-clearfix u-sheet u-sheet-1">
        <img class="u-expanded-height u-image u-image-circle u-image-contain u-preserve-proportions u-image-1" src="images/Untitled400400px1.png" alt="" data-image-width="400" data-image-height="400">
       <a href="IndexPage" class="u-border-none u-btn u-button-style u-none u-text-custom-color-3 u-btn-1">.</a>
      </div></header>
    <section class="u-align-center u-clearfix u-image u-shading u-section-1" id="carousel_4b50" data-image-width="1920" data-image-height="1080">
      <div class="u-clearfix u-sheet u-sheet-1">
        <div class="u-clearfix u-gutter-0 u-layout-wrap u-layout-wrap-1">
          <div class="u-layout">
            <div class="u-layout-row">
              <div class="u-align-left u-container-style u-layout-cell u-palette-5-dark-3 u-shape-rectangle u-size-60 u-layout-cell-1">
                <div class="u-container-layout u-container-layout-1">
                  <div class="u-align-left u-form u-form-1">
                    <form action="AjouterCompte.do" method="POST" class="u-clearfix u-form-spacing-12 u-form-vertical u-inner-form" style="padding: 0px;" source="email" name="form">
                      			<% 
					            if( session.getAttribute("AdminExiste")!= null ){
		                 			out.println("<div class='container'>");
		                 	        out.println(" <div  class='alert alert-danger my-2 text-center' role='alert' >");
					                out.println( session.getAttribute("AdminExiste") );
						            out.println("</div>");
								    out.println("</div>");
					            } %>
                      <div class="u-form-group u-label-top u-form-group-1">
                        <label for="text-94e1" class="u-label">Nom</label>
                        <input type="text" placeholder="" id="text-94e1" name="nom" class="u-border-5 u-border-grey-75 u-border-no-left u-border-no-right u-border-no-top u-input u-input-rectangle u-text-palette-4-base u-input-1">
                      </div>
                      <div class="u-form-group u-label-top u-form-group-2">
                        <label for="text-8ee3" class="u-label">Prenom</label>
                        <input type="text" placeholder="" id="text-8ee3" name="prenom" class="u-border-5 u-border-grey-75 u-border-no-left u-border-no-right u-border-no-top u-input u-input-rectangle u-text-palette-4-base u-input-2">
                      </div>
                      <div class="u-form-email u-form-group u-label-top u-form-group-3">
                        <label for="email-f76a" class="u-label">Email</label>
                        <input type="email" placeholder="Saisir une adresse mail valide" id="email-f76a" name="email" class="u-border-5 u-border-grey-75 u-border-no-left u-border-no-right u-border-no-top u-input u-input-rectangle u-text-palette-4-base u-input-3" required="">
                      </div>
                      <div class="u-form-group u-label-top u-form-group-4">
                        <label for="text-2e50" class="u-label">Mot de passe</label>
                        <input type="text" placeholder="Saisir votre mot de passe" id="text-2e50" name="pwd" class="u-border-5 u-border-grey-75 u-border-no-left u-border-no-right u-border-no-top u-input u-input-rectangle u-text-palette-4-base u-input-4">
                      </div>
                      <div class="u-form-group u-form-select u-label-top u-form-group-5">
                        <label for="select-28cc" class="u-label">Type</label>
                        <div class="u-form-select-wrapper">
                          <select id="select-28cc" name="type" class="u-border-5 u-border-grey-75 u-border-no-left u-border-no-right u-border-no-top u-input u-input-rectangle u-text-palette-4-base u-input-5">
                            <option value="admin">Admin</option>
                            <option value="agent">Agent</option>
                          </select>
                          <svg class="u-caret u-caret-svg u-text-palette-4-base" version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" width="16px" height="16px" viewBox="0 0 16 16" style="fill:currentColor;" xml:space="preserve"><polygon class="st0" points="8,12 2,4 14,4 "></polygon></svg>
                        </div>
                      </div>
                      <div class="u-form-group u-form-select u-label-top u-form-group-6">
                        <label for="select-714e" class="u-label">Université</label>
                        <div class="u-form-select-wrapper">
                          <select id="select-714e" name="Univ" class="u-border-5 u-border-grey-75 u-border-no-left u-border-no-right u-border-no-top u-input u-input-rectangle u-text-palette-4-base u-input-6">
                            <option value="1">Abdelhamid Mehri</option>
                          </select>
                          <svg class="u-caret u-caret-svg u-text-palette-4-base" version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" width="16px" height="16px" viewBox="0 0 16 16" style="fill:currentColor;" xml:space="preserve"><polygon class="st0" points="8,12 2,4 14,4 "></polygon></svg>
                        </div>
                      </div>
                      <div class="u-align-right u-form-group u-form-submit u-label-top">
                        <button class="u-active-palette-1-light-3 u-border-none u-btn u-btn-round u-btn-submit u-button-style u-hover-palette-1-light-2 u-palette-1-base u-radius-50 u-text-active-white u-text-body-alt-color u-text-hover-white u-btn-1">Creer compte<br>
                        </button>
                        <input type="submit" value="submit" class="u-form-control-hidden">
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
  <%session.removeAttribute("AdminExiste"); %>
</body></html>