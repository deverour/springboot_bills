package deverour.service;

import deverour.domain.Order;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public interface OrderService {



    public InputStream findAll() throws Exception;

    public InputStream findByList(String[] checklist,String timeList) throws Exception;

    public void saveOrder(String filepath) throws Exception;

    public void updataOrder(String filepath) throws Exception;


}
