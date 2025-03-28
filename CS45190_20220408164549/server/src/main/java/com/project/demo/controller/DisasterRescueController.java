package com.project.demo.controller;

import com.project.demo.entity.DisasterRescue;
import com.project.demo.service.DisasterRescueService;
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
 *灾情救援：(DisasterRescue)表控制层
 *
 */
@RestController
@RequestMapping("/disaster_rescue")
public class DisasterRescueController extends BaseController<DisasterRescue,DisasterRescueService> {

    /**
     *灾情救援对象
     */
    @Autowired
    public DisasterRescueController(DisasterRescueService service) {
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
