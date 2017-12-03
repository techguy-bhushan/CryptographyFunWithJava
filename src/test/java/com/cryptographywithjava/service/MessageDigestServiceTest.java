package com.cryptographywithjava.service;

import com.cryptographywithjava.util.MessageDigestUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

import java.security.NoSuchAlgorithmException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageDigestServiceTest {
    @Autowired
    private MessageDigestService messageDigestService;

    @Test
    public void testDigest() throws NoSuchAlgorithmException {
        String planText = "Test data";
        String hexString = messageDigestService.digest(planText, MessageDigestUtil.MD2);
        assertThat(hexString).isNotNull();
        assertThat(hexString).isNotEqualTo(planText);
        assertThat(hexString).isEqualTo(messageDigestService.digest(planText, MessageDigestUtil.MD2));
    }

    @Test(expected = NoSuchAlgorithmException.class)
    public void testDigestWithInvalidAlgorithm() throws NoSuchAlgorithmException {
        messageDigestService.digest("Text", "Not_Valid_Algo");
    }

}
