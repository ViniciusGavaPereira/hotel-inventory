package com.hotel.hotel.http;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hotel.hotel.dto.ScheduleDto;

@FeignClient("hotel-schedules-ms")
public interface ScheduleClient {

    @RequestMapping(method = RequestMethod.GET, value = "/schedule/id/{id}")
    ScheduleDto findById(@PathVariable Integer id);
}
