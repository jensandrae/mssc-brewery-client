package com.springframework.msscbreweryclient.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Create by Jens on 2020-10-19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDto {

    private UUID id;
    private String name;
}
