package com.nhom6.microservices.identity_service.dto.respone;


import lombok.*;
import lombok.experimental.FieldNameConstants;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldNameConstants(level = AccessLevel.PRIVATE)
public class AuthenticationRespone {
    String token;
    boolean isAuthenticated;
}
