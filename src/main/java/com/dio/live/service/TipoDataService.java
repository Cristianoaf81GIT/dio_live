package com.dio.live.service;

import com.dio.live.config.exceptions.OcorrenciaException;
import com.dio.live.config.exceptions.TipoDataException;
import com.dio.live.dto.OcorrenciaDTO;
import com.dio.live.dto.TipoDataDTO;
import com.dio.live.model.Ocorrencia;
import com.dio.live.model.TipoData;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TipoDataService {

    private String notFoundMessage = "O elemento com id %d não foi encontrado";

    @Autowired
    private TipoDataService service;

    @Autowired
    private ModelMapper mapper;


    // continuar

    private TipoData converteToEntity(OcorrenciaDTO dto) {
        TipoData tipoData = mapper.map(dto, TipoData.class);
        return  tipoData;
    }

    private TipoDataDTO convertToDTO(TipoData tipoData) {
        TipoDataDTO dto = mapper.map(tipoData, TipoDataDTO.class);
        return dto;
    }

    private void ThrowTipoDataException(Optional<TipoData> opt, Long id) {
        String message = String.format(notFoundMessage, id);
        opt.orElseThrow(() -> new TipoDataException(message));
    }
}
