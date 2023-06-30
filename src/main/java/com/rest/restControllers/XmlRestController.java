package com.rest.restControllers;

import com.rest.Models.CdModel;
import com.rest.Models.Plant;
import com.rest.Models.XmlCurrency;
import com.rest.service.CdService;
import com.rest.service.PlantService;
import com.rest.service.XmlRead;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/xml")
public class XmlRestController {
    final XmlRead xmlRead;
    final PlantService plantService;
    final CdService cdService;

    @GetMapping("/read")
    public List<XmlCurrency>  read(){
       List<XmlCurrency> ls = xmlRead.result();
        return  ls;
    }

    @GetMapping("/plants")
    public List<Plant> plants(){
        List<Plant> list = plantService.plantList();
        return list;
    }

    @GetMapping("/cd")
    public List<CdModel> cdList(){
        List<CdModel> cdList = cdService.cdModelList();
        return cdList;
    }


}
