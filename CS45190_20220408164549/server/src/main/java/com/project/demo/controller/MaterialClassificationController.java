package com.project.demo.controller;

import com.project.demo.entity.MaterialClassification;
import com.project.demo.service.MaterialClassificationService;
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
 *物资分类：(MaterialClassification)表控制层
 *
 */
@RestController
@RequestMapping("/material_classification")
public class MaterialClassificationController extends BaseController<MaterialClassification,MaterialClassificationService> {

    /**
     *物资分类对象
     */
    @Autowired
    public MaterialClassificationController(MaterialClassificationService service) {
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
