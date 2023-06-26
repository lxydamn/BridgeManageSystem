package com.backend.controller;

import com.backend.pojo.Route;
import com.backend.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by Lxy on 2023/6/18 10:53
 */
@RestController
public class RouteController {

    @Autowired
    private RouteService routeService;

    @GetMapping("/api/route/get/all")
    public List<Route> getAll() {
        return routeService.getAll();
    }

    @PostMapping("/api/route/update")
    public Map<String, String> update(@RequestParam Map<String, Object> map) {
        return routeService.updateRoute(map);
    }

    @PostMapping("/api/route/add")
    public Map<String, String> insert(@RequestParam Map<String, Object> map) {
        return routeService.addRoute(map);
    }

    @PostMapping("/api/route/delete")
    public Map<String, String> delete(@RequestParam Map<String, Object> map) {
        return routeService.deleteRoute(map);
    }
    @GetMapping("/api/route/get/id")
    public Route getById(@RequestParam Map<String, Object> map) {
        return routeService.getById(map);
    }

    @GetMapping("/api/route/get/bno")
    public Map<String, Object> getByBridgeNo(@RequestParam Map<String, Object> map) {
        return routeService.getByBridgeNo(map);
    }

    @GetMapping("/api/route/count")
    public Map<String, Object> getRouteCount() {
        return routeService.getRouteCount();
    }
}
