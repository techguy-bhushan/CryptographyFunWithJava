package com.cryptographywithjava.service;

import com.cryptographywithjava.util.MacUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageAuthenticationCodeServiceTest {
    @Autowired
    private MessageAuthenticationCodeService messageAuthenticationCodeService;

    @Test
    public void testMac() throws Exception {
        String planText = "Test data";
        String hexString = messageAuthenticationCodeService.mac(planText, MacUtil.HMAC_MD1_SECRET_KEY);
        System.out.println(hexString);
        assertThat(hexString).isNotNull();
        assertThat(hexString).isNotEqualTo(planText);
        assertThat(hexString).isEqualTo(messageAuthenticationCodeService.mac(planText, MacUtil.HMAC_MD1_SECRET_KEY));
    }

    @Test
    public void testIsValidTextWithValidHash() throws Exception {
        String planText = "Original text";
        String hexString = messageAuthenticationCodeService.mac(planText, MacUtil.HMAC_MD1_SECRET_KEY);
        assertThat(messageAuthenticationCodeService.isValidText(planText, hexString, MacUtil.HMAC_MD1_SECRET_KEY)).isTrue();
    }

    @Test
    public void testIsValidTextWithInvalidText() throws Exception {
        String planText = "Original text";
        String hexString = messageAuthenticationCodeService.mac(planText, MacUtil.HMAC_MD1_SECRET_KEY);
        assertThat(messageAuthenticationCodeService.isValidText("Modified Text", hexString, MacUtil.HMAC_MD1_SECRET_KEY)).isFalse();
    }

    @Test
    public void testIsValidTextWithInvalidHash() throws Exception {
        assertThat(messageAuthenticationCodeService.isValidText("Original text", "1478523698452147ada", MacUtil.HMAC_MD1_SECRET_KEY)).isFalse();
    }
}
