package foodGroup4Quanly.service;

import foodGroup4Quanly.entity.Tienthuenha;
import foodGroup4Quanly.entity.TienthuenhaPK;

import java.util.List;

public interface TienThueNhaService {
    List<Tienthuenha> getTienThueNhaOfYear(int year);
    Tienthuenha getById(TienthuenhaPK pk);

    void create(Tienthuenha tienthuenha);
}
