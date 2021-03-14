package com.core.apiservice;

import com.core.config.properties.CoreProperties;
import com.core.domain.EcosData;
import com.core.domain.EcosSchema;
import com.core.domain.EcosSchemaDetail;
import com.core.dto.EcosDto;
import com.core.repo.EcosDataRepo;
import com.core.repo.EcosSchemaDetailRepo;
import com.core.repo.EcosSchemaRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.List;
import java.util.Map;
import javafx.print.PrinterJob.JobStatus;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
@Service
public class EcosApiServiceImplWebClient implements EcosApiService {

    @Autowired
    Gson gson;
//    @Autowired
//    EcosDataMongoRepo ecosDataMongoRepo;
//    @Autowired
//    EcosSchemaMongoRepo ecosSchemaMongoRepo;

    @Autowired
    EcosDataRepo ecosDataRepo;
    @Autowired
    EcosSchemaRepo ecosSchemaRepo;
    @Autowired
    EcosSchemaDetailRepo ecosSchemaDetailRepo;
    @Autowired
    CoreProperties coreProperties;

    @Autowired
    private WebClient webClient;

    public JsonObject getAPIData(EcosDto ecosDto) {        ;
            ecosDto.setAuthKey(coreProperties.getECOS_API_KEY());

        String response = webClient.get()
            .uri(coreProperties.getECOS_API_URL() + getUrlString(ecosDto))
            .retrieve()
            .bodyToMono(String.class)
            .block();
        return gson.fromJson(response, JsonObject.class);
    }

    public List<EcosData> saveData(EcosDto ecosDto) {
        ecosDto.setServiceName("StatisticSearch");

        JsonObject jsonObject = getAPIData(ecosDto);
        jsonObject =  jsonObject.get("statisticTableList").getAsJsonObject();
        JsonElement jsonElement = jsonObject.get("row").getAsJsonObject();

        Type listType = new TypeToken<List<EcosData>>() {}.getType();
        List<EcosData> ecosData = gson.fromJson(jsonElement, listType);

//    o ->
//            ecosData.add((EcosData) o)
//        );
//        List<EcosMongoData> ecosMongoData = ecosData.stream().map(data -> (EcosMongoData) data)
//            .collect(Collectors.toList());

//        ecosDataMongoRepo.saveAll(ecosMongoData);
        return ecosDataRepo.saveAll(ecosData);
    }


    public List<EcosSchema> retrieveSchema() {
        EcosDto ecosDto = new EcosDto();
        ecosDto.setServiceName("StatisticTableList");

        JsonObject jsonObject = getAPIData(ecosDto);
        JsonArray jsonArray =  jsonObject.get("StatisticTableList").getAsJsonObject().get("row").getAsJsonArray();

        Type listType = new TypeToken<List<EcosSchema>>() {}.getType();
        List<EcosSchema> ecosSchemas = gson.fromJson(jsonArray, listType);

        ecosSchemaRepo.deleteAll();;
        ecosSchemas.forEach(ecosSchema -> {
            ecosSchemaRepo.save(ecosSchema);
        });

//        List<EcosMongoSchema> ecosMongoSchemas = ecosSchemas.stream().map(krBankSchema ->
//            new EcosMongoSchema(krBankSchema)
//        ).collect(Collectors.toList());
//        ecosSchemaMongoRepo.saveAll(ecosMongoSchemas);

        return ecosSchemas;
    }

    @Override
    public JobStatus retrieveSchemaDetail() {
        EcosDto ecosDto = new EcosDto();
        ecosDto.setServiceName("StatisticItemList");

        List<EcosSchema> ecosSchemas = ecosSchemaRepo.findByCycleAndSearchFlag("DD", "Y");
        ecosSchemas.forEach(ecosSchema -> {
            ecosDto.setStatisticCode(ecosSchema.getStatcode());

            ecosSchemaDetailRepo.deleteByPitemcode(ecosSchema.getStatcode());

            JsonObject jsonObject = getAPIData(ecosDto);
            JsonArray jsonArray =  jsonObject.get(ecosDto.getServiceName()).getAsJsonObject().get("row").getAsJsonArray();

            Type listType = new TypeToken<List<EcosSchemaDetail>>() {}.getType();
            List<EcosSchemaDetail> ecosSchemaDetails = gson.fromJson(jsonArray, listType);

            ecosSchemaDetailRepo.saveAll(ecosSchemaDetails);
        });

//        List<EcosMongoSchema> ecosMongoSchemas = ecosSchemas.stream().map(krBankSchema ->
//            new EcosMongoSchema(krBankSchema)
//        ).collect(Collectors.toList());

        return JobStatus.DONE;
    }

    @Transactional
    public List<EcosSchemaDetail> retrieveDataFromAllSchema(EcosDto ecosDto) {
        List<EcosSchemaDetail> ecosSchemaDetails = ecosSchemaDetailRepo.findAll();

        ecosSchemaDetails.forEach(i -> {
            EcosDto ecosDto1 = new EcosDto(i);
            ecosDto1.setQueryStartDate(ecosDto.getQueryStartDate());
            ecosDto1.setQueryEndDate(ecosDto.getQueryEndDate());
            saveData(ecosDto1);
        });
        return ecosSchemaDetails;
    }


    //    http://ecos.bok.or.kr/api/StatisticTableList/sample/xml/kr/1/10/
    //    http://ecos.bok.or.kr/api/StatisticSearch/sample/xml/kr/1/10/010Y002/MM/201101/201101/AAAA11/
    public URI getUrlString(EcosDto ecosDto) {
        String uriString =
            "/api/{serviceName}/{authKey}/{requestType}/{language}/{reqStartCount}/{reqEndCount}" +
                "/{statisticCode}/{period}/{queryStartDate}/{queryEndDate}/{option1}";
        return UriComponentsBuilder.fromUriString(uriString)
            .buildAndExpand(new ObjectMapper().convertValue(ecosDto, Map.class))
            .toUri();
    }


}
