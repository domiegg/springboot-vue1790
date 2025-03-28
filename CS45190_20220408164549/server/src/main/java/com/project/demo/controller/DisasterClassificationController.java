package com.project.demo.controller;

import com.project.demo.entity.DisasterClassification;
import com.project.demo.service.DisasterClassificationService;
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
 *灾情分类：(DisasterClassification)表控制层
 *
 */
@RestController
@RequestMapping("/disaster_classification")
public class DisasterClassificationController extends BaseController<DisasterClassification,DisasterClassificationService> {

    /**
     *灾情分类对象
     */
    @Autowired
    public DisasterClassificationController(DisasterClassificationService service) {
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
