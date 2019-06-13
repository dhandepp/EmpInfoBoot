package demo.ei.controller;

import demo.ei.model.Employee;
import demo.ei.service.EIServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/ei")
public class EIController {

    @Autowired
    private EIServiceImpl service;
    @Autowired
    private Environment env;

    @GetMapping("/employees")
    public Map<String, Object> find() {
        Map<String, Object> response = new HashMap();
        try {
            response.put("data", service.find());
        } catch (Exception e) {
            response.put("error", e.getMessage());
        }
        handleResponse(response);
        return response;
    }

    @GetMapping("/employees/{id}")
    public Map<String, Object> retrieve(@PathVariable String id) {
        Map<String, Object> response = new HashMap();
        try {
            response.put("data", service.retrieve(id));
        } catch (Exception e) {
            response.put("error", e.getMessage());
        }
        handleResponse(response);
        return response;
    }

    @PostMapping("/employees")
    public Map<String, Object> create(@RequestBody Employee employee) {
        Map<String, Object> response = new HashMap();
        try {
            response.put("data", service.create(employee));
        } catch (Exception e) {
            response.put("error", e.getMessage());
        }
        handleResponse(response);
        return response;
    }

    @PatchMapping("/employees/{id}")
    public Map<String, Object> update(@RequestBody Employee employee, @PathVariable String id) {
        Map<String, Object> response = new HashMap();
        try {
            response.put("data", service.update(employee, id));
        } catch (Exception e) {
            response.put("error", e.getMessage());
        }
        handleResponse(response);
        return response;
    }

    @DeleteMapping("/employees/{id}")
    public Map<String, Object> delete(@PathVariable String id) {
        Map<String, Object> response = new HashMap();
        try {
            service.delete(id);
            response.put("success", true);
        } catch (Exception e) {
            response.put("error", e.getMessage());
        }
        handleResponse(response);
        return response;
    }

    private void handleResponse(Map res) {
        Map<String, String> metadata = new HashMap<>();
        metadata.put("port", env.getProperty("server.port"));
        res.put("metadata", metadata);
    }
}
