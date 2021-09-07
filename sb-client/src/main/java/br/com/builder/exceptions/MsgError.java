package br.com.builder.exceptions;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MsgError implements Serializable {

	private static final long serialVersionUID = 5277455298824483872L;
	private Integer status;
	private String msg;
	private Long horario;
	
}
