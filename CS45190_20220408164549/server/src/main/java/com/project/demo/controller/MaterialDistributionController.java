package com.project.demo.controller;

import com.project.demo.entity.MaterialDistribution;
import com.project.demo.service.MaterialDistributionService;
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
 *物资发放：(MaterialDistribution)表控制层
 *
 */
@RestController
@RequestMapping("/material_distribution")
public class MaterialDistributionController extends BaseController<MaterialDistribution,MaterialDistributionService> {

    /**
     *物资发放对象
     */
    @Autowired
    public MaterialDistributionController(MaterialDistributionService service) {
        setService(service);
    }

    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        this.addMap(paramMap);
        String sql = "SELECT MAX(material_distribution_id) AS max FROM "+"material_distribution";
        Query select = service.runCountSql(sql);
        Integer max = (Integer) select.getSingleResult();
        sql = ("SELECT count(*) count FROM `material_management` INNER JOIN `material_distribution` ON material_management.material_name=material_distribution.material_name WHERE material_management.quantity_of_materials &#60; material_distribution.issued_quantity AND material_distribution.material_distribution_id="+max).replaceAll("&#60;","<");
        select = service.runCountSql(sql);
        Integer count = Integer.valueOf(String.valueOf(select.getSingleResult()));
        if(count>0){
            sql = "delete from "+"material_distribution"+" WHERE "+"material_distribution_id"+" ="+max;
            select = service.runCountSql(sql);
            select.executeUpdate();
            return error(30000,"库存不足!");
        }
        sql = "UPDATE `material_management` INNER JOIN `material_distribution` ON material_management.material_name=material_distribution.material_name SET material_management.quantity_of_materials = material_management.quantity_of_materials - material_distribution.issued_quantity WHERE material_distribution.material_distribution_id="+max;
        select = service.runCountSql(sql);
        select.executeUpdate();
        return success(1);
    }

}
