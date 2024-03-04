package com.ism.ismecom.web.dto.request;

import com.ism.ismecom.data.entities.Client;
import com.ism.ismecom.web.dto.response.ClientShowEntityResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PanierDto {
    private List<ArticlePanierDto> articles;
    private double total;
    private Client client;


}
