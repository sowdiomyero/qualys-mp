package sn.sonatel.dsi.dif.qualys;

import org.junit.Assert;
import org.junit.Test;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * Created by sowdiomyero on 14/01/2017.
 */
public class PasswordEncryptionTest {

    final String pass = "@qui2dr0it";

    @Test
    public void test_encrypt_decrypt() {
        String passEncrypted = EncryptorUtils.encrypt(pass);
        System.out.println(passEncrypted);
        Assert.assertNotNull(EncryptorUtils.decrypt(passEncrypted));
        Assert.assertEquals(EncryptorUtils.decrypt(passEncrypted), pass);
    }

    @Test
    public void test_encrypt() {

        String encryptedPassCorrespondingTo = "GOMNxw5y6KvdDVHsP1ioRw==";
        String passEncrypted = EncryptorUtils.encrypt(pass);
        Assert.assertEquals(passEncrypted, encryptedPassCorrespondingTo);
    }

    @Test
    public void test_decrypt() {

        String encryptedPassCorrespondingTo = "GOMNxw5y6KvdDVHsP1ioRw==";
        String passDecrypted =EncryptorUtils.decrypt(encryptedPassCorrespondingTo);
        Assert.assertEquals(passDecrypted, pass);

    }

}
