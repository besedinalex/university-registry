package com.university.registry.services;

import com.university.registry.exceptions.GroupAlreadyExistsException;
import com.university.registry.models.Group;
import com.university.registry.repositories.GroupsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupsService {

    private final GroupsRepository groupsRepository;

    @Autowired
    public GroupsService(GroupsRepository groupsRepository) {
        this.groupsRepository = groupsRepository;
    }

    public List<Group> getAllGroups() {
        return groupsRepository.findAll();
    }

    public Group addNewGroup(String name, String specialization) {
        var existingGroup = groupsRepository.findByName(name);
        if (existingGroup.isPresent()) {
            throw new GroupAlreadyExistsException(name);
        }
        return groupsRepository.save(new Group(name, specialization));
    }

    public Group updateGroup(long id, String name, String specialization) {
        var group = groupsRepository.findById(id).orElse(null);
        if (group == null) {
            throw new IllegalArgumentException("Group with this id was not found.");
        }
        if (!name.equals("")) {
            group.setName(name);
        }
        if (!specialization.equals("")) {
            group.setSpecialization(specialization);
        }
        groupsRepository.save(group);
        return group;
    }

    public String deleteGroup(long id) {
        var group = groupsRepository.findById(id).orElse(null);
        if (group == null) {
            throw new IllegalArgumentException("Group with this id was not found.");
        }

        groupsRepository.delete(group);

        return "Group was deleted";
    }
}
