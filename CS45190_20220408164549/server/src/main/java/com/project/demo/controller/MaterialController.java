package com.project.demo.controller;

import com.project.demo.entity.Material;
import com.project.demo.service.MaterialService;
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
 *物资入库：(Material)表控制层
 *
 */
@RestController
@RequestMapping("/material")
public class MaterialController extends BaseController<Material,MaterialService> {

    /**
     *物资入库对象
     */
    @Autowired
    public MaterialController(MaterialService service) {
        setService(service);
    }

    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        this.addMap(paramMap);
        String sql = "SELECT MAX(material_id) AS max FROM "+"material";
        Query select = service.runCountSql(sql);
        Integer max = (Integer) select.getSingleResult();
        sql = "UPDATE `material_management` INNER JOIN `material` ON material_management.material_name=material.material_name SET material_management.quantity_of_materials = material_management.quantity_of_materials + material.receipt_quantity WHERE material.material_id="+max;
        select = service.runCountSql(sql);
        select.executeUpdate();
        return success(1);
    }

}
