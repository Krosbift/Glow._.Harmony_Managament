package com.api.routes.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("activate")
public class InitController {
  @Autowired
  protected JdbcTemplate jdbcTemplate;

  @GetMapping
  public String activate() {
    return jdbcTemplate.queryForObject("SELECT 1", String.class);
  }
}
