package com.jmj.qnasite.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IndexControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    // URL 호출 시 페이지의 내용이 제대로 호출되는지에 대한 테스트
    @Test
    public void 메인페이지_로딩(){
        // when
        String body = this.restTemplate.getForObject("/", String.class);

        // then
        Assertions.assertThat(body).contains("번호");
    }


}