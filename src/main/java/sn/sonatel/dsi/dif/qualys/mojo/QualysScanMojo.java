package sn.sonatel.dsi.dif.qualys.mojo;

import com.sun.jersey.api.client.WebResource;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import sn.sonatel.dsi.dif.qualys.xml.JaxbSerializerUtils;
import sn.sonatel.dsi.dif.qualys.xml.response.RESULT_CODE;
import sn.sonatel.dsi.dif.qualys.xml.response.ServiceResponse;

import javax.ws.rs.core.MediaType;

/**
 * Created by sowdiomyero on 05/01/2017.
 */

/**
 *
 * Un goal pour lancer un scan Qualys.
 *
 */
@Mojo( name = "scan")
public class QualysScanMojo extends AbstractQualysMojo {

    @Override
    public void handle(WebResource.Builder builder) throws MojoExecutionException, MojoFailureException{

        try{
            getLog().info("Demande de scan reçu avec les parametres suivants : URL [ "+url+" ] , USERNAME : [ "+getUsername()+" ]");
            String request = JaxbSerializerUtils.parseRequestToString(getAppId());

            getLog().info("Emplacement de la requête : \n" + request);

            String xmlResponse = builder
                    .type(MediaType.APPLICATION_XML)
                    //.accept(MediaType.TEXT_XML)
                    .entity(request)
                    .post(String.class);
            ServiceResponse serviceResponse = JaxbSerializerUtils.parseResponse(xmlResponse);
            if( serviceResponse.getResponseCode() != null && serviceResponse.getResponseCode().trim().equalsIgnoreCase( RESULT_CODE.SUCCESS.toString())){
                getLog().info("Le scan a ete Lancé avec succes avec l'id scan suivant : "+serviceResponse.getData().getWasScan().getId());
            }else{
                getLog().error("Une erreur est parvenue pendant le traitement de la demande de Scan de vulnerabilité");
                if(serviceResponse.getResponseCode() != null){
                    getLog().error("Code de retour : "+serviceResponse.getResponseCode());
                    getLog().error("Message erreur : "+serviceResponse.getResponseErrorDetails().getErrorMessage());
                }else{
                    getLog().error("Aucun contenu n'a été retourné par Qualys à l'appel WebService : "+getBaseResourceUrl() +" avec les parametres suivants : "+request);
                    throw new MojoExecutionException("Une Exception s'est produite pendant l'execution du Goal SCAN : \n Reponse reçue du serveur : "+xmlResponse);
                }

            }

        }catch (Exception e) {
            throw new MojoExecutionException("Une Exception s'est produite pendant l'execution du Goal SCAN ", e);
        }
    }

    @Override
    public String getBaseResourceUrl() {
        return getUrl()+QUALYS_POST_NEW_SCAN;
    }
}
