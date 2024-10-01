package com.ponsun.pep.getDirectors.services;

import com.ponsun.pep.getDirectors.request.CreateGetDirectorsRequest;
import com.ponsun.pep.infrastructure.utils.Response;


public interface GetDirectorsWriteService {
    Response createGetDirectors(CreateGetDirectorsRequest createGetDirectorsRequest);
}
