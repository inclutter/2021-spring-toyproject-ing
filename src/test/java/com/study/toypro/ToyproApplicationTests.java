package com.study.toypro;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
class ToyproApplicationTests {

    @Test
    void contextLoads() {
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword("m2"); // 암호화 Key 정보
        encryptor.setAlgorithm("PBEWithMD5AndDES"); // 암호화 알고리즘
        encryptor.setStringOutputType("base64");

        String encryptedText = encryptor.encrypt("1qaz2wsx");
        String decrypedText = encryptor.decrypt(encryptedText);

        System.out.println("encryptedText : " + encryptedText);
        System.out.println("decrypedText : " + decrypedText);

    }

}
