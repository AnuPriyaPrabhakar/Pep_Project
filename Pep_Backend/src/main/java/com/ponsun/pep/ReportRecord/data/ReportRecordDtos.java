package com.ponsun.pep.ReportRecord.data;



import com.ponsun.pep.Search.data.SearchDtos;
import lombok.Data;

@Data
public class ReportRecordDtos {
    private SearchDtos searchDtos;

    public ReportRecordDtos(SearchDtos searchDtos) {
        this.searchDtos = searchDtos;
    }
    public static ReportRecordDtos newInstance(SearchDtos searchDtos){
        return new ReportRecordDtos (searchDtos);
    }
}
