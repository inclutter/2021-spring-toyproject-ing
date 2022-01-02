package com.study.toypro.chapter3;

import com.study.toypro.api.board.model.BoardDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BoardControllerTest2 {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testHello() {
        String result = restTemplate.getForObject("/hello1?name=둘리", String.class);
        assertEquals("Hello : 둘리", result);
    }

    @Test
    public void testGetBoard() {
        BoardDTO board = restTemplate.getForObject("/boards1/read", BoardDTO.class);
        assertEquals("테스터", board.getWriter());
    }

}
