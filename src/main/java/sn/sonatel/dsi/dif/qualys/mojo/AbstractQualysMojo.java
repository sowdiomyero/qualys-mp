package sn.sonatel.dsi.dif.qualys.mojo;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Parameter;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import sn.sonatel.dsi.dif.qualys.QualysAuthApi;
import sn.sonatel.dsi.dif.qualys.xml.JaxbSerializerUtils;
import sn.sonatel.dsi.dif.qualys.xml.response.RESULT_CODE;
import sn.sonatel.dsi.dif.qualys.xml.response.ServiceResponse;

import javax.xml.bind.JAXBException;
import java.util.prefs.Preferences;

/**
 * Created by sowdiomyero on 10/01/2017.
 */
public abstract class AbstractQualysMojo  extends AbstractMojo {


    public static final String QUALYS_DOWNLOAD_SCAN_BY_ID   ="qps/rest/3.0/download/was/wasscan";
    public static final String QUALYS_GET_STATUS_SCAN_BY_ID ="qps/rest/3.0/status/was/wasscan";
    public static final String QUALYS_POST_NEW_SCAN         ="qps/rest/3.0/launch/was/wasscan";
    public static final int CONNECTION_TIME_OUT = 50000;
    public static final int REQUEST_TIME_OUT = 50000;

    @Parameter( property = "qualys.url", defaultValue = "https://qualysapi.qualys.com/")
    protected String url;

    @Parameter( property = "qualys.appId", required = true)
    protected int appId;

    @Parameter(property = "skip", defaultValue = "false")
    protected boolean skip;

    @Parameter(property = "reportDirectory", defaultValue = "${project.build.outputDirectory}/qualys/")
    protected String reportDirectory;


    public void execute() throws MojoExecutionException, MojoFailureException {

        if (skip) {
            getLog().info("Skipping scan goal");
            return;
        }
        getLog().debug("Construction du client WebService avec l'url suivante : "+getBaseResourceUrl());
        handle(buildClient());
    }

    private WebResource.Builder buildClient(){
        WebResource.Builder builder = null;

        Client client = Client.create();
        client.setConnectTimeout(CONNECTION_TIME_OUT);
        client.setReadTimeout(REQUEST_TIME_OUT);

        client.addFilter(new HTTPBasicAuthFilter(getUsername(), getPassword()));
        WebResource webResource = client.resource(getBaseResourceUrl());
        builder =  webResource
                .header("X-Requested-With","Java Maven Plugin")
                .header(HttpAuthenticationFeature.HTTP_AUTHENTICATION_BASIC_USERNAME, getUsername())
                .header(HttpAuthenticationFeature.HTTP_AUTHENTICATION_BASIC_PASSWORD, getPassword());
        return builder;
    }

    public WebResource.Builder buildClient(String baseUrl){
        WebResource.Builder builder = null;

        Client client = Client.create();
        client.addFilter(new HTTPBasicAuthFilter(getUsername(), getPassword()));
        WebResource webResource = client.resource(baseUrl);
        builder =  webResource
                .header("X-Requested-With","Java Maven Plugin")
                .header(HttpAuthenticationFeature.HTTP_AUTHENTICATION_BASIC_USERNAME, getUsername())
                .header(HttpAuthenticationFeature.HTTP_AUTHENTICATION_BASIC_PASSWORD, getPassword());
        return builder;
    }

    public abstract String getBaseResourceUrl();
    public abstract void handle(WebResource.Builder builder) throws MojoExecutionException, MojoFailureException;

    public String getUsername() {
        return QualysAuthApi.getUsername();
    }

    public String getPassword() {
        return QualysAuthApi.getPassword();
    }


    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public String getReportDirectory() {
        return reportDirectory;
    }

    public void setReportDirectory(String reportDirectory) {
        this.reportDirectory = reportDirectory;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ServiceResponse checkWsResponseCode(String response, String request) throws MojoExecutionException {

        ServiceResponse serviceResponse = null;
        try {
            serviceResponse = JaxbSerializerUtils.parseResponse(response);
        } catch (JAXBException e) {
            getLog().error("Aucun contenu valide n'a été retourné par Qualys à l'appel WebService ");
            throw new MojoExecutionException("Une Exception s'est produite pendant l'execution du Goal SCAN : \n Reponse reçue du serveur : "+response);
        }
        if( serviceResponse ==null || serviceResponse.getResponseCode() == null || ! serviceResponse.getResponseCode().trim().equalsIgnoreCase( RESULT_CODE.SUCCESS.toString())){
            getLog().error("Une erreur est parvenue pendant le traitement de votre demande de Scan de vulnerabilité");
            if(serviceResponse != null && serviceResponse.getResponseCode() != null){
                getLog().error("Code de retour : "+serviceResponse.getResponseCode());
                getLog().error("Message erreur : "+serviceResponse.getResponseErrorDetails().getErrorMessage());
                throw new MojoExecutionException("Une Exception s'est produite pendant l'execution du Goal SCAN : \n Reponse reçue du serveur : "+serviceResponse.toString());
            }else{
                getLog().error("Aucun contenu n'a été retourné par Qualys à l'appel WebService : "+getBaseResourceUrl() +" avec les parametres suivants : "+request);
                throw new MojoExecutionException("Une Exception s'est produite pendant l'execution du Goal SCAN : \n Reponse reçue du serveur : "+response);
            }
        }
        return serviceResponse;
    }
}
