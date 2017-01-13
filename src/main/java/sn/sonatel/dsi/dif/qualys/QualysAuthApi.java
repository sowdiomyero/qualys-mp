package sn.sonatel.dsi.dif.qualys;

import javax.ws.rs.client.WebTarget;
import java.util.Map;
import java.util.prefs.Preferences;

/**
 * Created by ext_sow18 on 06/01/2017.
 */
public class QualysAuthApi {

    static Preferences preferences = Preferences.userRoot().node("sn/sonatel/dsi/dif/qualys/mojo");

    public static void setCredentials(String username, String password) {
        preferences.put("qualys_username", username);
        preferences.put("qualys_password", password);
    }

    public static String getUsername() {
        return preferences.get("qualys_username", null);
    }

    public static String getPassword() {
        return preferences.get("qualys_password", null);
    }


}
