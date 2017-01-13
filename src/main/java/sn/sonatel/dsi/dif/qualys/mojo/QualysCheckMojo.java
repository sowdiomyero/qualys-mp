package sn.sonatel.dsi.dif.qualys.mojo;

import com.sun.jersey.api.client.WebResource;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import sn.sonatel.dsi.dif.qualys.xml.response.ServiceResponse;
import sn.sonatel.dsi.dif.qualys.xml.response.SummaryElement;

import javax.ws.rs.core.MediaType;

/**
 * Created by sowdiomyero on 05/01/2017.
 */

/**
 *
 * Un goal pour lancer un scan Qualys.
 *
 */
@Mojo( name = "check")
public class QualysCheckMojo extends AbstractQualysMojo {

    public static final String QUALYS_GET_WEBAPP_BY_ID      ="qps/rest/3.0/get/was/webapp";
    public static final String QUALYS_GET_SCAN_BY_ID        ="qps/rest/3.0/get/was/wasscan";

    @Override
    public void handle(WebResource.Builder builder) throws MojoExecutionException, MojoFailureException{

        try{
            builder = buildClient(getBaseResourceUrl());
            String resultat = builder.type(MediaType.APPLICATION_XML)
                    .get(String.class);
            ServiceResponse response = checkWsResponseCode(resultat, getBaseResourceUrl());

            if(response.getData() != null && response.getData() .getWebApp()!= null && response.getData() .getWebApp().getLastScan() != null){
                int idLastScan = response.getData() .getWebApp().getLastScan().getId();
                //TODO une fois l'id du dernier scan recuperé, lancer la demande de statut du dernier scan
                String scanByIdUrl = url + QUALYS_GET_SCAN_BY_ID + "/" + idLastScan;
                builder = buildClient(scanByIdUrl);
                String resultatCheck = builder.type(MediaType.APPLICATION_XML)
                                              .get(String.class);
                ServiceResponse checkResponse= checkWsResponseCode(resultatCheck, scanByIdUrl);
                String status = null;
                if(checkResponse != null && checkResponse.getData() != null && checkResponse.getData().getWasScan().getStatus() != null)

                    status = checkResponse.getData().getWasScan().getStatus().trim();
                    //Tout d'abord s'assurer que le scan est fini
                    if(status.equalsIgnoreCase("FINISHED")) {
                    //TODO verifier le resultat du scan
                        SummaryElement sum = checkResponse.getData().getWasScan().getSummary();
                        String resultsStatus = sum != null ? sum.getResultsStatus() : "";
                        if( resultsStatus != null && resultsStatus.equalsIgnoreCase("SUCCESSFUL")){
                            getLog().info("SUCCESSFUL, Le scan de vulnerabilite s'est bien deroule .....");
                        }else{
                            throw new MojoExecutionException("Le SCAN de Vulnerabilité de votre application a echoue, approchez vous des ingénieurs securite ");
                        }

                    }else{
                        throw new MojoExecutionException("Le SCAN de Vulnerabilite de votre application n'est pas encore termine. Le statut actuel est  "+status);
                    }
            }else{
                throw new MojoExecutionException("Impossible de recuperer le resultat du dernier scan pour cette application. \" +\n" +
                        "                        \"\n" +
                        "Assurez vous qu'un scan a deja ete réalise sur cette application.\n");

            }
        }catch (Exception e) {
            throw new MojoExecutionException("Une Exception s'est produite pendant l'execution du Goal SCAN ", e);
        }
    }


    @Override
    public String getBaseResourceUrl() {
        //https://qualysapi.qualys.com/qps/rest/3.0/get/was/webapp/107674200
        return url + QUALYS_GET_WEBAPP_BY_ID + "/"+ getAppId();
    }
}
