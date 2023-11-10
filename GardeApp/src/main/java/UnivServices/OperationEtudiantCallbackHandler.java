
/**
 * OperationEtudiantCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package UnivServices;

    /**
     *  OperationEtudiantCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class OperationEtudiantCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public OperationEtudiantCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public OperationEtudiantCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for rechercheByMatricule method
            * override this method for handling normal response from rechercheByMatricule operation
            */
           public void receiveResultrechercheByMatricule(
                    UnivServices.OperationEtudiantStub.RechercheByMatriculeResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from rechercheByMatricule operation
           */
            public void receiveErrorrechercheByMatricule(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getFaculté method
            * override this method for handling normal response from getFaculté operation
            */
           public void receiveResultgetFaculté(
                    UnivServices.OperationEtudiantStub.GetFacultéResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getFaculté operation
           */
            public void receiveErrorgetFaculté(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for verifierEtudiant method
            * override this method for handling normal response from verifierEtudiant operation
            */
           public void receiveResultverifierEtudiant(
                    UnivServices.OperationEtudiantStub.VerifierEtudiantResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from verifierEtudiant operation
           */
            public void receiveErrorverifierEtudiant(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for authentificationGarde method
            * override this method for handling normal response from authentificationGarde operation
            */
           public void receiveResultauthentificationGarde(
                    UnivServices.OperationEtudiantStub.AuthentificationGardeResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from authentificationGarde operation
           */
            public void receiveErrorauthentificationGarde(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for rechercheByName method
            * override this method for handling normal response from rechercheByName operation
            */
           public void receiveResultrechercheByName(
                    UnivServices.OperationEtudiantStub.RechercheByNameResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from rechercheByName operation
           */
            public void receiveErrorrechercheByName(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for inscription method
            * override this method for handling normal response from inscription operation
            */
           public void receiveResultinscription(
                    UnivServices.OperationEtudiantStub.InscriptionResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from inscription operation
           */
            public void receiveErrorinscription(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for rechercheByNomPrenom method
            * override this method for handling normal response from rechercheByNomPrenom operation
            */
           public void receiveResultrechercheByNomPrenom(
                    UnivServices.OperationEtudiantStub.RechercheByNomPrenomResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from rechercheByNomPrenom operation
           */
            public void receiveErrorrechercheByNomPrenom(java.lang.Exception e) {
            }
                


    }
    