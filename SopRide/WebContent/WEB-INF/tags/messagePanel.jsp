<c:if test="${not empty messageContent}">
  <c:choose>
    <c:when test="${messageType eq 'ERROR'}">
      <c:set scope="request" var="_id_block" value="error-block"/>
      <c:set scope="request" var="_class_block" value="alert-danger"/>
      <c:set scope="request" var="_icon" value="glyphicon-exclamation-sign"/>
    </c:when>
    <c:when test="${messageType eq 'WARNING'}">
      <c:set scope="request" var="_id_block" value="warning-block"/>
      <c:set scope="request" var="_class_block" value="alert-warning"/>
      <c:set scope="request" var="_icon" value="glyphicon-warning-sign"/>
    </c:when>
  </c:choose>

  <div id="${_id_block}" class="message-block alert alert-dismissible ${_class_block}" role="alert">
		<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
      <span class="glyphicon ${_icon}" aria-hidden="true"></span>
      <c:out value="${messageContent}"/>
    </fieldset>
  </div>
</c:if>
