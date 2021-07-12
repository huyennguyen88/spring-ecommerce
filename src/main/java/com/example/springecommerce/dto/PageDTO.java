package com.example.springecommerce.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PageDTO<T> {
    private int page;
    private int totalPage;
    private List<T> listResult = new ArrayList<>();

}
