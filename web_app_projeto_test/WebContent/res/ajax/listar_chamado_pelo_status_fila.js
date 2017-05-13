/**
 * 
 */
$(document).ready(function() {
	$("#pesquisar_fila_status").on("submit", function(event) {
		
		event.preventDefault();
		var dados = $(this).serialize();
		
		$.ajax({
			type : "POST",
			url : 'pesquisar_fila_status',
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
