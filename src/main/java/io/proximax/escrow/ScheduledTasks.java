package io.proximax.escrow;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import io.proximax.escrow.repository.EscrowRepositoryCustom;

@Component
public class ScheduledTasks {

    @Autowired
    private EscrowRepositoryCustom escrowRepositoryCustom;

    private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss sss");

    // miliseconds.
    @Scheduled(fixedDelay = 60 * 1000, initialDelay = 60 * 1000)
    public void monitor() {
        escrowRepositoryCustom.monitor();
    }
}
