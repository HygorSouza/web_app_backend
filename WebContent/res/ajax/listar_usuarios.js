/**
 * 
 */
$(document).ready(function() {
	$("#consultar_usuario").on("submit", function(event) {
		
		event.preventDefault();
		var dados = $(this).serialize();
		
		$.ajax({
			type : "POST",
			url : 'consultar_usuario',
			// dataType:'json',
			data : dados,
			success : function(result) {
				// alert(result);
				$("#table_usuario").html(result);
			},
			error : function(result) {
				alert("error\n Nao foi possivel realizar a operacao");
			}
		});
		
	});
});
/**
 * 
 */
$("#delete-modal").on('show.bs.modal', function(event) {
    var button = $(event.relatedTarget); //botao que disparou a modal
      var recipient = button.data('usuario');
   $("#id_excluir").val(recipient);
});