package com.fps.svmes.services;

import com.fps.svmes.dto.dtos.dispatch.DispatchDTO;
import com.fps.svmes.dto.requests.DispatchRequest;
import com.fps.svmes.models.sql.task_schedule.Dispatch;
import jakarta.validation.Valid;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Service interface for handling dispatch logic.
 */
public interface DispatchService {
    void executeDispatch(Long dispatchId);
    void scheduleDispatches();
    boolean shouldDispatch(Dispatch dispatch, LocalDateTime now);
    DispatchDTO createDispatch(@Valid DispatchRequest request);
    DispatchDTO updateDispatch(Long id, @Valid DispatchRequest request);
    DispatchDTO getDispatch(Long id);
    List<DispatchDTO> getAllDispatches();
    void deleteDispatch(Long id);
    boolean manualDispatch(Long id);
}
