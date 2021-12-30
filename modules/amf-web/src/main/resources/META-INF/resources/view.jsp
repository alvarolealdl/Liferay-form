<%@ include file="/META-INF/resources/init.jsp" %>
<aui:container fluid="false">

<h1 class="title"><liferay-ui:message key="registration.caption" /></h1>

  <c:if test="<%= !themeDisplay.isSignedIn() %>">
    <portlet:actionURL
            name="<%=MCVCommandNames.ADD_REGISTRATION%>"
            var="addRegistrationURL"
    >
      <portlet:param name="redirect" value="${param.redirect}" />
    </portlet:actionURL>
    <aui:form action="${addRegistrationURL}" method="post" name="fm">

      <div class="personal-data">
        <h2><liferay-ui:message key="personal-info" /></h2>
        <aui:row>
          <aui:col width="50">
            <aui:input
                    autoFocus="true"
                    label="First Name:"
                    name="firstName"
                    placeholder="First Name"
                    required="true"
                    type="text"
            >
              <aui:validator name="maxLength">50</aui:validator>
            </aui:input>
          </aui:col>
          <aui:col width="50">
            <aui:input
                    label="Last Name:"
                    name="lastName"
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
                    label="Email Address:"
                    name="emailAddress"
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
                    label="Username:"
                    name="userName"
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
                <aui:input
                        label="Password:"
                        name="password"
                        pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}"
                        placeholder="Password"
                        required="true"
                        title="minimum 6 characters, must contain one uppercase, one number, one special character"
                        type="password"
                >
              </aui:input>
               </aui:col>

            <aui:col width="50">
              <label>Gender:</label>
              <aui:row>
                <div class="male">
                  <aui:col width="50">
                    <aui:input
                            checked="<%= true %>"
                            label="&nbsp;Male"
                            name="gender"
                            type="radio"
                            value="male"
                    />
                  </aui:col>
                </div>
  
                <div class="female">
                <aui:col width="50">
                  <aui:input label="&nbsp;Female" name="gender" type="radio" value="female" />
                </aui:col>
              </aui:row>
              </div>
            </aui:col>
            </aui:row>   

        <aui:row>
          <aui:col width="50">
            <aui:input
                    label="Confirm Password:"
                    name="confirmPassword"
                    placeholder="Confirm Password"
                    required="true"
                    type="password"
            >
              <aui:validator name="equalTo"
              >"#<portlet:namespace />password"</aui:validator
              >
            </aui:input>
          </aui:col>

        <aui:col width="50">
          <aui:input
                  label="Birthday:"
                  name="birthday"
                  placeholder="Birthday"
                  required="true"
                  type="date"
          >
            <aui:validator
                    errorMessage="Must be at least 13 to register."
                    name="custom"
            >
              function (val, fieldNode, ruleValue) { var val = new
              Date(Date.parse(val,"MMM dd yyyy")); var age = new Date();
              age.setFullYear(age.getFullYear() - 13 ); return (val <= age);
              }
              </aui:validator>
            </aui:input>
          </aui:col>
        
      </aui:row>
    </div>

      <div class="billing-data">
        <h2><liferay-ui:message key="billing-info" /></h2>
        <aui:row>
          <aui:col width="50">
            <aui:input
                    label="Home Phone:"
                    name="homePhone"
                    placeholder="Home Phone"
                    type="number"
            >
              <aui:validator name="maxLength">10</aui:validator>
              <aui:validator name="number" />
            </aui:input>
          </aui:col>
          <aui:col width="50">
            <aui:input
                    label="Mobile Phone:"
                    name="mobilePhone"
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
                    label="Address 1:"
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
                    label="Address 2:"
                    name="address2"
                    placeholder="Address 2"
                    type="text"
            >
              <aui:validator name="maxLength">255</aui:validator>
            </aui:input>
          </aui:col>
        </aui:row>
        <aui:row>
          <aui:col width="40">
            <aui:input
                    label="City:"
                    name="city"
                    placeholder="City"
                    required="true"
                    type="text"
            >
              <aui:validator name="maxLength">255</aui:validator>
            </aui:input>
          </aui:col>
          <aui:col width="20">
            <aui:select disabled="true" helpMessage="USA Resident" label="Country:" name="country" />
          </aui:col>
          <aui:col width="40">
            <aui:select label="State:" name="state" required="true" title="Please select some state" />   
          </aui:col>  
         
        </aui:row>
        <aui:row>
          <aui:col width="20">
            <aui:input
                    label="Zip Code:"
                    name="zipCode"
                    placeholder="Zip Code"
                    required="true"
                    type="number"
            >
              <aui:validator name="minLength">5</aui:validator>
              <aui:validator name="maxLength">5</aui:validator>
            </aui:input>
          </aui:col>
          <aui:col width="30">
            <aui:select
                    label="Security Question:"
                    name="securityQuestion"
                    required="true"
            >
              <aui:option
                      value=""
                      disabled="true"
                      selected="true"
                      hidden="true"
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
        <aui:col width="50">
          <aui:input
                label="Security Question Answer:"
                name="answer"
                placeholder="Write your answer to the Security Question here"
                required="true"
                type="text"
        >
          
          <aui:validator name="maxLength">255</aui:validator>
          </aui:input>
        </aui:col>
       
      <aui:col width="50">   
        <aui:input label="&nbsp;Term of Use" name="accepted_tou" required="true" type="checkbox" /> 
        
        <button class="btn btn-link" onclick="modal()">
          Read terms of use
        </button> 
      </aui:col>    
    </aui:row>
  </div>
      
      <!--Buttons-->
      <div class="buttons">
        <liferay-frontend:edit-form-footer>
          <aui:button name="submitButton" type="submit" value="save" />
          <aui:button
                  href='<%= ParamUtil.getString(request, "backURL") %>'
                  type="cancel"
          />
        </liferay-frontend:edit-form-footer>
      </div>
    </aui:form>
  </c:if>
</aui:container>

<!--Modal script-->
  <%@ include file="/META-INF/resources/touContent.jsp" %>
    <aui:script>
        var touContent = document.getElementById("tou-content").innerHTML; function
        modal () { Liferay.Util.openModal({ title:"Terms of Use", bodyHTML: touContent
        }); }
    </aui:script>

<!--State script-->
    <aui:script use="liferay-dynamic-select">
			    new Liferay.DynamicSelect(
				[
					{
						select: '<portlet:namespace />country',
						selectData: Liferay.Address.getCountries,
						selectDesc: 'a3',
						selectId: 'countryId',
						selectVal: '21539'
					},
					{
						select: '<portlet:namespace />state',
						selectData: Liferay.Address.getRegions,
						selectDesc: 'name',
						selectId: 'name',
						selectVal: '&lt;%= regionId %&gt;'
					}
				]
			);
		</aui:script>

  
