//package com.core.apiservice;
//
//import com.core.config.properties.CoreProperties;
//import com.core.document.EcosMongoData;
//import com.core.document.EcosMongoSchema;
//import com.core.domain.EcosData;
//import com.core.domain.EcosSchema;
//import com.core.domain.EcosSchemaDetail;
//import com.core.dto.EcosDto;
//import com.core.dto.EcosResponse;
//import com.core.mongorepo.EcosDataMongoRepo;
//import com.core.mongorepo.EcosSchemaMongoRepo;
//import com.core.repo.EcosDataRepo;
//import com.core.repo.EcosSchemaDetailRepo;
//import com.core.repo.EcosSchemaRepo;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.google.gson.Gson;
//import java.net.URI;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//import javax.transaction.Transactional;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.util.UriComponentsBuilder;
//
//@Slf4j
//@Service
//public class EcosApiServiceImplREST implements EcosApiService {
//    @Autowired    Gson gson;
//    @Autowired    RestTemplate restTemplate;
//
//    @Autowired    EcosDataMongoRepo ecosDataMongoRepo;
//    @Autowired    EcosSchemaMongoRepo ecosSchemaMongoRepo;
//
//    @Autowired
//    EcosDataRepo ecosDataRepo;
//    @Autowired
//    EcosSchemaRepo ecosSchemaRepo;
//    @Autowired
//    EcosSchemaDetailRepo ecosSchemaDetailRepo;
//
//    @Autowired
//    CoreProperties coreProperties;
//
//    public List<EcosData> retrieveData(EcosDto ecosDto) {
//        ecosDto.setServiceName("StatisticSearch");
////        krBankRequest.setPeriod("DD");
//
//        ResponseEntity<String> response = restTemplate.getForEntity(getUrlString(ecosDto), String.class);
//        List<EcosData> ecosData = gson.fromJson(response.getBody(), EcosResponse.class).getStatisticTableList().getRow();
//        List<EcosMongoData> ecosMongoData = ecosData.stream().map(krBankData -> (EcosMongoData)krBankData).collect(Collectors.toList());
//
//        ecosDataMongoRepo.saveAll(ecosMongoData);
//        return ecosDataRepo.saveAll(ecosData);
//    }
//
//
//    public List<EcosSchema> retrieveSchema() {
//        EcosDto ecosDto = new EcosDto();
//        ecosDto.setServiceName("StatisticTableList");
//
//        ResponseEntity<String> response = restTemplate.getForEntity(getUrlString(ecosDto), String.class);
//        EcosResponse ecosSchemaResponse = gson.fromJson(response.getBody(), EcosResponse.class);
//        List<EcosSchema> ecosSchemas = (List<EcosSchema>) gson.fromJson(
//            ecosSchemaResponse.getStatisticTableList().getRow().toString(), EcosSchema.class);
//        List<EcosMongoSchema> ecosMongoSchemas = ecosSchemas.stream().map(krBankSchema ->
//            new EcosMongoSchema(krBankSchema)
//        ).collect(Collectors.toList());
//
//        ecosSchemaMongoRepo.saveAll(ecosMongoSchemas);
//        return ecosSchemaRepo.saveAll(ecosSchemas);
//    }
//
//    @Override
//    public List<EcosSchemaDetail> retrieveSchemaDetail(EcosSchema ecosSchema) {
//        List<EcosSchema> ecosSchemas = ecosSchemaRepo.findBySearchFlag("Y");
//        EcosDto ecosDto = new EcosDto();
//        ecosDto.setServiceName("StatisticItemList");
//
//        ResponseEntity<String> response = restTemplate.getForEntity(getUrlString(ecosDto), String.class);
//        EcosResponse ecosSchemaResponse = restTemplate.getForObject(getUrlString(ecosDto), EcosResponse.class);
//        List<EcosSchemaDetail> ecosSchemasDetails  = (List<EcosSchemaDetail>)gson.fromJson(
//            ecosSchemaResponse.getStatisticTableList().getRow().toString(), EcosSchemaDetail.class);
////        List<EcosSchemaDetail> ecosSchemasDetails = gson.fromJson(response.getBody(), EcosResponse.class).getStatisticTableList().getRow();
//
////        List<EcosMongoSchema> ecosMongoSchemas = ecosSchemas.stream().map(krBankSchema ->
////            new EcosMongoSchema(krBankSchema)
////        ).collect(Collectors.toList());
//
////        ecosSchemaMongoRepo.saveAll(ecosMongoSchemas);
//        return ecosSchemaDetailRepo.saveAll(ecosSchemasDetails);
//    }
//
//
//
//    @Transactional
//    public List<EcosSchemaDetail> retrieveDataFromAllSchema(String startDate, String endDate) {
//        List<EcosSchemaDetail> ecosSchemaDetails = ecosSchemaDetailRepo.findAll();
//
//        ecosSchemaDetails.forEach(i-> {
//            EcosDto ecosDto = new EcosDto(i);
//            ecosDto.setQueryStartDate(startDate);
//            ecosDto.setQueryEndDate(endDate);
//            retrieveData(ecosDto);
//        });
//        return ecosSchemaDetails;
//    }
//
//
//    //    http://ecos.bok.or.kr/api/StatisticTableList/sample/xml/kr/1/10/
//    //    http://ecos.bok.or.kr/api/StatisticSearch/sample/xml/kr/1/10/010Y002/MM/201101/201101/AAAA11/
//    public URI getUrlString(EcosDto ecosDto) {
//        ecosDto.setAuthKey(coreProperties.ECOS_API_KEY);
//        String uriString = ecosDto.getUrl() + "/{serviceName}/{authKey}/{requestType}/{language}/{reqStartCount}/{reqEndCount}" +
//                "/{statisticCode}/{period}/{queryStartDate}/{queryEndDate}/{option1}";
//
//
//        return UriComponentsBuilder.fromUriString(uriString)
//                .buildAndExpand(new ObjectMapper().convertValue(ecosDto, Map.class))
//                .toUri();
//    }
//
//
//}
