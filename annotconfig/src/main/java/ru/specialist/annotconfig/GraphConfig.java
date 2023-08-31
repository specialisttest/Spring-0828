package ru.specialist.annotconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@ComponentScan(value = "ru.specialist.graph")
@PropertySource("graph.properties")
public class GraphConfig {

}
