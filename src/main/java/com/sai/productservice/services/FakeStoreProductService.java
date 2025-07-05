package com.sai.productservice.services;

import com.sai.productservice.dtos.GenericProductDto;
import com.sai.productservice.exceptions.NotFoundException;
import com.sai.productservice.security.JwtObject;
import com.sai.productservice.thirdpartyclients.productservice.fakestore.FakeStoreProductDto;
import com.sai.productservice.thirdpartyclients.productservice.fakestore.FakeStoreProductServiceClient;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Primary  // There are two classes fakeStoreProductService and SelfProductServiceImpl. This creates a confusion to dependency injection. So, Meke this as default by setting it as primary
@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService {

    private FakeStoreProductServiceClient fakeStoreProductServiceClient;

    public FakeStoreProductService(FakeStoreProductServiceClient fakeStoreProductServiceClient) {
        this.fakeStoreProductServiceClient = fakeStoreProductServiceClient;
    }

    private GenericProductDto ConvertFakeStoreProductIntoGenericProduct(FakeStoreProductDto fakeStoreProductDto) {
        GenericProductDto product = new GenericProductDto();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setCategory(fakeStoreProductDto.getCategory());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImage(fakeStoreProductDto.getImage());
        return product;


    }



    public GenericProductDto getProductById(Long id, Long UserIdTryingToAccess) throws NotFoundException {
        return ConvertFakeStoreProductIntoGenericProduct(fakeStoreProductServiceClient.getProductById(id));
    }


    public GenericProductDto createProduct(GenericProductDto product) {
        return ConvertFakeStoreProductIntoGenericProduct(fakeStoreProductServiceClient.createProduct(product));
    }


    public List<GenericProductDto> getProducts() {
        List<GenericProductDto> genericProductDtos = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductServiceClient.getProducts()) {
            genericProductDtos.add(ConvertFakeStoreProductIntoGenericProduct(fakeStoreProductDto));
        }
        return genericProductDtos;
    }


    public GenericProductDto deleteProductById(Long id) {
        return ConvertFakeStoreProductIntoGenericProduct(fakeStoreProductServiceClient.deleteProductById(id));

    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        return null;
    }
}


