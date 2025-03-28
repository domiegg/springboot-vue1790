package com.project.demo.controller;

import com.project.demo.entity.Auditor;
import com.project.demo.service.AuditorService;
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
 *审核员：(Auditor)表控制层
 *
 */
@RestController
@RequestMapping("/auditor")
public class AuditorController extends BaseController<Auditor,AuditorService> {

    /**
     *审核员对象
     */
    @Autowired
    public AuditorController(AuditorService service) {
        setService(service);
    }

    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        Map<String, String> mappersonnel_number = new HashMap<>();
        mappersonnel_number.put("personnel_number",String.valueOf(paramMap.get("personnel_number")));
        List listpersonnel_number = service.select(mappersonnel_number, new HashMap<>()).getResultList();
        if (listpersonnel_number.size()>0){
            return error(30000, "字段人员编号内容不能重复");
        }
        this.addMap(paramMap);
        return success(1);
    }

}
