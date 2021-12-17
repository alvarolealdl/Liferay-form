<%@ include file="/META-INF/resources/init.jsp" %>

<aui:col width="50">
  <h1><liferay-ui:message key="registration.caption" /></h1>
</aui:col>

<c:if test="<%= !themeDisplay.isSignedIn() %>">
  <portlet:actionURL
    name="<%=MCVCommandNames.ADD_REGISTRATION%>"
    var="addRegistrationURL"
  >
    <portlet:param name="redirect" value="${param.redirect}" />
  </portlet:actionURL>
  <aui:form action="${addRegistrationURL}" method="post" name="fm">
    <aui:fieldset-group markupView="lexicon">
      <h2><liferay-ui:message key="personal-info" /></h2>

      <aui:row>
        <aui:col width="50">
          <aui:input
            autoFocus="<%= true %>"
            label="First Nameeeeeeeeeee"
            name="first_name"
            placeholder="First Name"
            required="true"
            type="text"
          >
            <aui:validator name="maxLength">50</aui:validator>
          </aui:input>
        </aui:col>

        <aui:col width="50">
          <aui:input
            label="Last Name"
            name="last_name"
            placeholder="Last Name"
            required="true"
            type="text"
          >
            <aui:validator name="maxLength">50</aui:validator>
          </aui:input>
        </aui:col>
      </aui:row>

      <aui:row>
        <aui:col width="50">
          <aui:input
            label="Email Address"
            name="email_address"
            placeholder="Email Address"
            required="true"
            type="email"
          >
            <aui:validator name="maxLength">255</aui:validator>
            <aui:validator name="email" />
          </aui:input>
        </aui:col>

        <aui:col width="50">
          <aui:input
            label="Username"
            name="username"
            placeholder="Username"
            required="true"
            type="text"
          >
            <aui:validator name="rangeLength">[4,16]</aui:validator>
            <aui:validator name="alphanum" />
          </aui:input>
        </aui:col>
      </aui:row>

      <aui:row>
        <aui:col width="50">
          <label>Gender</label>

          <aui:row>
            <aui:col width="50">
              <aui:input
                checked="<%= true %>"
                label="Male"
                name="male"
                type="radio"
              />
            </aui:col>

            <aui:col width="50">
              <aui:input label="Female" name="female" type="radio" />
            </aui:col>
          </aui:row>
        </aui:col>

        <aui:col width="50">
          <aui:input
            label="Birthday"
            name="birthday"
            placeholder="Birthday"
            required="true"
            type="date"
          >
            <aui:validator
              errorMessage="Must be at least 13 to register"
              name="custom"
            >
              function (val, fieldNode, ruleValue) { var val = new
              Date(Date.parse(val,"MMM dd yyyy")); var age = new Date();
              age.setFullYear(age.getFullYear() - 13 ); return (val <= age); }
            </aui:validator>
          </aui:input>
        </aui:col>
      </aui:row>

      <aui:row>
        <aui:col width="50">
          <aui:input
            label="Password"
            name="password1"
            pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}"
            placeholder="Password"
            required="true"
            title="minimum 6 characters, must contain one uppercase, one number, one special character"
            type="password"
          >
          </aui:input>
        </aui:col>

        <aui:col width="50">
          <aui:input
            label=" Confirm Password"
            name="password2"
            placeholder="Confirm Password"
            required="true"
            type="password"
          >
            <aui:validator name="equalTo"
              >"#<portlet:namespace />password1"</aui:validator
            >
          </aui:input>
        </aui:col>
      </aui:row>
    </aui:fieldset-group>

    <aui:fieldset-group markupView="lexicon">
      <h2><liferay-ui:message key="billing-info" /></h2>

      <aui:row>
        <aui:col width="50">
          <aui:input
            label="Home Phone"
            name="home_phone"
            placeholder="Home Phone"
            type="number"
          >
            <aui:validator name="maxLength">10</aui:validator>
            <aui:validator name="number" />
          </aui:input>
        </aui:col>

        <aui:col width="50">
          <aui:input
            label="Mobile Phone"
            name="mobile_phone"
            placeholder="Mobile Phone"
            type="number"
          >
            <aui:validator name="maxLength">10</aui:validator>
            <aui:validator name="number" />
          </aui:input>
        </aui:col>
      </aui:row>

      <aui:row>
        <aui:col width="50">
          <aui:input
            label="Address 1"
            name="address1"
            placeholder="Address 1"
            required="true"
            type="text"
          >
            <aui:validator name="maxLength">255</aui:validator>
          </aui:input>
        </aui:col>

        <aui:col width="50">
          <aui:input
            label="Address 2"
            name="address2"
            placeholder="Address 2"
            type="text"
          >
            <aui:validator name="maxLength">255</aui:validator>
          </aui:input>
        </aui:col>
      </aui:row>

      <aui:row>
        <aui:col width="50">
          <aui:input
            label="City"
            name="city"
            placeholder="City"
            required="true"
            type="text"
          >
            <aui:validator name="maxLength">255</aui:validator>
          </aui:input>
        </aui:col>

        <aui:col width="50">
          <aui:input
            label="State"
            name="state"
            placeholder="State"
            required="true"
            type="text"
          />
        </aui:col>
      </aui:row>

      <aui:row>
        <aui:col width="50">
          <aui:input
            label="Zip Code"
            name="zip"
            placeholder="Zip Code"
            required="true"
            type="number"
          >
            <aui:validator name="minLength">5</aui:validator>
            <aui:validator name="maxLength">5</aui:validator>
          </aui:input>
        </aui:col>

        <aui:col width="50">
          <aui:select
            label="Security Question"
            name="security_question"
            required="true"
          >
            <aui:option value="" disabled="true" selected="true" hidden="true"
              >Choose one of the following questions</aui:option
            >
            <aui:option value="Option 1"
              >What is your mother's maiden name?</aui:option
            >
            <aui:option value="Option 2"
              >What is the make of your first car?</aui:option
            >
            <aui:option value="Option 3"
              >What is your high school mascot?</aui:option
            >
            <aui:option value="Option 4"
              >Who is your favorite actor?</aui:option
            >
          </aui:select>
        </aui:col>
      </aui:row>

      <aui:input
        label="Answer"
        name="security_answer"
        placeholder="Write your answer to the Security Question here"
        type="text"
      >
        <aui:validator name="required" />
        <aui:validator name="maxLength">255</aui:validator>
      </aui:input>

      <aui:input label="Term of Use" name="accepted_tou" type="checkbox">
        <aui:validator name="required" />
      </aui:input>

      <button class="btn btn-link" onclick="modal()">Read terms of use</button>
    </aui:fieldset-group>

    <!--Buttons-->
    <liferay-frontend:edit-form-footer>
      <aui:col width="100">
        <aui:button name="submitButton" type="submit" value="save" />

        <aui:button
          href='<%= ParamUtil.getString(request, "backURL") %>'
          type="cancel"
        />
      </aui:col>
    </liferay-frontend:edit-form-footer>
  </aui:form>
</c:if>

<%@ include file="/META-INF/resources/touContent.jsp" %>

<aui:script>
  var touContent = document.getElementById("tou-content").innerHTML; function
  modal () { Liferay.Util.openModal({ title:"Terms of Use", bodyHTML: touContent
  }); }
</aui:script>
