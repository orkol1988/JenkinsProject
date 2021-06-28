package com.example.demo;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
public class ReportsController {

    private static List<ReportsDTO> m_Reports = new ArrayList<>();

    static {
        m_Reports.add(new ReportsDTO(1, "75-413-13", 5574, 130));
        m_Reports.add(new ReportsDTO(2, "35-551-87", 1451, 180));
        m_Reports.add(new ReportsDTO(3, "34-496-17", 8329, 100));
    }

    @GetMapping("/report")
    public List<ReportsDTO> getRestaurants()
    {
        return m_Reports;
    }

    @GetMapping("/report/{id}")
    public ReportsDTO getReportsById(@PathVariable("id") int id)
    {
        for(ReportsDTO r : m_Reports)
        {
            if (r.ID == id)
            {
                return r;
            }
        }
        return null;
    }

    @PostMapping("/report")
    public ResponseEntity<String> addRestaurant(@RequestBody ReportsDTO r)
    {
        m_Reports.add(r);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(
                "Custom header set", headers, HttpStatus.CREATED);
    }

    @PutMapping("/report/{id}")
    public void updateRestaurant(@PathVariable("id") int id,
                                 @RequestBody ReportsDTO update_r)
    {
        for(ReportsDTO r : m_Reports)
        {
            if (r.ID == id)
            {
                r.ID = update_r.ID;
                r.License_plate = update_r.License_plate;
                r.Driver_ID = update_r.Driver_ID;
                r.Speed = update_r.Speed;
                return;
            }
        }
    }

    @DeleteMapping("/report/{id}")
    public void delRestaurantById(@PathVariable("id") int id)
    {
        Iterator<ReportsDTO> iter = m_Reports.iterator();
        while (iter.hasNext()) {
            ReportsDTO c = iter.next();
            if (c.ID == id) {
                iter.remove();
                return;
            }
        }
    }


}
