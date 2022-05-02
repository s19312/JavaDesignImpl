package edu.pl.mas.s19312.mp5.demo;

import edu.pl.mas.s19312.mp5.demo.model.SGroup;
import edu.pl.mas.s19312.mp5.demo.repository.SGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final SGroupRepository sGroupRepository;

    @EventListener
    public void atStart(ContextRefreshedEvent ev){

    }
}
