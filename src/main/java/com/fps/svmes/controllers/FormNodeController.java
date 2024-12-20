package com.fps.svmes.controllers;

import com.fps.svmes.models.nosql.FormNode;
import com.fps.svmes.services.FormNodeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/form-nodes")
@Tag(name = "Form Management API", description = "API for managing form nodes")
public class FormNodeController {

    @Autowired
    private FormNodeService service;

    // GET /form-nodes: Get all top-level nodes
    @GetMapping
    public List<FormNode> getAllNodes() {
        return service.getAllNodes();
    }

    // POST /form-nodes/top-level: Add a new top-level node (new document)
    @PostMapping("/top-level")
    public FormNode createTopLevelNode(@RequestBody FormNode node) {
        return service.saveNode(node);
    }

    // POST /form-nodes/child: Add a child node to an existing node
    @PostMapping("/child")
    public ResponseEntity<FormNode> addChildNode(@RequestParam String parentId, @RequestBody FormNode childNode) {
        Optional<FormNode> createdChild = service.addChildNode(parentId, childNode);
        return createdChild.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // GET /form-nodes/{id}: Get a node by ID (traversing if necessary)
    @GetMapping("/{id}")
    public ResponseEntity<FormNode> getNodeById(@PathVariable String id) {
        Optional<FormNode> node = service.getNodeByIdOrUuid(id);
        return node.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE /form-nodes/{id}: Delete a node by ID (traversing if necessary)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNode(@PathVariable String id) {
        boolean deleted = service.deleteNodeByIdOrUuid(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
