package com.sai.productservice.thirdpartyclients.productservice.fakestore;

import com.sai.productservice.dtos.GenericProductDto;
import com.sai.productservice.exceptions.NotFoundException;
import com.sai.productservice.thirdpartyclients.productservice.ThirdPartyProductServiceClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 *  Wrapper for the FakeStore API
 */

@Service
public  class FakeStoreProductServiceClient implements ThirdPartyProductServiceClient {

    @Value("${fakestore.api.url}")
    private String fakestoreApiUrl;

    @Value("${fakestore.api.paths.product}")
    private String fakestoreProductApiPath;

    private RestTemplateBuilder restTemplateBuilder;
    private String specificProductRequestUrl;
    private  String productRequestBaseUrl;



    public FakeStoreProductServiceClient(RestTemplateBuilder restTemplateBuilder,
                                        @Value("${fakestore.api.url}") String fakestoreApiUrl,
                                         @Value("${fakestore.api.paths.product}") String fakestoreProductApiPath) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.productRequestBaseUrl = fakestoreApiUrl + fakestoreProductApiPath;
        this.specificProductRequestUrl = fakestoreApiUrl + fakestoreProductApiPath + "/{id}";
    }



    public FakeStoreProductDto getProductById(Long id) throws NotFoundException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response =  restTemplate.getForEntity(specificProductRequestUrl, FakeStoreProductDto.class, id);

        FakeStoreProductDto fakeStoreProductDto = response.getBody();

        /*  // Code Duplication
        GenericProductDto product = new GenericProductDto();
        product.setImage(fakeStoreProductDto.getImage());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setCategory(fakeStoreProductDto.getCategory());
        return product;

         */

        if (fakeStoreProductDto == null){
            //throw new NotFoundException("Product with id: "+ id + "dosen't exist.");
            return null;
        }

        return fakeStoreProductDto;
    }



    public FakeStoreProductDto createProduct(GenericProductDto product){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.postForEntity(productRequestBaseUrl, product, FakeStoreProductDto.class);
        return response.getBody();
    }


    public List<FakeStoreProductDto> getProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> response = restTemplate.getForEntity(productRequestBaseUrl, FakeStoreProductDto[].class);

        List<GenericProductDto> answer = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : Arrays.stream(response.getBody()).toList()) {

            /*  // Code Duplication
            GenericProductDto product = new GenericProductDto();
            product.setImage(fakeStoreProductDto.getImage());
            product.setDescription(fakeStoreProductDto.getDescription());
            product.setTitle(fakeStoreProductDto.getTitle());
            product.setPrice(fakeStoreProductDto.getPrice());
            product.setCategory(fakeStoreProductDto.getCategory());
            */

            //answer.add(convertFakeProductIntoGenericProductDto(fakeStoreProductDto));
        }
        return Arrays.stream(response.getBody()).toList();
    }


    public FakeStoreProductDto deleteProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> response = restTemplate.execute(specificProductRequestUrl, HttpMethod.DELETE, requestCallback, responseExtractor, id);

        // FakeStoreProductDto fakeStoreProductDto = response.getBody();

        /*      // Code duplication
        GenericProductDto product = new GenericProductDto();
        product.setImage(fakeStoreProductDto.getImage());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setCategory(fakeStoreProductDto.getCategory());
        */

        return response.getBody();

    }
}
