package com.bootcamp.bankapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;

@Data
public class Customer  implements Serializable {

    private static final long SerialVersionUID=1L;

    private String id;
    private String name;
    private String type; // personal or business
}
