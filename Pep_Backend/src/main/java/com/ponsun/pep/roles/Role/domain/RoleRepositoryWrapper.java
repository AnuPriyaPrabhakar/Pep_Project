package com.ponsun.pep.roles.Role.domain;


import com.ponsun.pep.roles.Role.request.AbstractRoleRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RoleRepositoryWrapper extends AbstractRoleRequest {
    private final RoleRepository roleRepository;
    @Transactional
    public Role findOneWithNotFoundDetection(final Integer id) {
        return this.roleRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Role Not found " + id));
    }
    @Override
    public String toString() {
        return super.toString();
    }

}