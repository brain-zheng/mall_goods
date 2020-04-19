package com.mall.goodscenter.client.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SearchPageCategoryDTO implements Serializable {

    private static final long serialVersionUID = 7380644471072499807L;

    private String firstLevelCategoryName;

    private List<GoodsCategoryDTO> secondLevelCategoryList;

    private String secondLevelCategoryName;

    private List<GoodsCategoryDTO> thirdLevelCategoryList;

    private String currentCategoryName;


}
