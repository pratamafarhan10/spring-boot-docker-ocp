package com.ecommerce.product.util;

import com.ecommerce.product.dto.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ResponseUtil {
    public ResponseEntity<?> success(Object data) {
        return ResponseEntity.status(200).body(Response.builder()
                .errorSchema(Response.ErrorSchema.builder()
                        .errorCode("SWR-00-000")
                        .errorMessage(Response.Language.builder()
                                .en("Success")
                                .id("Sukses")
                                .build())
                        .build())
                .outputSchema(data)
                .build());
    }

    public ResponseEntity<?> failed(Object data) {
        return ResponseEntity.status(400).body(Response.builder()
                .errorSchema(Response.ErrorSchema.builder()
                        .errorCode("SWR-00-999")
                        .errorMessage(Response.Language.builder()
                                .en("Failed")
                                .id("Gagal")
                                .build())
                        .build())
                .outputSchema(data)
                .build());
    }
}
