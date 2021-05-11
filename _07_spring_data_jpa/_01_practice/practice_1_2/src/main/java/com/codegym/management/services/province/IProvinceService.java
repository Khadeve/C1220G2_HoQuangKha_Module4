package com.codegym.management.services.province;

import com.codegym.management.models.Province;

import java.util.List;

public interface IProvinceService {
    List<Province> findAll();
    Province findById(Long id);
    void save(Province province);
    void delete(Province province);
}
