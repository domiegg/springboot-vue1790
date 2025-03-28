package com.project.demo.controller;

import com.project.demo.entity.SchedulingScheme;
import com.project.demo.service.SchedulingSchemeService;
import com.project.demo.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *调度方案：(SchedulingScheme)表控制层
 *
 */
@RestController
@RequestMapping("/scheduling_scheme")
public class SchedulingSchemeController extends BaseController<SchedulingScheme,SchedulingSchemeService> {

    /**
     *调度方案对象
     */
    @Autowired
    public SchedulingSchemeController(SchedulingSchemeService service) {
        setService(service);
    }

    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        this.addMap(paramMap);
        return success(1);
    }

}
