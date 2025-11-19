package com.lucas.work_well.model.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DailyAssessmentDTO {

    private Long id;

    @Min(1)
    @Max(5)
    private int humor;

    @Min(1)
    @Max(5)
    private int estresse;

    @Min(1)
    @Max(5)
    private int produtividade;

    @NotNull
    private Long userId;
    
    public DailyAssessmentDTO() {}

	public DailyAssessmentDTO(Long id, @Min(1) @Max(5) int humor, @Min(1) @Max(5) int estresse,
			@Min(1) @Max(5) int produtividade, @NotNull Long userId) {
		super();
		this.id = id;
		this.humor = humor;
		this.estresse = estresse;
		this.produtividade = produtividade;
		this.userId = userId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getHumor() {
		return humor;
	}

	public void setHumor(int humor) {
		this.humor = humor;
	}

	public int getEstresse() {
		return estresse;
	}

	public void setEstresse(int estresse) {
		this.estresse = estresse;
	}

	public int getProdutividade() {
		return produtividade;
	}

	public void setProdutividade(int produtividade) {
		this.produtividade = produtividade;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
    
    
}
