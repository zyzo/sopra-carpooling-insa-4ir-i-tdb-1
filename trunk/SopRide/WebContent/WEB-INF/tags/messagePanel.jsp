<c:if test="${not empty messageContent}">
  <c:choose>
    <c:when test="${messageType eq 'ERROR'}">
      <c:set scope="request" var="_id_block" value="error-block"/>
      <c:set scope="request" var="_legend_value" value="Erreur"/>
    </c:when>
    <c:when test="${messageType eq 'WARNING'}">
      <c:set scope="request" var="_id_block" value="warning-block"/>
      <c:set scope="request" var="_legend_value" value="Warning"/>
    </c:when>
  </c:choose>

  <div id="${_id_block}" class="message-block">
    <fieldset>
      <legend>${_legend_value}</legend>
      <c:out value="${messageContent}"/>
    </fieldset>
  </div>
</c:if>
