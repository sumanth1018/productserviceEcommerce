package com.sai.productservice.controllers;

import com.sai.productservice.dtos.GenericProductDto;
import com.sai.productservice.exceptions.NotFoundException;
import com.sai.productservice.services.FakeStoreProductService;
import com.sai.productservice.services.ProductService;
import com.sai.productservice.thirdpartyclients.productservice.fakestore.FakeStoreProductServiceClient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductControllerTest {

    @Autowired
    @MockitoBean
    private FakeStoreProductServiceClient  fakeStoreProductServiceClient;

    @Autowired
    private ProductController productController;

   // @MockitoBean
    //private ProductService productService;

    @MockitoBean
    private FakeStoreProductService productService;

    @MockitoBean
    private FakeStoreProductService fakeStoreProductService;

    @Captor
    private ArgumentCaptor<Long> idCaptor;

    @Captor
    private ArgumentCaptor<Long> fakeStoreCaptor;

    @Test
    void returnsNullWhenProductDoesNotExist() throws NotFoundException{
        GenericProductDto genericProductDto = productController.getProductById(121L);
        when(
             productService.getProductById(121L))
                     .thenReturn(null);

        assertNull(genericProductDto);
    }

    @Test
    void returnsProductWhenProductExists() throws NotFoundException{
        GenericProductDto genericProductDto = new GenericProductDto();
        when(
                productService.getProductById(any(Long.class))
        ).thenReturn(genericProductDto);

        assertEquals(genericProductDto, productController.getProductById("abcd",123L));
    }


    @Test
    void throwsExceptionWhenProductDoesNotExist() throws NotFoundException{
        when(
                productService.getProductById(any(Long.class))
        ).thenReturn(null);
        assertThrows(NotFoundException.class, () -> productController.getProductById("abcd",123L));
    }

    @Test
    void shouldReturnTitleABCWithProductID1() throws NotFoundException{
        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setTitle("sai");

        when(
                productService.getProductById(1L)
        ).thenReturn(
                new GenericProductDto()
        );

        GenericProductDto genericProductDto1 = productController.getProductById("abcd",1L);
        assertEquals(genericProductDto.getTitle(), "sai");
    }

    @Test
    @DisplayName("1 + 1 equals 2")  // sets test name for readibility
    void testOnePlusOneEqualsTrue() throws Exception {
        // System.out.println("It is true");
//        assertEquals(11, 1 + 1, "1 + 1 is not coming to be 2");

        // assertNull(fakeStoreProductServiceClient.getProductById(101L));

       // assertEquals(null, fakeStoreProductServiceClient.getProductById(101L));
//        Exception e;
//        try {
//            fakeStoreProductServiceClient.getProductById(101L)
//        } catch (Exception ex) {
//            e = ex;
//        }
//        assertNotNull(e);
//        assertEquals(NotFoundException.class, e.getClass());

       // assertThrows(NotFoundException.class, () -> fakeStoreProductServiceClient.getProductById(101L));

    }


    @Test
    void additionShouldBeCorrect() {
        assertTrue(-1 + -1 == -2, "Not corrt");

        assertTrue(-1 + 0 == -1, "Not corrt");

        assertTrue(-1 + 1 == 0, "Not corrt");

        assertTrue(1 + 0 == 1, "Not corrt");

        assertTrue(1 + 1 == 2, "Not corrt");

    }

    @Test
    void productControllerCallsProductServiceWithSameProductId() throws Exception {
        Long id  = 1L;

        when(productService.getProductById(any()))
                .thenCallRealMethod();

        when(fakeStoreProductServiceClient.getProductById(any()))
                .thenCallRealMethod();
//        when(productService.getProductById(any()))
//                .thenReturn(new GenericProductDto());


        // check that the product service is being called with the exact same
        // parameters as controller


        productController.getProductById("abcd",id);

        verify(productService).getProductById(idCaptor.capture());
        // idCaptor.capture() = Ensures that same id is passed.
        verify(fakeStoreProductServiceClient).getProductById(fakeStoreCaptor.capture());
        assertEquals(id, idCaptor.getValue());
        assertEquals(id, fakeStoreCaptor.getValue());
    }

}



