package com.cryptographywithjava.service;

import com.cryptographywithjava.util.CommonUtil;
import com.cryptographywithjava.util.MacUtil;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.validation.constraints.NotNull;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/*Message Authentication Code or MAC is obtained by applying a secret key to the message digest so that only the holder
*of the secret key can compute the MAC from the digest and hence, the message.
*This method thwarts the threat posed by a malicious interceptor who could modify the message and replace the digest
* with the digest of the modified message, for the interceptor won't have access to the secret key. Of course, there has to be a secure
* way to share the secret key between the sender and the recipient for this to work.
*J2SE includes class javax.crypto.Mac to compute MAC. This class is somewhat similar to the MessagDigest class, except for the following:
*A Mac object must be initialized with a secret key.
*There is method doFinal() in place of digest().
*Another difference between classes for MAC and message digest is that there are no MacInputStream and MacOutputStream classes.
*Supports the HMAC/SHA-1 and HMAC/MD5 message-authentication code algorithms.
*/
@Service
public class MessageAuthenticationCodeServiceImpl implements  MessageAuthenticationCodeService {

    private static final Log LOG = LogFactory.getLog(MessageAuthenticationCodeServiceImpl.class);

    @Override
    public String mac(@NotNull String text, @NotNull SecretKey secretKey) throws NoSuchAlgorithmException, InvalidKeyException, IllegalStateException {
        Assert.state(text != null && secretKey != null, "Text or secretKey can't be null");
        Mac mac = Mac.getInstance(secretKey.getAlgorithm());
        mac.init(secretKey);
        mac.update(text.getBytes());

        byte[] bytes = mac.doFinal();
        return CommonUtil.convertByteToHexFormat(bytes);
    }

    public boolean isValidText(String text, String originalHash, SecretKey secretKey) throws NoSuchAlgorithmException, InvalidKeyException, IllegalStateException  {
        Assert.state(text != null && secretKey != null && originalHash != null, "Text/secretKey/originalHash can't be null");
        return mac(text, secretKey).equals(originalHash);
    }
}
