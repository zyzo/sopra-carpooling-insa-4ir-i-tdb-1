<c:if test="${not empty messageContent}">
  <c:choose>
    <c:when test="${messageType eq 'ERROR'}">
      <c:set scope="request" var="_id_block" value="error-block"/>
      <c:set scope="request" var="_class_block" value="alert-danger"/>
      <c:set scope="request" var="_legend_value" value="Erreur !"/>
    </c:when>
    <c:when test="${messageType eq 'WARNING'}">
      <c:set scope="request" var="_id_block" value="warning-block"/>
      <c:set scope="request" var="_class_block" value="alert-warning"/>
      <c:set scope="request" var="_legend_value" value="Attention :"/>
    </c:when>
  </c:choose>

  <div id="${_id_block}" class="message-block alert ${_class_block}" role="alert">
      <p><strong>${_legend_value}</strong></p>
      <p><c:out value="${messageContent}"/></p>
    </fieldset>
  </div>
</c:if>
