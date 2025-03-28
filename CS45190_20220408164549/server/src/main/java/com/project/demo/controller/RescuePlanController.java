package com.project.demo.controller;

import com.project.demo.entity.RescuePlan;
import com.project.demo.service.RescuePlanService;
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
 *救援计划：(RescuePlan)表控制层
 *
 */
@RestController
@RequestMapping("/rescue_plan")
public class RescuePlanController extends BaseController<RescuePlan,RescuePlanService> {

    /**
     *救援计划对象
     */
    @Autowired
    public RescuePlanController(RescuePlanService service) {
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
