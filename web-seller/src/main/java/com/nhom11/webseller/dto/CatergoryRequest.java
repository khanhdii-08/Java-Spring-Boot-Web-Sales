package com.nhom11.webseller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CatergoryRequest {
    private long id;
	private String name;
    private boolean isEdit = false;
}
