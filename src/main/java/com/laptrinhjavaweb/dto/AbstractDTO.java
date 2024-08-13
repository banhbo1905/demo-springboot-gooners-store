package com.laptrinhjavaweb.dto;
import java.util.ArrayList;
import java.util.List;
public class AbstractDTO <T>{
    private Long id;
    private int totalPages = 0;
    private String searchValue;
    private int maxPageItems = 4;
    private int page = 1;
    private List<T> listResult = new ArrayList<>();
    private int totalItems = 0;
    private String tableId = "tableList";


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTotalPages() {
        return (int) Math.ceil((double) this.getTotalItems() / this.getMaxPageItems());
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public int getMaxPageItems() {
        return maxPageItems;
    }

    public void setMaxPageItems(int maxPageItems) {
        this.maxPageItems = maxPageItems;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<T> getListResult() {
        return listResult;
    }

    public void setListResult(List<T> listResult) {
        this.listResult = listResult;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }
}
