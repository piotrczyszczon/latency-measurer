package com.piotrczyszczon.tools.performance.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController
{
  @GetMapping("/quick")
  public String quick()
  {
    return "quick-test";
  }
}
