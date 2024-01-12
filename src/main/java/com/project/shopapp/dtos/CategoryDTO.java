package com.project.shopapp.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
    @NotEmpty(message = "Category name is not empty")
    private String name;
}
