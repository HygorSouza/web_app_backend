<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ attribute name="url" required="true" %>
<c:choose>
  <c:when test="${usuario_logado.tipo eq 2}">
  	<jsp:include page="${url}header_administrador.jsp" />
  </c:when>
  
  <c:when test="${usuario_logado.tipo eq 1}">
  	<jsp:include page="${url}header_sucionador.jsp" />
  </c:when>
  
  <c:otherwise>
  	<jsp:include page="${url}header_solicitante.jsp"/>
  </c:otherwise>
</c:choose>