package com.university.registry.controllers;

import com.university.registry.models.Group;
import com.university.registry.services.GroupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student-groups")
public class GroupsController {

    private final GroupsService groupsService;

    @Autowired
    public GroupsController(GroupsService groupsService) {
        this.groupsService = groupsService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Group>> getAllGroups() {
        var groups = groupsService.getAllGroups();
        return new ResponseEntity<>(groups, HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<Group> addNewGroup(@RequestParam String name, @RequestParam String specialization) {
        var group = groupsService.addNewGroup(name, specialization);
        return new ResponseEntity<>(group, HttpStatus.CREATED);
    }

    @PutMapping("/{groupId}")
    public ResponseEntity<Group> updateGroup(@PathVariable long groupId, @RequestParam String name,
                                             @RequestParam String specialization) {
        var group = groupsService.updateGroup(groupId, name, specialization);
        return new ResponseEntity<>(group, HttpStatus.OK);
    }

    @DeleteMapping("{groupId}")
    public ResponseEntity<String> deleteGroup(@PathVariable long groupId) {
        var message = groupsService.deleteGroup(groupId);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
