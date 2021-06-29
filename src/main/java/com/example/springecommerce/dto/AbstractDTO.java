package com.example.springecommerce.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AbstractDTO<T> {
    private int id;
    private Date create_time;
    private Date update_time;
    private final List<T> listResult = new ArrayList<>();

}
