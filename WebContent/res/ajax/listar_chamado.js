/**
 * 
 */
$(document).ready(function() {
	$("#consultar_chamado").on("submit", function(event) {
		
		event.preventDefault();
		var dados = $(this).serialize();
		
		$.ajax({
			type : "POST",
			url : 'consultar_chamado',
			// dataType:'json',
			data : dados,
			success : function(result) {
				// alert(result);
				$("#retorno_ajax").html(result);
			},
			error : function(result) {
				alert("error\n Nao foi possivel realizar a operacao");
			}
		});
		
	});
});
/*
 * 
 * */
