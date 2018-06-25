// Created by Vince Chang

package com.macys.theclient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("BUBBA")
public interface BubbaClient {
  @RequestMapping("/bubbamsg")
  String doTheBubba();
}