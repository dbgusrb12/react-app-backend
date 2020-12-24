package com.example.reactappbackend.utils;

import lombok.Data;

@Data
public class Paging {
    private int sizePerPage = 10;
    private int page = 1;
    private int offset;
    private boolean hasPrevious;
    private boolean hasNext;
    private int totalCount;


    public void setPaging() {
        this.offset = (this.page - 1) * sizePerPage;
        if(this.offset + sizePerPage >= totalCount) {
            this.hasNext = false;
        } else {
            this.hasNext = true;
        }
        if(this.page <= 1) {
            this.hasPrevious = false;
        } else {
            this.hasPrevious = true;
        }
    }
}
