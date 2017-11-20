package com.jerome;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author suzhida
 * @since 2017/9/26 15:42
 */
@SpringBootTest
@Slf4j
public class RestTemplateTest {

    private RestTemplate restTemplate = new RestTemplate();

    @Test
    public void getTest() {
        String url = "http://192.168.2.201:8081/api/authenticate";
        HttpHeaders headers = new HttpHeaders();
        headers.add("accept","application/x.agent.v1+json");
        headers.add("authorization","Basic emhpZGE6MTIzMTIz");

        HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);

        ResponseEntity<AuthDto>
                response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, AuthDto.class, headers);
        log.info("result = {}", response);
        log.info("result = {}", response.getBody());

    }


    @Test
    public void postTest() {
        /*
        AgentReduceSuncionRequestDto requestDto) {
        log.info("reduceSuncoin, requestDto = {}", requestDto);

        String url = apiUrl + "/api/agent/pay";
        HttpHeaders headers = new HttpHeaders();
        headers.add("accept", standardsTree);
        headers.add("authorization", "Bearer " + getToken());
        headers.add("content-type", "application/json");

        HttpEntity<AgentReduceSuncionRequestDto> requestEntity =
                new HttpEntity<>(requestDto, headers);

        ResponseEntity<AgentReduceSuncoinResponseDto> response = agentRestTemplate
                .exchange(url, HttpMethod.POST, requestEntity, AgentReduceSuncoinResponseDto.class,
                        headers);
        log.info("result = {}", response);

        if (response.getBody() == null || response.getBody().getData() == null) {
            throw new GeneralException("get agent is null");
        }

        return response.getBody();
        */
    }





}

@Data
class AuthDto {
    private String token;

}
