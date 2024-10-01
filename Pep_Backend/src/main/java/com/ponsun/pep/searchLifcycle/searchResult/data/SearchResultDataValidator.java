package com.ponsun.pep.searchLifcycle.searchResult.data;

import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import com.ponsun.pep.searchLifcycle.searchResult.request.CreateSearchResultRequest;
import com.ponsun.pep.searchLifcycle.searchResult.request.UpdateSearchResultRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SearchResultDataValidator {
    public void validateSaveSearchData(final CreateSearchResultRequest request){

    }
    public void validateUpdateSerachData(final UpdateSearchResultRequest request){
        if(request.getName() == null || request.getName().equals("")){
            throw new EQAS_PEP_AppicationException("Search Name parameter required");
        }
        if(request.getListId() == null || request.getListId().equals("")){
            throw new EQAS_PEP_AppicationException("Search ListId parameter required");
        }
        if(request.getTypeId() == null || request.getTypeId().equals("")){
            throw new EQAS_PEP_AppicationException("Search TypeId parameter required");
        }
        if(request.getCountryId() == null || request.getCountryId().equals("")){
            throw new EQAS_PEP_AppicationException("Search CountryId parameter required");
        }
        if(request.getLevelId() == null || request.getLevelId().equals("")){
            throw new EQAS_PEP_AppicationException("Search LevelId parameter required");
        }
    }
}
