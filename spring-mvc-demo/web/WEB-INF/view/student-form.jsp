<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Registration Form</title>
</head>
<body>

    <%--@elvariable id="student" type="com.luv2code.springdemo.mvc.Student"--%>
    <form:form action="processForm" modelAttribute="student">

        First name: <form:input path="firstName"/>

        <br/><br/>

        Last name: <form:input path="lastName"/>

        <br/><br/>

        Country:

        <form:select path="country">
            <form:options itmes="${student.countryOptions}"/>
        </form:select>

        <br/><br/>

        Favorite Language:

        Java <form:radiobutton path="favoriteLanguage" value="Java"/>
        C# <form:radiobutton path="favoriteLanguage" value="C#"/>
        PHP <form:radiobutton path="favoriteLanguage" value="PHP"/>
        Ruby <form:radiobutton path="favoriteLanguage" value="Ruby"/>

        <br/><br/>

        Operating Systems:

        Linux <form:checkbox path="operatingSystems" value="Linux"/>
        Windows <form:checkbox path="operatingSystems" value="Windows"/>
        Mac OS <form:checkbox path="operatingSystems" value="Mac OS"/>


        <br/><br/>


        <input type="submit" value="Submit">

    </form:form>


</body>
</html>
