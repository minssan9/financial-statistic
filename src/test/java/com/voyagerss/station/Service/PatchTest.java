package com.voyagerss.station.Service;

import com.google.gson.Gson;
import com.voyagerss.station.Dto.StationResponseFromGov;
import org.json.simple.parser.JSONParser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PatchTest {

    @Autowired
    StationService stationService;

    @Autowired
    Gson gson;

    @Test
    public void 공공데이터가져오기() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        HttpEntity entity = new HttpEntity("parameters", headers);

        String serviceKey =  "dKNTmNiGHpcJLrC4HIJc3nW4AaPPKOQLCvlzV7IQZDTTztv6PTuDusZxS8iC1vpBEtkLsnk97WEzKpEvf3Zqgg==";
        String urlString = ("http://open.ev.or.kr:8080/openapi/services/EvCharger/getChargerInfo");
        urlString = ("http://open.ev.or.kr:8080/openapi/services/EvCharger/getChargerInfo?serviceKey="+ serviceKey + "&pageNo=1&pageSize=100");

        ResponseEntity<String> response  = restTemplate.getForEntity(urlString, String.class);
//
        StationResponseFromGov responseFromGov= gson.fromJson(response.getBody(), StationResponseFromGov.class);
        List<StationResponseFromGov.StationInfoFromGov> stationInfoFromGovs = responseFromGov.getItems();

        Assert.assertNotNull(stationInfoFromGovs.get(0).getItem());
    }
}
