package com.project.demo.controller;

import com.project.demo.entity.MaterialManagement;
import com.project.demo.service.MaterialManagementService;
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
 *物资管理：(MaterialManagement)表控制层
 *
 */
@RestController
@RequestMapping("/material_management")
public class MaterialManagementController extends BaseController<MaterialManagement,MaterialManagementService> {

    /**
     *物资管理对象
     */
    @Autowired
    public MaterialManagementController(MaterialManagementService service) {
        setService(service);
    }

    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        Map<String, String> mapmaterial_name = new HashMap<>();
        mapmaterial_name.put("material_name",String.valueOf(paramMap.get("material_name")));
        List listmaterial_name = service.select(mapmaterial_name, new HashMap<>()).getResultList();
        if (listmaterial_name.size()>0){
            return error(30000, "字段物资名称内容不能重复");
        }
        this.addMap(paramMap);
        return success(1);
    }

}
