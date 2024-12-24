package com.fps.svmes.services;


import com.fps.svmes.dto.dtos.qcForm.QcFormTemplateDTO;

import java.util.List;

public interface QcFormTemplateService {
    List<QcFormTemplateDTO> getAllActiveTemplates();
    QcFormTemplateDTO getTemplateById(Long id);
    QcFormTemplateDTO createTemplate(QcFormTemplateDTO dto);
    QcFormTemplateDTO updateTemplate(Long id, QcFormTemplateDTO dto);
    void deleteTemplate(Long id);
}