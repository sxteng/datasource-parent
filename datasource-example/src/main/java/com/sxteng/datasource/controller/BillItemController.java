package com.sxteng.datasource.controller;

import com.sxteng.datasource.service.BillItemService;
import com.sxteng.datasource.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("billItem")
public class BillItemController {

    @Autowired
    private BillItemService billItemService;


    @GetMapping("/billItems")
    public Object searchStudents() {
        return billItemService.selectBillItem();
    }
}
