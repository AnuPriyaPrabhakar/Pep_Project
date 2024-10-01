package com.ponsun.pep.pepIdentitfier.Indentitfier.services;

import com.ponsun.pep.pepIdentitfier.Indentitfier.data.IdentifierData;

import java.util.List;

public interface IdentifierWritePlatformService {

    List<IdentifierData> fetchAllIdentifierData(String name);

}
