package com.vironit.pharmacy.service;

import com.vironit.pharmacy.model.Medicine;

import java.io.IOException;
import java.util.ArrayList;

public interface MedicineService {

    void createMedicine();

    void deleteMedicine();

    void changeMedicine();

    ArrayList<Medicine> getListMedicine() throws IOException;
}
