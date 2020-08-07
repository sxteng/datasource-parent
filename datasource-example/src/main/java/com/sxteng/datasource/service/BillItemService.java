package com.sxteng.datasource.service;

import com.sxteng.datasource.bean.Student;
import com.sxteng.datasource.mapper.BillItemMapper;
import com.sxteng.datasource.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
@Service
public class BillItemService {

    @Autowired
    private BillItemMapper billItemMapper;

    public List<Map<Object,Object>> selectBillItem() {

        return billItemMapper.selectBillItem();

    }
}
