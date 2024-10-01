package com.ponsun.pep.getDirectors.services;

import com.ponsun.pep.companiesAndLlp.DirectorsMaster.data.DirectorsMasterDataValidator;
import com.ponsun.pep.companiesAndLlp.DirectorsMaster.domain.DirectorsMasterRepository;
import com.ponsun.pep.getDirectors.data.DirectorsValidator;
import com.ponsun.pep.getDirectors.domain.GetDirectors;
import com.ponsun.pep.getDirectors.domain.GetDirectorsRepository;
import com.ponsun.pep.getDirectors.domain.GetDirectorsWrapper;
import com.ponsun.pep.getDirectors.request.CreateGetDirectorsRequest;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import com.ponsun.pep.infrastructure.utils.Response;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class GetDirectorsWriteServiceImpl implements GetDirectorsWriteService {

    private final GetDirectorsRepository getDirectorsRepository;
    private final GetDirectorsWrapper getDirectorsWrapper;
    private final DirectorsValidator directorsValidator;
    private final DirectorsMasterDataValidator directorsMasterDataValidator;
    private final DirectorsMasterRepository directorsMasterRepository;
    private final JdbcTemplate jdbcTemplate;


    @Override
    @Transactional
    public Response createGetDirectors(CreateGetDirectorsRequest createGetDirectorsRequest) {
        try {
            this.directorsValidator.validateSaveGetDirectors(createGetDirectorsRequest);
            final GetDirectors getDirectors = GetDirectors.create(createGetDirectorsRequest);
            this.getDirectorsRepository.saveAndFlush(getDirectors);
            return Response.of(Long.valueOf(getDirectors.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
}
