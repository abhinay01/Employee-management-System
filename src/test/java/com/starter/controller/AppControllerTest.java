package com.starter.controller;

import com.starter.entity.Employee;
import com.starter.services.AppServices;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.math.BigDecimal;
import java.util.Collection;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = AppController.class)
@AutoConfigureMockMvc(secure=false)
public class AppControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;
    @MockBean
    private AppServices appServiceMock;
    Employee employee1;
    @Before
    public void setUpEmployee() throws Exception{
    	Employee employee1 = new Employee();
		employee1.setEmployee_id(12121);
		employee1.setFirst_name("Rakesh");
		employee1.setLast_name("Gulati");
		employee1.setEmail("rakeshgulati@gmail.com");
		employee1.setContact_number("9874561245");
		employee1.setDob("12/04/1994");
		employee1.setSex("Male");
		employee1.setUnit("MFS");
		employee1.setProfile_pic("rakesh.jpg");
		employee1.setAddress("6,Shanti Nagar,Banglore");
		employee1.setDesignation("Software Developer");
		employee1.setCity("Banglore");
		employee1.setDepartment("Developer");
		employee1.setPin("413004");
    }
    
    @Test
    public void testList() throws Exception {
    	  assertThat(this.appServiceMock).isNotNull();
          mockMvc.perform(MockMvcRequestBuilders.get("/employee"))
                  .andExpect(status().isOk())
                  .andExpect(content().contentType("text/html;charset=UTF-8"))
                  .andExpect(view().name("employees"))
                  .andExpect(MockMvcResultMatchers.view().name("employees"))
                /*  .andExpect(content().string(Matchers.containsString("BIZ Talks")))*/
                  .andDo(print());
    }
 //   @Test
   /* public void testShowEmployee() throws Exception {
        assertThat(this.appServiceMock).isNotNull();
        when(appServiceMock. getDetailById(12121)).thenReturn(employee1);
        MvcResult result= mockMvc.perform(get("/detail/{employee_id}", 12121))
                .andExpect(status().isOk())
                .andExpect(view().name("profile"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("Employee"))
                .andExpect(model().attribute("Employee", hasProperty("employee_id", is(12121))))
                .andExpect(model().attribute("Employee", hasProperty("first_name", is("Rakesh"))))
                .andExpect(model().attribute("Employee", hasProperty("last_name", is("Gulati"))))
                .andExpect(model().attribute("Employee", hasProperty("email", is("rakeshgulati@gmail.com"))))
                .andExpect(model().attribute("Employee", hasProperty("contact_number", is("9874561245"))))
                .andExpect(model().attribute("Employee", hasProperty("dob", is("12/04/1994"))))
                .andExpect(model().attribute("Employee", hasProperty("sex", is("Male"))))
                .andExpect(model().attribute("Employee", hasProperty("unit", is("MFS"))))
               .andExpect(model().attribute("Employee", hasValue("profile_pic", is("rakesh.jpg"))))
                .andExpect(model().attribute("Employee", hasProperty("address", is("6,Shanti Nagar,Banglore"))))
                .andExpect(model().attribute("Employee", hasProperty("designation", is("Software Developer"))))
                .andExpect(model().attribute("Employee", hasProperty("city", is("Banglore"))))
                .andExpect(model().attribute("Employee", hasProperty("department", is("Developer"))))
                .andExpect(model().attribute("Employee", hasProperty("pin", is("413004"))))
              
                .andReturn();
        MockHttpServletResponse mockResponse=result.getResponse();
        assertThat(mockResponse.getContentType()).isEqualTo("text/html;charset=UTF-8");
        Collection responseHeaders = mockResponse.getHeaderNames();
        assertNotNull(responseHeaders);
        assertEquals(12121, responseHeaders.size());
        assertEquals("Check for Content-Type header", "Content-Type", responseHeaders.iterator().next());
        String responseAsString=mockResponse.getContentAsString();
        assertTrue(responseAsString.contains("BIZ Talks"));
        verify(appServiceMock, times(1)). getDetailById(12121);
        verifyNoMoreInteractions(appServiceMock);
    }*/
    
    
}

