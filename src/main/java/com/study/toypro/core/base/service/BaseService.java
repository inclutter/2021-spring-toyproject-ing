package com.study.toypro.core.base.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseService {
    protected transient Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected ObjectMapper objectMapper;
}
